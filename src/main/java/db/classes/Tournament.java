/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.classes;

import java.sql.Date;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Tournament implements IHaveId{

    private final Integer id;
    private final Date startDate;
    private final String description;
    private final Integer organizerPersonId;
    private final Integer groundId;

    public Tournament(Integer id, Date startDate, String description, Integer organizerPersonId, Integer groundId) {
        this.id = id;
        this.startDate = startDate;
        this.description = description;
        this.organizerPersonId = organizerPersonId;
        this.groundId = groundId;
    }
    
    
    
    
    @Override
    public Integer getId() {
    return this.id;
    }
    
    
    
    
}
