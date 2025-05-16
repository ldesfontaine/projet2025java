package com.arena.combat;

import com.arena.model.Player;
import com.arena.model.Enemy;
import com.arena.model.difficulty.Difficulty;
import java.util.List;
import java.util.Scanner;

import com.arena.stats.Race;
import com.arena.stats.Profession;


public class CombatEngine {

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez votre race (1=HUMAN,2=ELF,3=ORC) :");
        Race race = switch (sc.nextInt()) {
            case 2 -> Race.ELF;
            case 3 -> Race.ORC;
            default -> Race.HUMAN;
        };

        System.out.println("Choisissez votre classe (1=WARRIOR,2=MAGE,3=ROGUE) :");
        Profession prof = switch (sc.nextInt()) {
            case 2 -> Profession.MAGE;
            case 3 -> Profession.ROGUE;
            default -> Profession.WARRIOR;
        };

        Player player = new Player("Hero", race, prof);



        List<Enemy> foes = List.of(
                new Enemy("Goblin", Difficulty.EASY),
                new Enemy("Orc", Difficulty.MEDIUM),
                new Enemy("Dragon", Difficulty.HARD)
        );
        for (Enemy enemy : foes) {
            System.out.println("Fight " + enemy.getName());
            while (player.isAlive() && enemy.isAlive()) {
                player.chooseAbility(enemy);
                if (!enemy.isAlive()) break;
                enemy.chooseAbility(player);
            }
            if (!player.isAlive()) {
                System.out.println("Defeat...");
                return;
            }
        }
        System.out.println("Victory !");
    }
}
