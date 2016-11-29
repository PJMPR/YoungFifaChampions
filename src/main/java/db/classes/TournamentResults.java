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
public class TournamentResults implements IHaveId{
    
    private final Integer id;
    private final Integer tournamentId;
    private final Integer firstPlaceTeamId;
    private final Integer secondPlaceTeamId;
    private final Integer thirdPlaceTeamId;

    @Override
    public Integer getId() {
        return id;
    }

    public TournamentResults(Integer id, Integer tournamentId, Integer firstPlaceTeamId, Integer secondPlaceTeamId, Integer thirdPlaceTeamId) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.firstPlaceTeamId = firstPlaceTeamId;
        this.secondPlaceTeamId = secondPlaceTeamId;
        this.thirdPlaceTeamId = thirdPlaceTeamId;
    }
    
    
    
    
}
