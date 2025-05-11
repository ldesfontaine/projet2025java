package com.game.equipment;

import com.game.characters.Player;

public class Sword extends Equipment {
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