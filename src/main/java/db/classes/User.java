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
public class User implements IHaveId{
    
    private  Integer id;
    private  String login;
    private  String password;
    private  String email;

    public User(Integer id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }
    
     public User( String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


     
    @Override
    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    } 
}
