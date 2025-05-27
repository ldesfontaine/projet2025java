package com.arena.stats;

import com.arena.ability.impl.PiercingArrow;
import com.arena.ability.Ability;
import java.util.List;

public enum Race {
    HUMAN(5,5,5,50, List.of(new PiercingArrow())),
    ELF  (4,7,6,40, List.of(new PiercingArrow())),
    ORC  (7,5,4,70, List.of(new PiercingArrow()));

    private final int baseStr, baseAgi, baseIntl, baseHp;
    private final List<Ability> abilities;

    Race(int str, int agi, int intl, int hp, List<Ability> abs) {
        this.baseStr = str;
        this.baseAgi = agi;
        this.baseIntl= intl;
        this.baseHp  = hp;
        this.abilities = abs;
    }

    public int getBaseStrength()     { return baseStr; }
    public int getBaseAgility()      { return baseAgi; }
    public int getBaseIntelligence() { return baseIntl; }
    public int getBaseHealth()       { return baseHp; }
    public int getHealthBonus()      { return 0; }
    public List<Ability> getRaceAbilities() { return abilities; }
}