/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Team;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TeamRepositoryMapper implements IMapResultSetIntoEntity<Team> {

    @Override
    public Team map(ResultSet rs) {
        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        String name;
        String description;
        Integer groundId;

        try {

            id = rs.getInt("ID");
            name = rs.getString("NAME");
            description = rs.getString("DESCRIPTION");
            groundId = rs.getInt("GROUND_ID");

        } catch (SQLException e) {
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new Team(id, name, description, groundId);

    }

}
