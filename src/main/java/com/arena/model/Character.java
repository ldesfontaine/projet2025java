package com.arena.model;

import com.arena.ability.Ability;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final String name;
    private int health;
    private int maxHealth;
    private int strength;
    private int agility;
    private int intelligence;
    protected final List<Ability> abilities = new ArrayList<>();

    public Character(String name, int health, int str, int agi, int intl) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.strength = str;
        this.agility = agi;
        this.intelligence = intl;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public List<Ability> getAbilities() { return abilities; }

    public boolean isAlive() { return health > 0; }

    public void takeDamage(int dmg) {
        health = Math.max(0, health - dmg);
    }

    protected void setMaxHealth(int maxHp) {
        this.maxHealth = maxHp;
        this.health = maxHp;
    }

    protected void setStats(int str, int agi, int intl) {
        this.strength = str;
        this.agility = agi;
        this.intelligence = intl;
    }

    protected void executeAbility(int idx, Character target) {
        abilities.get(idx).execute(this, target);
    }

    public abstract void chooseAbility(Character opponent);
    public abstract int getLevel();
}