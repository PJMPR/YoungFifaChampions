/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.TeamMember;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TeamMemberMapper implements IMapResultSetIntoEntity<TeamMember>{
    
    @Override
    public TeamMember map(ResultSet rs) {
        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        Integer teamId;
        Integer playerId;
        Boolean isCaptain;

        try {

            id = rs.getInt("ID");
            teamId = rs.getInt("TEAM_ID");
            playerId = rs.getInt("PLAYER_ID");
            isCaptain = rs.getBoolean("IS_CAPTAIN");

        } catch (SQLException e) {
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, e);
            
            //never returns null cause log stops app
            return null;
        }

        return new  TeamMember(id, teamId, playerId, isCaptain);

    }
    
}
