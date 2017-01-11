/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Team;
import db.classes.TournamentTeam;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TournamentTeamMapper implements IMapResultSetIntoEntity<TournamentTeam> {

    @Override
    public TournamentTeam map(ResultSet rs) {
//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        Integer tournamentID;
        Integer teamId;

        try {

            id = rs.getInt("ID");
            tournamentID = rs.getInt("TOURNAMENT_ID");
            teamId = rs.getInt("TEAM_ID");

        } catch (SQLException e) {
//            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new TournamentTeam(id, tournamentID, teamId);
    }

}
