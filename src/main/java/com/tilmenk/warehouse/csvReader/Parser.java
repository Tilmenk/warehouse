package com.tilmenk.warehouse.csvReader;

import com.tilmenk.warehouse.pokemon.Pokemon;
import com.tilmenk.warehouse.team.Team;

import java.text.ParseException;

public class Parser<E> {
    public Parser() {
    }


    public E parse(int mode, Object E) throws ParseException {
        if(E.getClass().equals(Pokemon.class))
        {
        return (E) parsePokemon();
        }
        else if (E.getClass().equals(Team.class)) {
            return (E) parseTeam();
        } else {
            throw new ParseException("Cannot parse given input to requested class object", 0);
        }
    }

    Pokemon parsePokemon(){
        return null;
    }

    Team parseTeam(){
        return null;
    }



}
