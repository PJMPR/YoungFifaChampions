/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Player;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class PlayerRepositoryMapper implements IMapResultSetIntoEntity<Player> {

    @Override
    public Player map(ResultSet rs) {
        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        String name;
        String surname;
        String phoneNumber;
        Integer userId;

        try {

            id = rs.getInt("ID");
            name = rs.getString("NAME");
            surname = rs.getString("SURNAME");
            phoneNumber = rs.getString("PHONE_NUMBER");
            userId = rs.getInt("USER_ID");
        } catch (SQLException e) {
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new Player(id, name, surname, phoneNumber, userId);

    }

}
