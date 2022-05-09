package com.tilmenk.warehouse;

import com.tilmenk.warehouse.model.Pokemon;
import com.tilmenk.warehouse.util.csvReader.CustomReader;

import java.util.ArrayList;
import java.util.List;

public class TestMain {


    public static void main(String[] args) {
        CustomReader customReader = new CustomReader();
        try {
            List<String[]> teamLines = customReader.readLines("src/main" +
                    "/resources" + "/csv" + "/teams_1.csv");
            teamLines.remove(0);

            for (String[] stringArr : teamLines) {
                List<String> stringArrAsList =
                        new ArrayList<>(List.of(stringArr));
                String teamName = stringArrAsList.get(1);
                stringArrAsList.remove(0);
                stringArrAsList.remove(0);
                List<Pokemon> pokemonInTeam = new ArrayList<>();
                System.out.println("-----------------");
                System.out.println(teamName);
                for (String pokeName : stringArrAsList) {
                    System.out.println(pokeName);
                    //Optional<Pokemon> pokemon =
                    //pokemonRepository.findPokemonByName(pokeName);
                    //assert pokemon.isPresent();
                    //pokemonInTeam.add(pokemon.get());
                }
                // Team teamToAdd = new Team(pokemonInTeam, teamName);
                // teamService.saveTeam(teamToAdd);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
