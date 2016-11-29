/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.Ground;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class GroundRepossitoryMapper implements IMapResultSetIntoEntity<Ground> {

    @Override
    public Ground map(ResultSet rs) {
        YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");

        Integer id;
        String address;

        try {

            id = rs.getInt("ID");
            address = rs.getString("ADDRESS");

        } catch (SQLException e) {
            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            //never returns null cause log stops app
            return null;
        }

        return new Ground(id, address);
    }

}
