package com.game.items;

import com.game.characters.Player;

public class Consumable implements Item {
    private final int healAmount;

    public Consumable(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void use(Player target) {
        int newHp = target.getHealth() + healAmount;
        target.setHealth(newHp);
        System.out.println(target.getName()
                + " récupère " + healAmount + " HP grâce à la potion !");
    }
}
