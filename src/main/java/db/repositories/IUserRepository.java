/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.repositories;

import db.classes.User;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IUserRepository {
    
    public User getUserByName(String name);
    
    
}
