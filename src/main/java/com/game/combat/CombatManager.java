package com.game.combat;

import com.game.characters.Player;
import com.game.abilities.Ability;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CombatManager {
    private final Random rng = new Random();
    private final TurnManager turnManager;

    public CombatManager(Queue<Player> players) {
        this.turnManager = new TurnManager(players);
    }

    public void startCombat() {
        System.out.println("Début du combat !");
        while (turnManager.getTurnQueue().stream().anyMatch(Player::isAlive)) {
            System.out.println("\n--- Nouveau tour ---");

            Player current = turnManager.getCurrentPlayer();
            Player target = turnManager.getTurnQueue().stream()
                    .filter(p -> p != current && p.isAlive())
                    .findFirst()
                    .orElse(null);

            if (target == null) break;

            performAttack(current, target);
            if (!target.isAlive()) {
                System.out.println(target.getName() + " est mort !");
            }

            turnManager.nextTurn();
        }

        System.out.println("\n>> Résultat : " +
                turnManager.getTurnQueue().stream()
                        .filter(Player::isAlive)
                        .map(Player::getName)
                        .findFirst()
                        .orElse("Aucun survivant") + " l’emporte !");
    }

    private void performAttack(Player attacker, Player defender) {
        Ability choice = attacker.abilities.get(rng.nextInt(attacker.abilities.size()));
        System.out.println(attacker.getName() + " utilise " +
                choice.getClass().getSimpleName());
        attacker.useAbility(choice, defender);
    }
}