package com.game.combat;

import com.game.characters.Character;

public class CombatManager {
    public void startCombat(Character player, Character enemy) {
        System.out.println("Le combat commence entre " + player.getName() + " et " + enemy.getName());

        // Affichage des stats de départ
        System.out.println(player.getName() + " - Force: " + player.getStrength() + " / Vitesse: " + player.getSpeed());
        System.out.println(enemy.getName() + " - Force: " + enemy.getStrength() + " / Vitesse: " + enemy.getSpeed());

        // Tour par tour simplifié
        Character first = (player.getSpeed() >= enemy.getSpeed()) ? player : enemy;
        Character second = (first == player) ? enemy : player;

        System.out.println(first.getName() + " commence !");

        for (int i = 0; i < 3; i++) {
            System.out.println("--- Tour " + (i + 1) + " ---");
            first.attack(second);
            second.attack(first);
        }

        System.out.println("Fin du combat (simulation).");
    }
}
