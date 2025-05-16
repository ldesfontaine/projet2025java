package com.arena.model;

import com.arena.model.difficulty.Difficulty;
import java.util.Random;

public class Enemy extends Character {
    private Difficulty level;
    private Random rng = new Random();

    public Enemy(String name, Difficulty level) {
        super(name,
                level.baseHealth(),
                level.baseStrength(),
                level.baseAgility(),
                level.baseIntelligence());
        this.level = level;
        this.abilities.addAll(level.getAbilities());
    }

    @Override
    public void chooseAbility(Character opponent) {
        int idx = rng.nextInt(abilities.size());
        executeAbility(idx, opponent);
    }
}