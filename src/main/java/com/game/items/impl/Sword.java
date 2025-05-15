package com.game.items.impl;

import com.game.items.Equipment;
import com.game.characters.Player;

public abstract class Sword extends Equipment {
    public Sword() {
        super("Épée");
    }

    @Override
    public void applyEffect(Player player) {
        int bonusDamage = 5; // Exemple de bonus
        player.setDamage(player.getDamage() + bonusDamage);
        System.out.println(player.getName() + " voit ses dégâts augmenter de " + bonusDamage + " !");
    }
}