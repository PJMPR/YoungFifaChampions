/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.actions.IUnitOfWork;
import db.classes.Team;
import db.mappers.IMapResultSetIntoEntity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TeamRepository extends RepositoryBase<Team> {

    private final static String TABLE_NAME = "TEAM";

    public TeamRepository(Connection connection, IMapResultSetIntoEntity<Team> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    
    @Override
    public String createTableSql() {
        return "create table "
                + tableName()
                + " ("
                + "ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,"
                + "NAME varchar(20),"
                + "DESCRIPTION VARCHAR2(100),"
                + "GROUND_ID INT ,"
                + "FOREIGN KEY (GROUND_ID) REFERENCES GROUNDS(ID))";

    }

    @Override
    public String insertSql() {
        return "INSERT INTO "
                + tableName()
                + " (NAME,DESCRIPTION,GROUND_ID) "
                + "VALUES "
                + "(?,?,?)";
    }

    @Override
    public void insertPrepare(Team entity) throws SQLException {
        insert.setString(1, entity.getName());
        insert.setString(2, entity.getDescription());
        insert.setInt(3, entity.getHomeGroundId());
    }

    @Override
    public String updateSql() {
        return "UPDATE "
                + tableName()
                + " set (NAME,DESCRIPTION,GROUND_ID)="
                + "(?,?,?)"
                + "where id = ?";
    }

    @Override
    public void updatePrepare(Team entity) throws SQLException {
        update.setString(1, entity.getName());
        update.setString(2, entity.getDescription());
        update.setInt(3, entity.getHomeGroundId());
        update.setInt(4, entity.getId());

    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }

}
