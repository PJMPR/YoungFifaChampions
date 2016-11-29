/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.actions.IUnitOfWork;
import db.classes.TournamentResults;
import db.mappers.IMapResultSetIntoEntity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TournamentResultsRepository extends RepositoryBase<TournamentResults> {

    private final static String TABLE_NAME = "TOURNAMENTS";

    public TournamentResultsRepository(Connection connection, IMapResultSetIntoEntity<TournamentResults> mapper, IUnitOfWork uow) {
        super(connection, mapper, uow);
    }

    

    @Override
    public String createTableSql() {
        return "create table "
                + tableName()
                + " ("
                + "ID INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,"
                + "TOURNAMENT_ID INT,"
                + "ID_TEAM_1_PLACE INT,"
                + "ID_TEAM_2_PLACE INT,"
                + "ID_TEAM_3_PLACE INT,"
                + "FOREIGN KEY (TOURNAMENT_ID) REFERENCES TOURNAMETS(ID),"
                + "FOREIGN KEY (ID_TEAM_1_PLACE) REFERENCES TEAMS(ID),"
                + "FOREIGN KEY (ID_TEAM_2_PLACE) REFERENCES TEAMS(ID),"
                + "FOREIGN KEY (ID_TEAM_3_PLACE) REFERENCES TEAMS(ID))";

    }

    @Override
    public String insertSql() {
        return "INSERT INTO "
                + tableName()
                + " (TOURNAMENT_ID,ID_TEAM_1_PLACE,ID_TEAM_2_PLACE,ID_TEAM_3_PLACE) "
                + "VALUES "
                + "(?,?,?,?)";
    }

    @Override
    public void insertPrepare(TournamentResults entity) throws SQLException {
        insert.setInt(1, entity.getTournamentId());
        insert.setInt(2, entity.getFirstPlaceTeamId());
        insert.setInt(3, entity.getSecondPlaceTeamId());
        insert.setInt(4, entity.getThirdPlaceTeamId());
    }

    @Override
    public String updateSql() {
        return "UPDATE "
                + tableName()
                + " set (TOURNAMENT_ID,ID_TEAM_1_PLACE,ID_TEAM_2_PLACE,ID_TEAM_3_PLACE)="
                + "(?,?,?,?)"
                + "where id = ?";
        
    }

    @Override
    public void updatePrepare(TournamentResults entity) throws SQLException {
        update.setInt(1, entity.getTournamentId());
        update.setInt(2, entity.getFirstPlaceTeamId());
        update.setInt(3, entity.getSecondPlaceTeamId());
        update.setInt(4, entity.getThirdPlaceTeamId());
        update.setInt(5, entity.getId());
    }

    @Override
    public String tableName() {
        return TABLE_NAME;
    }
}
