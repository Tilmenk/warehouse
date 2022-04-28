package com.tilmenk.warehouse.service;

import com.tilmenk.warehouse.model.pokemon.Pokemon;
import com.tilmenk.warehouse.model.pokemon.PokemonRepository;
import com.tilmenk.warehouse.model.pokemon.exceptions.PokemonAlreadyInDbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemon() {
        return pokemonRepository.findAll();
    }

    public boolean savePokemon(Pokemon pokemon) {
        if (pokemonRepository.findPokemonByName(pokemon.getName()).isPresent()) {
            throw new PokemonAlreadyInDbException(pokemon);
        } else {
            pokemonRepository.save(pokemon);
            return true;
        }
    }

}
