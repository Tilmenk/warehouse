package com.tilmenk.warehouse.exceptions;

import com.tilmenk.warehouse.model.Pokemon;

public class PokemonNotInDbException extends IllegalStateException {
    public PokemonNotInDbException() {
        super();
    }

    public PokemonNotInDbException(Pokemon pokemon) {
        super("Pokemon with name '" + pokemon.getName() + "' is not present " + "in Pokemon table.");
    }
}
