package com.game;

import com.game.characters.Player;
import com.game.combat.CombatManager;
import com.game.abilities.Ability;
import com.game.stats.Race;
import com.game.stats.Profession;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Player enemy = new Player("Aelrion", Race.ELF, Profession.MAGE, 30);
//        Player player = new Player("Aelrion", Race.ELF, Profession.MAGE, 30);
        Player player = new Player("Gorgul", Race.ORC, Profession.WARRIOR, 30);

        Queue<Player> players = new LinkedList<>();
        players.add(player);
        players.add(enemy);

        CombatManager combat = new CombatManager(players);

        System.out.println("Début du duel !");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nVos capacités :");
            for (int i = 0; i < player.abilities.size(); i++) {
                System.out.printf("%d – %s%n",
                        i + 1,
                        player.abilities.get(i).getClass().getSimpleName()
                );
            }
            System.out.print("Choisissez votre attaque : ");
            int idx = scanner.nextInt() - 1;
            Ability a = player.abilities.get(idx);
            player.useAbility(a, enemy);
            if (!enemy.isAlive()) break;

            // IA attaque aléatoirement
            Ability ai = enemy.abilities.get(random.nextInt(enemy.abilities.size()));
            enemy.useAbility(ai, player);
        }

        if (player.isAlive()) {
            System.out.println("\nFélicitations, vous avez vaincu !");
        } else {
            System.out.println("\nVous êtes mort. Game over.");
        }
        scanner.close();
    }
}
