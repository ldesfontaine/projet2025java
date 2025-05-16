package com.arena.model;

import com.arena.ability.Ability;
import com.arena.stats.Race;
import com.arena.stats.Profession;
import java.util.List;

public class Player extends Character {
    private final Race race;
    private final Profession profession;

    public Player(String name, Race race, Profession profession) {
        super(
                name,
                race.getBaseHealth()   + profession.getStrengthBonus() * 10, // ex : health bonus
                race.getBaseStrength() + profession.getStrengthBonus(),
                race.getBaseAgility()  + profession.getAgilityBonus(),
                race.getBaseIntelligence() + profession.getIntelligenceBonus()
        );
        this.race       = race;
        this.profession = profession;

        // Peupler abilities avec les capacités raciales et de classe
        this.abilities.addAll(race.getRaceAbilities());
        this.abilities.addAll(profession.getClassAbilities());
    }

    @Override
    public void chooseAbility(Character opponent) {
        // Laisser vide si Swing gère tout via execute
    }

    public Race getRace() {
        return race;
    }

    public Profession getProfession() {
        return profession;
    }
}