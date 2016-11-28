/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

import db.mappers.TeamRepositoryMapper;
import db.repositories.TeamRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class YoungFifaChampions {

    /**
     * Application Log object.
     */
    public static Logger LOG;

    /**
     * Input parameters object
     */
    public static Params PARAMS;

    public static Repositories REPOS;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            //Params initialization
            if (args.length > 0) {
                PARAMS = new Params(args[0]);
            } else {
                PARAMS = new Params(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Initialize Logger
        LOG = new Logger(PARAMS.LOG_FILE_PATH, PARAMS.IS_FILE_APPEND, PARAMS.VERBOSE_MODE);

        //Initialize DBConnection
        Connection connection=null;
        try {
             connection=DriverManager.getConnection("");
        } catch (SQLException exc) {
            //Cant establish connection to DB
            LOG.addLog(YoungFifaChampions.class, Logger.LogType.ERROR, exc);
        }

        //InitializeRepositories
        REPOS = new Repositories();
        //Add all repositories
        REPOS.addRepository(new TeamRepository(connection, new TeamRepositoryMapper()));

    }

    public static void show() {
        YoungFifaChampions.LOG.addLog(YoungFifaChampions.class, Logger.LogType.DEBUG, "show()");

        System.err.println(YoungFifaChampions.PARAMS.VERBOSE_MODE);
    }

}
