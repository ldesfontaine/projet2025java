package com.arena.model.difficulty;

import com.arena.game.ability.impl.*;
import com.arena.game.ability.Ability;
import java.util.List;

public enum Difficulty {
    EASY(100,5,3,2, List.of(new Slash())),
    MEDIUM(120,7,5,3, List.of(new Slash(), new Backstab())),
    HARD(150,10,7,5, List.of(new Slash(), new Backstab(), new Fireball()));

    private final int baseHealth, baseStr, baseAgi, baseIntl;
    private final List<Ability> abilities;

    Difficulty(int h,int s,int a,int i, List<Ability> abs) {
        this.baseHealth=h;
        this.baseStr=s;
        this.baseAgi=a;
        this.baseIntl=i;
        this.abilities=abs;
    }

    public int baseHealth() { return baseHealth; }
    public int baseStrength() { return baseStr; }
    public int baseAgility()  { return baseAgi; }
    public int baseIntelligence() { return baseIntl; }
    public List<Ability> getAbilities() { return abilities; }
}