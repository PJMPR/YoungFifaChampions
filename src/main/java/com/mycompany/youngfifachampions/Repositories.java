/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

import db.actions.IUnitOfWork;
import db.actions.UnitOfWork;
import db.mappers.TeamRepositoryMapper;
import db.mappers.TournamentRepositoryMapper;
import db.mappers.TournamentResultsMapper;
import db.mappers.TournamentTeamMapper;
import db.mappers.UserRepositoryMapper;
import db.repositories.TeamRepository;
import db.repositories.TournamentRepository;
import db.repositories.TournamentResultsRepository;
import db.repositories.TournamentTeamRepository;
import db.repositories.UserRepository;
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
    private TeamRepository tr;
    private TournamentRepository tour;
    private TournamentResultsRepository trr;
    private TournamentTeamRepository tteamr;
    private UserRepository ur;

    private Connection getNewConnection() throws SQLException,ClassNotFoundException{

        Class.forName("org.hsqldb.jdbcDriver");
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

    public Repositories() throws SQLException,ClassNotFoundException{

        setConnection(getNewConnection());
        setUow(getNewUow());

    }

    public void saveAndQuit() {
        uow.saveChanges();
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public UserRepository getUserRepository() {
        if (ur == null) {
            ur = new UserRepository(connection, new UserRepositoryMapper(), uow);
        }
        return ur;
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
