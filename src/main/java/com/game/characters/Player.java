package com.game.characters;

import com.game.items.Equipment;
import com.game.items.Consumable;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int damage = 10; // Exemple de statistique
    private final List<Equipment> equipmentList = new ArrayList<>();
    private final List<Consumable> consumables = new ArrayList<>();

    public Player(String name) {
        this.name = name;
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