package com.game.stats;

import com.game.abilities.ClassAbility;
import com.game.abilities.impl.Slash;
import com.game.abilities.impl.Fireball;
import com.game.abilities.impl.Backstab;

import java.util.Collection;
import java.util.List;

/**
 * Enum des professions avec leurs bonus de stats et leurs capacités de classe.
 */
public enum Profession {
    WARRIOR(3, 2, 1, 2) {
        @Override
        public Collection<? extends ClassAbility> getClassAbilities() {
            return List.of(new Slash());
        }
    },
    MAGE(1, 2, 4, 3) {
        @Override
        public Collection<? extends ClassAbility> getClassAbilities() {
            return List.of(new Fireball());
        }
    },
    ROGUE(2, 4, 1, 5) {
        @Override
        public Collection<? extends ClassAbility> getClassAbilities() {
            return List.of(new Backstab());
        }
    };

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

    public int getStrengthBonus()     { return strengthBonus; }
    public int getAgilityBonus()      { return agilityBonus; }
    public int getIntelligenceBonus() { return intelligenceBonus; }
    public int getSpeedBonus()        { return speedBonus; }

    /**
     * Retourne les capacités propres à chaque profession.
     * Notez le type ClassAbility, pas RaceAbility.
     */
    public abstract Collection<? extends ClassAbility> getClassAbilities();
}
