package com.game.characters;
import com.game.abilities.Ability;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un personnage de jeu.
 */
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int speed;
    protected int level;
    protected int experience;
    protected List<Ability> abilities;

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

    protected void levelUp() {
        this.level++;
        this.experience = 0;
        // Bonus de stats ou récompenses à implémenter
    }

    public boolean isAlive() {
        // Exemple simple : tant que level > 0
        return this.level > 0;
    }

    // Getters et setters...
}
