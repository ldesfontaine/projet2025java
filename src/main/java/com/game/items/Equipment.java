package com.game.items;

import com.game.characters.Player;

public abstract class Equipment {
    private final String name;

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void applyEffect();

    public abstract void applyEffect(Player player);
}