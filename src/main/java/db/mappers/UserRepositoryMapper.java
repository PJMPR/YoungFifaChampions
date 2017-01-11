/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.mappers;

import com.mycompany.youngfifachampions.Logger;
import com.mycompany.youngfifachampions.YoungFifaChampions;
import db.classes.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class UserRepositoryMapper implements IMapResultSetIntoEntity<User> {

    @Override
    public User map(ResultSet rs) {

//         YoungFifaChampions.LOG.addLog(this, Logger.LogType.DEBUG, "map");
        Integer id=null;
        String login=null;
        String password=null;
        String email=null;

        try {
                id = rs.getInt("ID");
                login = rs.getString("LOGIN");
                password = rs.getString("PASSWORD");
                email = rs.getString("EMAIL");
        } catch (SQLException e) {
//            YoungFifaChampions.LOG.addLog(this, Logger.LogType.ERROR, "map");
            System.err.println(e);
            return null;
        }

        return new User(id, login, password, email);

    }

}
