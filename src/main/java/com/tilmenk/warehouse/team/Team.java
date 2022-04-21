package com.tilmenk.warehouse.team;

import com.tilmenk.warehouse.pokemon.Pokemon;

import javax.persistence.*;

@Entity
@Table
public class Team {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName =
            "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "student_sequence")
    private Long id;

    @ManyToOne
    private Pokemon pokemon_0;
    @ManyToOne
    private Pokemon pokemon_1;
    @ManyToOne
    private Pokemon pokemon_2;
    @ManyToOne
    private Pokemon pokemon_3;
    @ManyToOne
    private Pokemon pokemon_4;
    @ManyToOne
    private Pokemon pokemon_5;


    public Team() {

    }

    public Team(Long id, Pokemon pokemon_0, Pokemon pokemon_1,
                Pokemon pokemon_2, Pokemon pokemon_3, Pokemon pokemon_4,
                Pokemon pokemon_5) {
        this.id = id;
        this.pokemon_0 = pokemon_0;
        this.pokemon_1 = pokemon_1;
        this.pokemon_2 = pokemon_2;
        this.pokemon_3 = pokemon_3;
        this.pokemon_4 = pokemon_4;
        this.pokemon_5 = pokemon_5;
    }

    public Team(Pokemon pokemon_0, Pokemon pokemon_1, Pokemon pokemon_2,
                Pokemon pokemon_3, Pokemon pokemon_4, Pokemon pokemon_5) {
        this.pokemon_0 = pokemon_0;
        this.pokemon_1 = pokemon_1;
        this.pokemon_2 = pokemon_2;
        this.pokemon_3 = pokemon_3;
        this.pokemon_4 = pokemon_4;
        this.pokemon_5 = pokemon_5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pokemon getPokemon_0() {
        return pokemon_0;
    }

    public void setPokemon_0(Pokemon pokemon_0) {
        this.pokemon_0 = pokemon_0;
    }

    public Pokemon getPokemon_1() {
        return pokemon_1;
    }

    public void setPokemon_1(Pokemon pokemon_1) {
        this.pokemon_1 = pokemon_1;
    }

    public Pokemon getPokemon_2() {
        return pokemon_2;
    }

    public void setPokemon_2(Pokemon pokemon_2) {
        this.pokemon_2 = pokemon_2;
    }

    public Pokemon getPokemon_3() {
        return pokemon_3;
    }

    public void setPokemon_3(Pokemon pokemon_3) {
        this.pokemon_3 = pokemon_3;
    }

    public Pokemon getPokemon_4() {
        return pokemon_4;
    }

    public void setPokemon_4(Pokemon pokemon_4) {
        this.pokemon_4 = pokemon_4;
    }

    public Pokemon getPokemon_5() {
        return pokemon_5;
    }

    public void setPokemon_5(Pokemon pokemon_5) {
        this.pokemon_5 = pokemon_5;
    }
}
