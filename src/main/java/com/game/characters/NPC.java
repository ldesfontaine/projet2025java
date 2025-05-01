package com.game.characters;

import com.game.stats.Race;
import com.game.stats.Profession;
import com.game.stats.DifficultyLevel;

import static com.game.stats.DifficultyLevel.*;

public class NPC extends Character {

    private DifficultyLevel difficulty;

    public NPC(String name, Race race, Profession profession, DifficultyLevel difficulty) {
        super(
                name,
                race.getBaseStrength() + profession.getStrengthBonus(),
                race.getBaseAgility() + profession.getAgilityBonus(),
                race.getBaseIntelligence() + profession.getIntelligenceBonus(),
                race.getBaseSpeed() + profession.getSpeedBonus()
        );
        this.difficulty = difficulty; // <-- AJOUT OBLIGATOIRE

        this.abilities.addAll(race.getRaceAbilities());
        this.abilities.addAll(profession.getClassAbilities());

        adjustStatsForDifficulty();
    }


    private void adjustStatsForDifficulty() {
        switch (difficulty) {
            case EASY -> {
                setStrength(getStrength() - 2);
                setAgility(getAgility() - 2);
            }
            case MEDIUM -> {
                // Pas de modification
            }
            case HARD -> {
                setStrength(getStrength() + 3);
                setAgility(getAgility() + 2);
                setIntelligence(getIntelligence() + 1);
                setSpeed(getSpeed() + 1);
            }
        }
    }


    @Override
    public void attack(Character target) {
        System.out.println(this.name + " attaque " + target.getName() + " !");
    }


    @Override
    public void defend() {
        System.out.println(this.name + " se défend !");
    }


}