package com.arena.stats;

import com.arena.ability.Ability;
import com.arena.ability.impl.PiercingArrow;
import java.util.List;

public enum Race {
    HUMAN(5, 5, 5, 5, List.of(new PiercingArrow())),
    ELF  (4, 7, 6, 7, List.of(new PiercingArrow())),
    ORC  (7, 5, 4, 4, List.of(new PiercingArrow()));

    private final int baseStrength, baseAgility, baseIntelligence, baseHealth;
    private final List<Ability> raceAbilities;

    Race(int str, int agi, int intl, int hp, List<Ability> abilities) {
        this.baseStrength     = str;
        this.baseAgility      = agi;
        this.baseIntelligence = intl;
        this.baseHealth       = hp * 10;       // par exemple 5 → 50 PV
        this.raceAbilities    = abilities;
    }

    public int getBaseStrength()     { return baseStrength; }
    public int getBaseAgility()      { return baseAgility; }
    public int getBaseIntelligence() { return baseIntelligence; }
    public int getBaseHealth()       { return baseHealth; }
    public List<Ability> getRaceAbilities() { return raceAbilities; }
}
