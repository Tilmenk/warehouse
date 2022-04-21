package com.tilmenk.warehouse.pokemon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Pokemon {

    @Id
    private String name;

    private String typ1;

    private String typ2;


    private Integer health;

    private Integer attack;

    private Integer defense;

    private Integer attack_sp;

    private Integer defense_sp;

    private boolean legendary;

    private Integer speed;

    private Integer anzahlAufLager;

    @Transient
    private Integer costs;

    public Pokemon(String name, String typ1, String typ2, Integer health,
                   Integer attack, Integer defense, Integer attack_sp,
                   Integer defense_sp, boolean legendary, Integer speed,
                   Integer anzahlAufLager) {
        this.name = name;
        this.typ1 = typ1;
        this.typ2 = typ2;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.attack_sp = attack_sp;
        this.defense_sp = defense_sp;
        this.legendary = legendary;
        this.speed = speed;
        this.anzahlAufLager = anzahlAufLager;
    }

    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyp1() {
        return typ1;
    }

    public void setTyp1(String typ1) {
        this.typ1 = typ1;
    }

    public String getTyp2() {
        return typ2;
    }

    public void setTyp2(String typ2) {
        this.typ2 = typ2;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAttack_sp() {
        return attack_sp;
    }

    public void setAttack_sp(Integer attack_sp) {
        this.attack_sp = attack_sp;
    }

    public Integer getDefense_sp() {
        return defense_sp;
    }

    public void setDefense_sp(Integer defense_sp) {
        this.defense_sp = defense_sp;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getAnzahlAufLager() {
        return anzahlAufLager;
    }

    public void setAnzahlAufLager(Integer anzahlAufLager) {
        this.anzahlAufLager = anzahlAufLager;
    }

    public Integer getCosts() {
        int tempCosts =
                (this.attack + this.attack_sp + this.defense + this.defense_sp + this.speed + this.health) / 6;
        if (this.legendary) tempCosts *= 1.5;
        return tempCosts;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "name='" + name + '\'' + ", typ1='" + typ1 + '\'' + ", typ2='" + typ2 + '\'' + ", health=" + health + ", attack=" + attack + ", defense=" + defense + ", attack_sp=" + attack_sp + ", defense_sp=" + defense_sp + ", legendary=" + legendary + ", speed=" + speed + ", anzahlAufLager=" + anzahlAufLager + ", costs=" + costs + '}';
    }
}
