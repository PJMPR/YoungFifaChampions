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

    private final String name;

    private final String description;

    private final Integer homeGroundId;

    public Team(Integer id, String name, String description, Integer homeGroundId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.homeGroundId = homeGroundId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHomeGroundId() {
        return homeGroundId;
    }

}
