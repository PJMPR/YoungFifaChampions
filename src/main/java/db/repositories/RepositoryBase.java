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

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public abstract class RepositoryBase<TEntity extends IHaveId> implements IRepository<TEntity>, IRepositorySqlGetter {

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

    
    private void createTableIfnotExists() throws SQLException {
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
}
