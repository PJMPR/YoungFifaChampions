/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

import db.actions.IUnitOfWork;
import db.actions.UnitOfWork;
import db.mappers.GroundRepossitoryMapper;
import db.mappers.PlayerRepositoryMapper;
import db.mappers.TeamMemberMapper;
import db.mappers.TeamRepositoryMapper;
import db.mappers.TournamentRepositoryMapper;
import db.mappers.TournamentResultsMapper;
import db.mappers.TournamentTeamMapper;
import db.repositories.GroundRepository;
import db.repositories.PlayerRepository;
import db.repositories.TeamMemberRepository;
import db.repositories.TeamRepository;
import db.repositories.TournamentRepository;
import db.repositories.TournamentResultsRepository;
import db.repositories.TournamentTeamRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Repositories {

    private final static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/workdb";

    private IUnitOfWork uow;
    private Connection connection;

    //Repositories
    private GroundRepository gr;
    private PlayerRepository plr;
    private TeamMemberRepository tmr;
    private TeamRepository tr;
    private TournamentRepository tour;
    private TournamentResultsRepository trr;
    private TournamentTeamRepository tteamr;

    private Connection getNewConnection() throws SQLException {

        return DriverManager.getConnection(CONNECTION_STRING);
    }

    private IUnitOfWork getNewUow() {
        return new UnitOfWork(connection);
    }

    public void setUow(IUnitOfWork uow) {
        this.uow = uow;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Repositories() throws SQLException {

        setConnection(getNewConnection());
        setUow(getNewUow());

    }

    public GroundRepository getGroundRepository() {
        if (gr == null) {
            gr = new GroundRepository(connection, new GroundRepossitoryMapper(), uow);
        }
        return gr;
    }

    public PlayerRepository getPlayerRepository() {
        if (plr == null) {
            plr = new PlayerRepository(connection, new PlayerRepositoryMapper(), uow);
        }
        return plr;
    }

    public TeamMemberRepository getMemberRepository() {
        if (tmr == null) {
            tmr = new TeamMemberRepository(connection, new TeamMemberMapper(), uow);
        }
        return tmr;
    }

    public TeamRepository getTeamRepository() {
        if (tr == null) {
            tr = new TeamRepository(connection, new TeamRepositoryMapper(), uow);
        }
        return tr;
    }

    public TournamentRepository getTournamentRepository() {
        if (tour == null) {
            tour = new TournamentRepository(connection, new TournamentRepositoryMapper(), uow);
        }
        return tour;
    }

    public TournamentResultsRepository getTournamentResultsRepository() {
        if (trr == null) {
            trr = new TournamentResultsRepository(connection, new TournamentResultsMapper(), uow);
        }
        return trr;
    }

    public TournamentTeamRepository getTournamentTeamRepository() {
        if (tteamr == null) {
            tteamr = new TournamentTeamRepository(connection, new TournamentTeamMapper(), uow);
        }
        return tteamr;
    }

}
