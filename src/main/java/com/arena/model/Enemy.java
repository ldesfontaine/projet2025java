package com.arena.model;

import com.arena.model.difficulty.Difficulty;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Représente un ennemi dans le jeu avec des attributs basés sur sa difficulté.
 */
public class Enemy extends Character {
    private final Difficulty difficulty;
    private final int level;

    /**
     * Construit un ennemi avec un nom et une difficulté.
     *
     * @param name       Le nom de l'ennemi.
     * @param difficulty La difficulté de l'ennemi.
     */
    public Enemy(String name, Difficulty difficulty) {
        super(name,
                difficulty.baseHealth(),
                difficulty.baseStrength(),
                difficulty.baseAgility(),
                difficulty.baseIntelligence()
        );
        this.difficulty = difficulty;
        this.level = difficulty.getLevel();
        this.abilities.addAll(difficulty.getAbilities());
    }

    /**
     * Choisit une capacité aléatoire à exécuter contre un adversaire.
     *
     * @param opponent L'adversaire ciblé.
     */
    @Override
    public void chooseAbility(Character opponent) {
        int idx = ThreadLocalRandom.current().nextInt(abilities.size());
        executeAbility(idx, opponent);
    }

    /**
     * Retourne le niveau de l'ennemi.
     *
     * @return Le niveau.
     */
    @Override
    public int getLevel() {
        return level;
    }
}