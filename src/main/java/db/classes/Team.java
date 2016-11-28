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
public class Team implements IHaveId{

    
    //Class params
    private final Integer id;
    
    private final String nazwa;
    
    private final String opis;
    
    private final Integer idDomowegoBoiska;

    public Team(Integer id, String nazwa, String opis, Integer idDomowegoBoiska) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.idDomowegoBoiska = idDomowegoBoiska;
    }
    
    
    
    @Override
    public Integer getId() {
        return id;
    }
    
    
    
}
