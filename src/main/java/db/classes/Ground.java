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
public class Ground implements IHaveId {

    private final Integer id;

    private final String address;

    public Ground(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

}
