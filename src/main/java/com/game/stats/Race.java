package com.game.stats;

import com.game.abilities.RaceAbility;
import com.game.abilities.impl.*;
import com.game.abilities.RaceAbility;
import java.util.List;

/**
 * Enum des races du jeu, fournissant des statistiques et des capacités.
 */
public enum Race {
    HUMAN(5,5,5,5) {
        @Override
        public List<RaceAbility> getRaceAbilities() {
            return List.of();
        }
    },
    ELF(4,7,6,7) {
        @Override
        public List<RaceAbility> getRaceAbilities() {
            return List.of(new ElfSpeedBoost());
        }
    },
    ORC(7,5,4,4) {
        @Override
        public List<RaceAbility> getRaceAbilities() {
            return List.of();
        }
    };

    private final int baseStrength, baseAgility, baseIntelligence, baseSpeed;

    Race(int s, int a, int i, int sp) {
        this.baseStrength = s;
        this.baseAgility = a;
        this.baseIntelligence = i;
        this.baseSpeed = sp;
    }

    public int getBaseStrength()     { return baseStrength; }
    public int getBaseAgility()      { return baseAgility; }
    public int getBaseIntelligence() { return baseIntelligence; }
    public int getBaseSpeed()        { return baseSpeed; }

    // Méthode abstraite à implémenter
    public abstract List<RaceAbility> getRaceAbilities();
}
