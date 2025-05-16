package com.arena.stats;

import com.arena.ability.Ability;
import com.arena.ability.impl.Slash;
import com.arena.ability.impl.Fireball;
import com.arena.ability.impl.Backstab;
import java.util.List;

public enum Profession {
    WARRIOR(3, 2, 1, List.of(new Slash())),
    MAGE   (1, 2, 4, List.of(new Fireball())),
    ROGUE  (2, 4, 1, List.of(new Backstab()));

    private final int strengthBonus, agilityBonus, intelligenceBonus;
    private final List<Ability> classAbilities;

    Profession(int strB, int agiB, int intlB, List<Ability> abs) {
        this.strengthBonus   = strB;
        this.agilityBonus    = agiB;
        this.intelligenceBonus = intlB;
        this.classAbilities  = abs;
    }

    public int getStrengthBonus()    { return strengthBonus; }
    public int getAgilityBonus()     { return agilityBonus; }
    public int getIntelligenceBonus(){ return intelligenceBonus; }
    public List<Ability> getClassAbilities() { return classAbilities; }
}
