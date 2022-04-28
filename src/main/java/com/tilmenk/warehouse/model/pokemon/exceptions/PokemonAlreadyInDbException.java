package com.tilmenk.warehouse.model.pokemon.exceptions;

import com.tilmenk.warehouse.model.pokemon.Pokemon;

public class PokemonAlreadyInDbException extends IllegalStateException {
    public PokemonAlreadyInDbException() {
        super();
    }

    public PokemonAlreadyInDbException(Pokemon pokemon) {
        super("Pokemon with name '" + pokemon.getName() + "' is already " +
                "present " + "in Pokemon table.");
    }
}
