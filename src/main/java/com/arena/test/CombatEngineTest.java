package com.arena.test;

import com.arena.combat.CombatEngine;
import com.arena.model.Character;
import com.arena.model.Enemy;
import com.arena.model.Player;
import com.arena.model.difficulty.Difficulty;
import com.arena.stats.Profession;
import com.arena.stats.Race;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests unitaires pour le moteur de combat.
 */
public class CombatEngineTest {
    /**
     * Teste un scénario où le joueur gagne contre un ennemi facile.
     */
    // Test 1 : Victoire
    @Test
    public void testPlayerWinsEasy() {
        Player player = new TestPlayer("Héro", Race.HUMAN, Profession.WARRIOR);
        Enemy enemy = new Enemy("Goblin", Difficulty.EASY);
        CombatEngine engine = new CombatEngine();
        boolean result = engine.fight(player, enemy);
        assertTrue("Le joueur devrait gagner contre un ennemi facile", result);
        System.out.println("Test Victoire Facile : " + player.getName() + " gagne contre " + enemy.getName() + " !");
    }

    // Test 2 : Défaite
    @Test
    public void testPlayerLosesHard() {
        Player player = new TestPlayer("Héro", Race.HUMAN, Profession.MAGE);
        Enemy enemy = new Enemy("Dragon", Difficulty.HARD);
        CombatEngine engine = new CombatEngine();
        boolean result = engine.fight(player, enemy);
        assertFalse("Le joueur devrait perdre contre un ennemi difficile", result);
        System.out.println("Test Défaite : " + enemy.getName() + " gagne contre " + player.getName() + " !");
    }

    // Test 3 : Victoire
    @Test
    public void testPlayerWinsMedium() {
        Player player = new TestPlayer("Héro", Race.ORC, Profession.WARRIOR);
        Enemy enemy = new Enemy("Orc", Difficulty.MEDIUM);
        CombatEngine engine = new CombatEngine();
        boolean result = engine.fight(player, enemy);
        assertTrue("Le joueur devrait gagner contre un ennemi moyen", result);
        System.out.println("Test Victoire Serrée : " + player.getName() + " gagne contre " + enemy.getName() + " !");
    }

    private static class TestPlayer extends Player {
        public TestPlayer(String name, Race race, Profession profession) {
            super(name, race, profession);
        }

        @Override
        public void chooseAbility(Character opponent) {
            executeAbility(0, opponent);
        }
    }
}