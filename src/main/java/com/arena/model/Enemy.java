package com.arena.model;

import com.arena.model.difficulty.Difficulty;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Character {
    private final Difficulty difficulty;
    private final int level;

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

    @Override
    public void chooseAbility(Character opponent) {
        int idx = ThreadLocalRandom.current().nextInt(abilities.size());
        executeAbility(idx, opponent);
    }

    @Override
    public int getLevel() {
        return level;
    }
}