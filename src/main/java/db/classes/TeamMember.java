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
public class TeamMember implements IHaveId{
    
    private final Integer id;
    private final Integer teamId;
    private final Integer playerId;
    private final Boolean isCaptain;

    public TeamMember(Integer id, Integer teamId, Integer playerId, Boolean isCaptain) {
        this.id = id;
        this.teamId = teamId;
        this.playerId = playerId;
        this.isCaptain = isCaptain;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Boolean getIsCaptain() {
        return isCaptain;
    }
    
    
    
}
