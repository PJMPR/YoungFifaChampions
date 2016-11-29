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
public class Player implements IHaveId{
    
    private final Integer id;
    
    private final String name;
    
    private final String surname;
    
    private final String contactNumber;
    
    private final Integer userId;

    public Player(Integer id, String name, String surname, String contactNumber, Integer userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contactNumber = contactNumber;
        this.userId = userId;
    }


    @Override
    public Integer getId() {
       return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Integer getUserId() {
        return userId;
    }
    
    
    
}
