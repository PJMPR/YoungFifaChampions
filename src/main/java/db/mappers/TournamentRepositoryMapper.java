/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Team;
import db.classes.Tournament;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TournamentRepositoryMapper implements IMapResultSetIntoEntity<Tournament> {

    @Override
    public Tournament map(ResultSet rs) {

        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        Date tournamentDate;
        String description;
        Integer groundId;
        Integer organizerId;

        try {

            id = rs.getInt("ID");
            tournamentDate = rs.getDate("TOURNAMENT_DATE");
            description = rs.getString("DESCRIPTION");
            groundId = rs.getInt("GROUND_ID");
            organizerId = rs.getInt("ORGANIZER_ID");

        } catch (SQLException e) {
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new Tournament(id, tournamentDate, description, organizerId, groundId);

    }

}
