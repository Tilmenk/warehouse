package com.tilmenk.warehouse.model.team;

import com.tilmenk.warehouse.model.pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Team {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName =
            "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "student_sequence")
    private Long id;

    @ManyToMany
    private List<Pokemon> pokemon;

    private String name;

    public Team() {

    }

    public Team(Long id, List<Pokemon> pokemon, String name) {
        this.id = id;
        this.pokemon = pokemon;
        this.name = name;
    }

    public Team(List<Pokemon> pokemon, String name) {
        this.pokemon = pokemon;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
