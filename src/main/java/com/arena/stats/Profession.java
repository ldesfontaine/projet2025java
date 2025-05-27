package com.arena.stats;

import com.arena.ability.impl.*;
import com.arena.ability.Ability;
import java.util.List;

public enum Profession {
    WARRIOR(3,2,1,20, List.of(new Slash())),
    MAGE   (1,2,4,10, List.of(new Fireball())),
    ROGUE  (2,4,1,15, List.of(new Backstab()));

    private final int strB, agiB, intlB, hpB;
    private final List<Ability> classAbilities;

    Profession(int s,int a,int i,int h, List<Ability> abs) {
        this.strB = s;
        this.agiB = a;
        this.intlB= i;
        this.hpB  = h;
        this.classAbilities = abs;
    }

    public int getStrengthBonus()    { return strB; }
    public int getAgilityBonus()     { return agiB; }
    public int getIntelligenceBonus(){ return intlB; }
    public int getHealthBonus()      { return hpB; }
    public List<Ability> getClassAbilities() { return classAbilities; }
}