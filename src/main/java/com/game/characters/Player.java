package com.game.characters;

import com.game.abilities.Ability;
import com.game.stats.Profession;
import com.game.stats.Race;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un acteur du combat : joueur ou adversaire IA.
 */
public class Player {
    public final List<Ability> abilities;
    private final String name;
    private final Race race;
    private final Profession profession;
    private int health;
    private int strength;
    private final int agility;
    private final int intelligence;
    private int speed;

    public Player(String name, Race race, Profession profession, int baseHealth) {
        this.name = name;
        this.race = race;
        this.profession = profession;
        this.health = baseHealth;

        // calcul des stats
        this.strength = race.getBaseStrength() + profession.getStrengthBonus();
        this.agility = race.getBaseAgility() + profession.getAgilityBonus();
        this.intelligence = race.getBaseIntelligence() + profession.getIntelligenceBonus();
        this.speed = race.getBaseSpeed() + profession.getSpeedBonus();

        // collecte des capacités
        this.abilities = new ArrayList<>();
        this.abilities.addAll(race.getRaceAbilities());
        this.abilities.addAll(profession.getClassAbilities());
    }

    // Accesseurs
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int hp) {
        this.health = Math.max(0, hp);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int str) {
        this.strength = str;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int dmg) {
        setHealth(this.health - dmg);
    }

    public void useAbility(Ability ability, Player target) {
        ability.execute(this, target);
    }

    public void displayStats() {
        System.out.printf("%s — HP: %d | STR: %d | AGI: %d | INT: %d | SPD: %d%n", name, health, strength, agility, intelligence, speed);
    }
}
