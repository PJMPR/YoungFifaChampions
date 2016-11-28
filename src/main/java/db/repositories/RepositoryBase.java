/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.IHaveId;
import db.mappers.IMapResultSetIntoEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public abstract class RepositoryBase<TEntity extends IHaveId> implements IRepository<TEntity>, IRepositorySqlGetter,IRepositoryPrepareStatements<TEntity> {

    protected Connection connection;

    protected PreparedStatement insert;
    protected PreparedStatement selectById;
    protected PreparedStatement update;
    protected PreparedStatement delete;
    protected PreparedStatement selectAll;

    protected IMapResultSetIntoEntity<TEntity> mapper;

    public Connection getConnection() {
        return connection;
    }

    protected RepositoryBase(Connection connection,
            IMapResultSetIntoEntity<TEntity> mapper) {
        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "RepositoryBase()");
        this.connection = connection;
        try {
            this.mapper = mapper;
            createTableIfnotExists();
            insert = connection.prepareStatement(insertSql());
            selectById = connection.prepareStatement(getSql());
            update = connection.prepareStatement(updateSql());
            delete = connection.prepareStatement(deleteSql());
            selectAll = connection.prepareStatement(getAllSql());
        } catch (SQLException ex) {
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, ex);
        }
    }

    @Override
    public void createTableIfnotExists() throws SQLException {
        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "createTableIfnotExists()");

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
    public TEntity get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TEntity> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(TEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
}
