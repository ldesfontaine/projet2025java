package com.arena.model;

import com.arena.game.ability.Ability;

public abstract class Character {
    private String name;
    private int health;
    private int strength;
    private int agility;
    private int intelligence;

    protected List<Ability> abilities;

    public Character(String name, int health, int str, int agi, int intl) {
        this.name = name;
        this.health = health;
        this.strength = str;
        this.agility = agi;
        this.intelligence = intl;
        this.abilities = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public boolean isAlive() { return health > 0; }
    public void takeDamage(int dmg) {
        this.health = Math.max(0, this.health - dmg);
    }

    public abstract void chooseAbility(Character opponent);
    protected void executeAbility(int index, Character target) {
        abilities.get(index).execute(this, target);
    }
}