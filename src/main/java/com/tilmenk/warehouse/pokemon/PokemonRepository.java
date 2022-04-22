package com.tilmenk.warehouse.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, String> {
    //SELECT * FROM student WHERE email = email
    //@Query("SELECT s FROM Student s WHERE s.email = ?1")

}
