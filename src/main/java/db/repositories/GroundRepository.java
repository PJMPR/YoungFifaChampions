/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.actions.IUnitOfWork;
import db.classes.Ground;
import db.mappers.IMapResultSetIntoEntity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class GroundRepository extends RepositoryBase<Ground> {

    private final static String TABLE_NAME = "GROUNDS";

    public GroundRepository(Connection connection, IMapResultSetIntoEntity<Ground> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }


    
    @Override
    public String createTableSql() {
        return "create table "
                + tableName()
                + " ("
                + "ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,"
                + "ADDRESS varchar(100)";

    }

    @Override
    public String insertSql() {
        return "INSERT INTO "
                + tableName()
                + " (ADDRESS) "
                + "VALUES "
                + "(?)";
    }

    @Override
    public void insertPrepare(Ground entity) throws SQLException {
        insert.setString(1, entity.getAddress());
    }

    @Override
    public String updateSql() {
        return "UPDATE "
                + tableName()
                + " set (ADDRESS)="
                + "(?) "
                + "where id = ?";
    }

    @Override
    public void updatePrepare(Ground entity) throws SQLException {
        update.setString(1, entity.getAddress());
        update.setInt(2, entity.getId());
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

}
