package com.arena.model.difficulty;

import com.arena.ability.impl.*;
import com.arena.ability.Ability;
import java.util.List;

public enum Difficulty {
    EASY(1, 100, 5, 3, 2, List.of(new Slash())),
    MEDIUM(2, 120, 7, 5, 3, List.of(new Slash(), new Backstab())),
    HARD(3, 150,10, 7, 5, List.of(new Slash(), new Backstab(), new Fireball()));

    private final int level;
    private final int baseHealth, baseStr, baseAgi, baseIntl;
    private final List<Ability> abilities;

    Difficulty(int lvl, int hp, int str, int agi, int intl, List<Ability> abs) {
        this.level = lvl;
        this.baseHealth = hp;
        this.baseStr    = str;
        this.baseAgi    = agi;
        this.baseIntl   = intl;
        this.abilities  = abs;
    }

    public int getLevel()        { return level; }
    public int baseHealth()      { return baseHealth; }
    public int baseStrength()    { return baseStr; }
    public int baseAgility()     { return baseAgi; }
    public int baseIntelligence(){ return baseIntl; }
    public List<Ability> getAbilities() { return abilities; }
}