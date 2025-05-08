package com.game.combat;

import com.game.characters.Player;
import com.game.abilities.Ability;

import java.util.Random;

public class CombatManager {
    private final Random rng = new Random();

    public void startCombat(Player p1, Player p2) {
        System.out.println("Combat : " + p1.getName() + " vs " + p2.getName());

        while (p1.isAlive() && p2.isAlive()) {
            System.out.println("\n--- Nouveau tour ---");

            // Affichage des HP avant les attaques
            printHpStatus(p1, p2);

            Player first  = p1.getSpeed() >= p2.getSpeed() ? p1 : p2;
            Player second = (first == p1) ? p2 : p1;

            // Attaque du premier
            performAttack(first, second);
            if (!second.isAlive()) {
                System.out.println(second.getName() + " est mort !");
                break;
            }

            // Affichage des HP après la première attaque
            printHpStatus(p1, p2);

            // Riposte du second
            performAttack(second, first);
            if (!first.isAlive()) {
                System.out.println(first.getName() + " est mort !");
                break;
            }

            // Affichage des HP après la riposte
            printHpStatus(p1, p2);

            // Affichage détaillé des stats
            p1.displayStats();
            p2.displayStats();
        }

        System.out.println("\n>> Résultat : " +
                (p1.isAlive() ? p1.getName() + " l’emporte !" : p2.getName() + " l’emporte !"));
    }


    private void performAttack(Player attacker, Player defender) {
        Ability choice = attacker.abilities.get(rng.nextInt(attacker.abilities.size()));
        System.out.println(attacker.getName() + " utilise " +
                choice.getClass().getSimpleName());
        attacker.useAbility(choice, defender);
    }

    private void printHpStatus(Player p1, Player p2) {
        System.out.printf("%s — HP: %d | %s — HP: %d%n",
                p1.getName(), p1.getHealth(),
                p2.getName(), p2.getHealth());
    }

}
