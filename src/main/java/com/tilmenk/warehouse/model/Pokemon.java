package com.tilmenk.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon implements Serializable {

    @Id
    private String name;

    private String type1;

    private String type2;


    private Integer health;

    private Integer attack;

    private Integer defense;

    private Integer attack_sp;

    private Integer defense_sp;

    private Integer speed;

    private boolean legendary;

}
