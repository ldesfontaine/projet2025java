package com.game.characters;
import com.game.abilities.Ability;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un personnage de jeu.
 */
public abstract class Character {
    protected String name;
    protected int level;
    protected int experience;
    protected List<Ability> abilities;
    private int strength;
    private int agility;
    private int intelligence;
    private int speed;

    public Character(String name, int strength, int agility, int intelligence, int speed) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.speed = speed;
        this.level = 1;
        this.experience = 0;
        this.abilities = new ArrayList<>();
    }

    public abstract void attack(Character target);
    public abstract void defend();

    public void useAbility(Ability ability, Character target) {
        ability.execute(this, target);
    }

    public void gainExperience(int xp) {
        this.experience += xp;
        if (this.experience >= level * 100) {
            levelUp();
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected void levelUp() {
        this.level++;
        this.experience = 0;
        // Bonus de stats ou récompenses à implémenter
    }

    public boolean isAlive() {
        // Exemple simple : tant que level > 0
        return this.level > 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getters et setters...
}
