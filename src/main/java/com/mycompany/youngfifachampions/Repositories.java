/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youngfifachampions;

import db.repositories.RepositoryBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Repositories {

    //ListOfRepositories
    private final List<RepositoryBase> repositoryList;

    
    public Repositories() {
        repositoryList = new ArrayList<>();
    }
    
    
    public void addRepository(RepositoryBase repo){
        repositoryList.add(repo);
    }
    
    public void addRepository(RepositoryBase... repos){
        for(RepositoryBase repo:repos){
            repositoryList.add(repo);
        }
    }

}
