/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

import db.actions.UnitOfWork;
import db.mappers.GroundRepossitoryMapper;
import db.mappers.PlayerRepositoryMapper;
import db.mappers.TeamMemberMapper;
import db.mappers.TeamRepositoryMapper;
import db.mappers.TournamentRepositoryMapper;
import db.mappers.TournamentTeamMapper;
import db.repositories.GroundRepository;
import db.repositories.PlayerRepository;
import db.repositories.TeamMemberRepository;
import db.repositories.TeamRepository;
import db.repositories.TournamentRepository;
import db.repositories.TournamentTeamRepository;
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

        //Try catch w srodku
        //tryWSrodku();
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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            System.err.println(connection.isClosed());
        } catch (SQLException exc) {
            //Cant establish connection to DB
            LOG.addLog(YoungFifaChampions.class, Logger.LogType.ERROR, exc);
        }

        //InitializeRepositories
        REPOS = new Repositories();
//        Add all repositories            
        REPOS.addRepository(new GroundRepository(connection,new GroundRepossitoryMapper(), new UnitOfWork(connection)));
//        REPOS.getRepositoryByClass(repositoryClass)
        REPOS.addRepository(new PlayerRepository(connection,new PlayerRepositoryMapper(), new UnitOfWork(connection)));
        REPOS.addRepository(new TeamRepository(connection, new TeamRepositoryMapper(), new UnitOfWork(connection)));
        REPOS.addRepository(new TeamMemberRepository(connection, new TeamMemberMapper(), new UnitOfWork(connection)));
        REPOS.addRepository(new TournamentRepository(connection, new TournamentRepositoryMapper(), new UnitOfWork(connection)));
        REPOS.addRepository(new TournamentTeamRepository(connection, new TournamentTeamMapper(), new UnitOfWork(connection)));
        REPOS.addRepository(new TournamentRepository(connection,new TournamentRepositoryMapper(),new UnitOfWork(connection)));
//        YoungFifaChampions.REPOS.getRepositoryByClass(PlayerRepository.class).;

    }

//    public static void show() {
//        YoungFifaChampions.LOG.addLog(YoungFifaChampions.class, Logger.LogType.DEBUG, "show()");
//
//        System.err.println(YoungFifaChampions.PARAMS.VERBOSE_MODE);
//    }
//
//    public static boolean metdaThrowujacaError() throws Exception {
//        boolean czyRzucacError = true;
//        if (!czyRzucacError) {
//            System.err.println("Nie rzucamy errora");
//        } else {
//            System.err.println("Rzucamy errora");
//            throw (new Exception("nasz error z metdaThrowujacaError()"));
//        }
//        return true;
//    }
//
//    public static void tryWSrodku() {
//
//        try {
//
//            if (true) {
//
//            } else {
//                throw new Exception("Rzucam w srodku funkcji");
//            }
//        } catch (Exception e) {
//            System.err.println("jesteśmy w catchu w tryWSrodku");
//            System.err.println(e.getMessage());
//
//        }
//
//    }
}
