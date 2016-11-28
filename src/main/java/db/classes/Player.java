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
    
    private final String imie;
    
    private final String nazwisko;
    
    private final String contactNumber;
    
    private final Integer userId;

    public Player(Integer id, String imie, String nazwisko, String contactNumber, Integer userId) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.contactNumber = contactNumber;
        this.userId = userId;
    }

    @Override
    public Integer getId() {
       return id;
    }
    
    
    
    
    
    
}
