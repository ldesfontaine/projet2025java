package com.arena.characters;

import com.arena.ability.Ability;
import com.arena.items.Equipment;
import com.arena.items.Consumable;
import com.arena.stats.Race;
import com.arena.stats.Profession;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Race race;
    private final Profession profession;
    private int damage = 10; // Exemple de statistique
    private final List<Equipment> equipmentList = new ArrayList<>();
    private final List<Consumable> consumables = new ArrayList<>();
    private int health;
    private int agility;
    private int strength;
    private int intelligence;
    private int maxHealth;
    public List<Ability> abilities;
    private int speed;

    public Player(String name, Race race, Profession profession, int health) {
        this.name = name;
        this.race = race;
        this.profession = profession;
        this.health = health;
        this.abilities = new ArrayList<>(); // Initialisation de la liste
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void useAbility(Ability ability, Player target) {
        // Implémentez la logique pour utiliser une capacité sur la cible
        ability.applyEffect(target);
    }

    public void equip(Equipment equipment) {
        equipmentList.add(equipment);
        System.out.println(name + " a équipé : " + equipment.getName());
        equipment.applyEffect();
    }

    public void addConsumable(Consumable consumable) {
        consumables.add(consumable);
        System.out.println(name + " a ajouté une potion : " + consumable.getClass().getSimpleName());
    }
}