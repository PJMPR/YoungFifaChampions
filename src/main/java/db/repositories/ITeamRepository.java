/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.classes.Team;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface ITeamRepository {
    
    public Team getTeamByUserId(Integer id);
    
}
