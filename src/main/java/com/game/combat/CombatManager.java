package com.game.combat;

import com.game.characters.Character;

public class CombatManager {
    public void startCombat(Character player, Character enemy) {
        System.out.println("Le combat commence entre " + player.getName() + " et " + enemy.getName());

        Character first = (player.getSpeed() >= enemy.getSpeed()) ? player : enemy;
        Character second = (first == player) ? enemy : player;

        System.out.println(first.getName() + " commence !");

        boolean isFirstTurn = true;
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("--- Nouveau tour ---");

            if (isFirstTurn) {
                first.attack(second);
                isFirstTurn = false;
            } else {
                first.attack(second);
                if (!second.isAlive()) {
                    System.out.println(second.getName() + " est mort !");
                    break;
                }
                second.attack(first);
            }

            if (!first.isAlive()) {
                System.out.println(first.getName() + " est mort !");
                break;
            }

            System.out.println("Statistiques après ce tour :");
            player.displayStats();
            enemy.displayStats();

            // Alterne les rôles après chaque tour
            Character temp = first;
            first = second;
            second = temp;
        }

        System.out.println("Fin du combat.");
    }
}