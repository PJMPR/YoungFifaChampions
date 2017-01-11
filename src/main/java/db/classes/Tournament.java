/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.classes;

import com.mycompany.youngfifachampions.Repositories;
import java.sql.Date;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Tournament implements IHaveId{

    private final Integer id;
    private final Date startDate;
    private final String address;
    private final Integer organizerPersonId;
    private final String name;
    
    public Tournament(Integer id, Date startDate, String address, Integer organizerPersonId,String name) {
        this.id = id;
        this.startDate = startDate;
        this.address = address;
        this.organizerPersonId = organizerPersonId;
        this.name=name;
        
    }

    public Date getStartDate() {
        return startDate;
    }

    public Integer getOrganizerPersonId() {
        return organizerPersonId;
    }
    
    @Override
    public Integer getId() {
    return this.id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
    
    
    
    
    
}
