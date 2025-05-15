package com.game;

import com.game.abilities.Ability;
import com.game.characters.Player;
import com.game.stats.Race;
import com.game.stats.Profession;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Création des joueurs
        Player player = new Player("Héros", Race.HUMAN, Profession.WARRIOR, 6);
        Player enemy = new Player("Ennemi", Race.ORC, Profession.WARRIOR, 5);

        // Ajout de capacités au joueur
        player.getAbilities().add(new com.game.abilities.impl.Slash());
        player.getAbilities().add(new com.game.abilities.impl.Backstab());

        System.out.println("Début du duel !");

        Scanner scanner = new Scanner(System.in);

        // Boucle de combat
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nVos capacités :");
            for (int i = 0; i < player.getAbilities().size(); i++) {
                System.out.println((i + 1) + ". " + player.getAbilities().get(i).getClass().getSimpleName());
            }

            System.out.print("Choisissez votre attaque : ");
            int choice = scanner.nextInt();

            // Validation du choix
            if (choice < 1 || choice > player.getAbilities().size()) {
                System.out.println("Choix invalide !");
                continue;
            }

            // Exécution de l'attaque du joueur
            Ability chosenAbility = player.getAbilities().get(choice - 1);
            chosenAbility.execute(player, enemy);

            // Vérification si l'ennemi est encore en vie
            if (!enemy.isAlive()) {
                System.out.println("\n" + enemy.getName() + " est vaincu !");
                break;
            }

            // Tour de l'ennemi (attaque simple)
            System.out.println("\nL'ennemi attaque !");
            enemy.useAbility(new com.game.abilities.impl.Slash(), player);

            // Vérification si le joueur est encore en vie
            if (!player.isAlive()) {
                System.out.println("\n" + player.getName() + " est vaincu !");
                break;
            }
        }

        System.out.println("\nFin du duel !");
        scanner.close();
    }
}