package com.tilmenk.warehouse.controller;

import com.tilmenk.warehouse.model.Pokemon;
import com.tilmenk.warehouse.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api" + "/pokemon")
@Slf4j
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Operation(summary = "get all pokemon")
    @GetMapping
    public List<Pokemon> getPokemon() throws InterruptedException {
        return pokemonService.getPokemon();
    }

}
