/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.actions.IUnitOfWork;
import db.classes.Tournament;
import db.mappers.IMapResultSetIntoEntity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TournamentRepository extends RepositoryBase<Tournament> {

    private final static String TABLE_NAME = "TOURNAMENTS";

    public TournamentRepository(Connection connection, IMapResultSetIntoEntity<Tournament> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    

    @Override
    public String createTableSql() {
        return "create table "
                + tableName()
                + " ("
                + "ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,"
                + "TOURNAMENT_DATE DATE,"
                + "DESCRIPTION VARCHAR2(100),"
                + "GROUND_ID INT ,"
                + "ORGANIZER_ID INT ,"
                + "FOREIGN KEY (GROUND_ID) REFERENCES GROUNDS(ID),"
                + "FOREIGN KEY (ORGANIZER_ID) REFERENCES PLAYERS(ID))";

    }

    @Override
    public String insertSql() {
        return "INSERT INTO "
                + tableName()
                + " (TOURNAMENT_DATE,DESCRIPTION,GROUND_ID,ORGANIZER_ID) "
                + "VALUES "
                + "(?,?,?,?)";
    }

    @Override
    public void insertPrepare(Tournament entity) throws SQLException {
        insert.setDate(1, entity.getStartDate());
        insert.setString(2, entity.getDescription());
        insert.setInt(3, entity.getGroundId());
        insert.setInt(4, entity.getOrganizerPersonId());
    }

    @Override
    public String updateSql() {
        return "UPDATE "
                + tableName()
                + " set (TOURNAMENT_DATE,DESCRIPTION,GROUND_ID,ORGANIZER_ID)="
                + "(?,?,?,?)"
                + "where id = ?";
    }

    @Override
    public void updatePrepare(Tournament entity) throws SQLException {
        update.setDate(1, entity.getStartDate());
        update.setString(2, entity.getDescription());
        update.setInt(3, entity.getGroundId());
        update.setInt(4, entity.getOrganizerPersonId());
        update.setInt(5, entity.getId());
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }
}
