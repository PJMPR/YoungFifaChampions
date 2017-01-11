/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Tournament;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TournamentRepositoryMapper implements IMapResultSetIntoEntity<Tournament> {

    enum typ {
        typ1,
        typ2
    }

    @Override
    public Tournament map(ResultSet rs) {

//        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        Date tournamentDate;
        Integer organizerId;
        String address;
        String name;
        

        try {

            id = rs.getInt("ID");
            tournamentDate = rs.getDate("TOURNAMENT_DATE");
            organizerId = rs.getInt("ORGANIZER_ID");
            address = rs.getString("ADDRESS");
            name= rs.getString("NAME");
            

        } catch (SQLException e) {
//            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new Tournament(id, tournamentDate,address, organizerId, name);

    }

}
