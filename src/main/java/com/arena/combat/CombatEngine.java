package com.arena.combat;

import com.arena.model.Player;
import com.arena.model.Enemy;
import com.arena.model.difficulty.Difficulty;
import java.util.List;

public class CombatEngine {

    public void start() {
        Player player = new Player("Hero", 200,10,5,3);
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
                System.out.println("Defeat..."); return;
            }
        }
        System.out.println("Victory !");
    }
}
