package com.game.items.impl;

import com.game.items.Equipment;

public abstract class Staff extends Equipment {
    public Staff() {
        super("Bâton");
    }

    @Override
    public void applyEffect() {
        System.out.println("Augmente la puissance magique !");
    }
}