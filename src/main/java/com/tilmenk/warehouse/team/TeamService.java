package com.tilmenk.warehouse.team;

import com.tilmenk.warehouse.pokemon.Pokemon;
import com.tilmenk.warehouse.pokemon.PokemonRepository;
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


    public void createTeam() {
        Pokemon pokemon_1 =
                pokemonRepository.findById("pikachu").orElseThrow(() -> new IllegalStateException("Pikachu not found "));
        teamRepository.save(new Team(pokemon_1, pokemon_1, pokemon_1,
                pokemon_1, pokemon_1, pokemon_1));
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

}
