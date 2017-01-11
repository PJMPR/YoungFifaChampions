/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.actions.Entity;
import db.actions.IUnitOfWork;
import db.actions.IUnitOfWorkRepository;
import db.classes.IHaveId;
import db.mappers.IMapResultSetIntoEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public abstract class RepositoryBase<TEntity extends IHaveId> implements IRepository<TEntity>, IRepositorySqlGetter, IRepositoryPrepareStatements<TEntity>, IUnitOfWorkRepository {

    protected Connection connection;

    protected PreparedStatement insert;
    protected PreparedStatement selectById;
    protected PreparedStatement update;
    protected PreparedStatement delete;
    protected PreparedStatement selectAll;
    protected IUnitOfWork uow;
    protected IMapResultSetIntoEntity<TEntity> mapper;

    public Connection getConnection() {
        return connection;
    }

    protected RepositoryBase(Connection connection,
            IMapResultSetIntoEntity<TEntity> mapper, IUnitOfWork uow) {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "RepositoryBase()");
        this.connection = connection;
        this.uow = uow;
        try {
            this.mapper = mapper;
            createTableIfnotExists();
            insert = connection.prepareStatement(insertSql());
            selectById = connection.prepareStatement(getSql());
            update = connection.prepareStatement(updateSql());
            delete = connection.prepareStatement(deleteSql());
            selectAll = connection.prepareStatement(getAllSql());
            connection.commit();
        } catch (SQLException ex) {
//            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, ex);
        }
    }

    @Override
    public void createTableIfnotExists() throws SQLException {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "createTableIfnotExists()");

        Statement createTable = this.connection.createStatement();
        boolean tableExists = false;

        ResultSet rs = connection.getMetaData().getTables(null, null, null,
                null);

        while (rs.next()) {
            if (rs.getString("Table_Name").equalsIgnoreCase(tableName())) {
                tableExists = true;
                break;
            }
        }
        if (!tableExists) {
            createTable.executeUpdate(createTableSql());
        }
    }

    @Override
    public List<TEntity> getAll() {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "getAll()");
        try {
            ResultSet rs = selectAll.executeQuery();
            List<TEntity> result = new ArrayList<TEntity>();
            while (rs.next()) {
                result.add(mapper.map(rs));
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public TEntity get(TEntity entity) throws SQLException {
        getPrepare(entity);
        return mapper.map(selectById.executeQuery());

    }

    public void add(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsNew(ent);

    }

    @Override
    public void delete(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsDeleted(ent);
    }

    @Override
    public void update(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsChanged(ent);
    }

    @Override
    public void persistUpdate(Entity entity) {
        try {
            updatePrepare((TEntity) entity.getEntity());
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void persistAdd(Entity entity) {
        try {
            insertPrepare((TEntity) entity.getEntity());
            insert.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void persistDelete(Entity entity) {
        try {
            deletePrepare((TEntity) entity.getEntity());
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(TEntity entity) throws SQLException {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "insert()");

        insertPrepare(entity);

        insert.execute();
    }

    @Override
    public String getAllSql() {
        return "SELECT * FROM " + tableName();
    }

    @Override
    public String deleteSql() {
        return "DELETE FROM "
                + tableName()
                + " where id = ?";
    }

    @Override
    public void deletePrepare(TEntity entity) throws SQLException {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "deletePrepare()");

        delete.setInt(1, entity.getId());
    }

    @Override
    public void getPrepare(TEntity entity) throws SQLException {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "getPrepare()");
        selectById.setInt(1, entity.getId());
    }

    @Override
    public String getSql() {
        return " select * from "
                + tableName()
                + " where id = ?";
    }

}
