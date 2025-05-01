package com.game.stats;

import com.game.abilities.ClassAbility;
import java.util.List;

/**
 * Enum des professions (classes) du jeu, fournissant bonus et capacités.
 */
public enum Profession {
    WARRIOR(3, 2, 1, 2),
    MAGE(1, 2, 4, 3),
    ROGUE(2, 4, 1, 5);

    private final int strengthBonus;
    private final int agilityBonus;
    private final int intelligenceBonus;
    private final int speedBonus;

    Profession(int str, int agi, int intl, int spd) {
        this.strengthBonus = str;
        this.agilityBonus = agi;
        this.intelligenceBonus = intl;
        this.speedBonus = spd;
    }

    public int getStrengthBonus() { return strengthBonus; }
    public int getAgilityBonus() { return agilityBonus; }
    public int getIntelligenceBonus() { return intelligenceBonus; }
    public int getSpeedBonus() { return speedBonus; }

    public List<ClassAbility> getClassAbilities() {
        // Retourner la liste des capacités propres à chaque classe
        return List.of();
    }
}