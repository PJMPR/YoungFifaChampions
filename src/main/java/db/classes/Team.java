/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.classes;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Team implements IHaveId {

    //Class params
    private final Integer id;

    private String name;
    
    private final Integer idUsera;


    public Team(Integer id, String name,Integer idUsera) {
        this.id = id;
        this.name = name;
        this.idUsera=idUsera;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getIdUsera() {
        return idUsera;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    

}
