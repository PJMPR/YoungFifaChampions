/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.TournamentResults;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TournamentResultsMapper implements IMapResultSetIntoEntity<TournamentResults> {

    @Override
    public TournamentResults map(ResultSet rs) {

//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        Integer tournamentId;
        Integer firstPlaceId;
        Integer secondPlaceId;
        Integer thirdPlaceId;

        try {

            id = rs.getInt("ID");
            tournamentId = rs.getInt("TOURNAMENT_ID");
            firstPlaceId = rs.getInt("ID_TEAM_1_PLACE");
            secondPlaceId = rs.getInt("ID_TEAM_2_PLACE");
            thirdPlaceId = rs.getInt("ID_TEAM_3_PLACE");

        } catch (SQLException e) {
//            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new TournamentResults(id, tournamentId, firstPlaceId, secondPlaceId, thirdPlaceId);

    }

}
