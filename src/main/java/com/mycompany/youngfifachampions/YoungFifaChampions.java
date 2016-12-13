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

    }
}
