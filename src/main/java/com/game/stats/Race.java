package com.game.stats;

import com.game.abilities.RaceAbility;
import java.util.List;

/**
 * Enum des races du jeu, fournissant des statistiques et des capacités.
 */
public enum Race {
    HUMAN(5, 5, 5, 5),
    ELF(4, 7, 6, 7),
    ORC(7, 5, 4, 4),
    DWARF(6, 6, 4, 3);

    private final int baseStrength;
    private final int baseAgility;
    private final int baseIntelligence;
    private final int baseSpeed;

    Race(int str, int agi, int intl, int spd) {
        this.baseStrength = str;
        this.baseAgility = agi;
        this.baseIntelligence = intl;
        this.baseSpeed = spd;
    }

    public int getBaseStrength() { return baseStrength; }
    public int getBaseAgility() { return baseAgility; }
    public int getBaseIntelligence() { return baseIntelligence; }
    public int getBaseSpeed() { return baseSpeed; }

    public List<RaceAbility> getRaceAbilities() {
        // Retourner la liste des capacités propres à chaque race
        return List.of();
    }
}
