package com.tilmenk.warehouse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Team {

    @Id
    @SequenceGenerator(name = "team_sequence", sequenceName = "team_sequence"
            , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "team_sequence")
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
}
