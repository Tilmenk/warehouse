package com.tilmenk.warehouse.team;

import com.tilmenk.warehouse.pokemon.PokemonRepository;
import com.tilmenk.warehouse.team.exceptions.PokemonNotInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public boolean saveTeam(Team team) {
        team.getPokemon().forEach((pokemon) -> {
            if (!pokemonRepository.findPokemonByName((pokemon.getName())).isPresent()) {
                throw new PokemonNotInDbException(pokemon);
            }
        });
        teamRepository.save(team);
        return true;
    }

}
