package com.game.items.impl;

import com.game.characters.Player;
import com.game.items.Consumable;

public class FullHealingPotion extends Consumable {
    public FullHealingPotion() {
        super(Integer.MAX_VALUE); // Soigne full vie
    }

    @Override
    public void use(Player target) {
        target.setHealth(target.getMaxHealth());
        System.out.println(target.getName() + " récupère tous ses PV grâce à la potion !");
    }
}