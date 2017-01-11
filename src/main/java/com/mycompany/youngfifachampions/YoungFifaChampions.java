/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

import db.classes.User;
import db.repositories.TeamRepository;
import db.repositories.UserRepository;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class YoungFifaChampions {

    private static YoungFifaChampions init;

    /**
     * Application Log object.
     */
    //private static Logger LOG;

    /**
     * Input parameters object
     */
    //public static Params PARAMS;
    
    
    
    public static void main(String[] args){
        
        try{
        Repositories repo = new Repositories();
            User newUser = repo.getUserRepository().getUserByName("nn");
            if (newUser != null) {
                System.err.println("null");
                return;
            }
            
            UserRepository ur = repo.getUserRepository();
            ur.add(new User("nn", "nn", "nn"));
            repo.saveAndQuit();
            
            newUser = ur.getUserByName("nn");
            System.err.println(newUser);
            
            System.err.println(repo.getTeamRepository().getTeamByUserId(newUser.getId()));
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
