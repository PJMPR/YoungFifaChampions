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
public class TournamentTeam implements IHaveId{
    
    private final Integer id;
    private final Integer tournamentID;
    private final Integer teamId;

    public TournamentTeam(Integer id, Integer tournamentID, Integer teamId) {
        this.id = id;
        this.tournamentID = tournamentID;
        this.teamId = teamId;
    }

    @Override
    public Integer getId() {
       return id;
    }

    public Integer getTournamentID() {
        return tournamentID;
    }

    public Integer getTeamId() {
        return teamId;
    }
    
    
    
    
}
