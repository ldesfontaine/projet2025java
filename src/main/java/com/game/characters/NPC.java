package com.game.characters;

import com.game.stats.Race;
import com.game.stats.Profession;

/**
 * Personnage non-joueur contrôlé par l'ordinateur.
 */
public class NPC extends Character {

    public NPC(String name, Race race, Profession profession) {
        super(name,
                race.getBaseStrength() + profession.getStrengthBonus(),
                race.getBaseAgility() + profession.getAgilityBonus(),
                race.getBaseIntelligence() + profession.getIntelligenceBonus(),
                race.getBaseSpeed() + profession.getSpeedBonus());
        // Ajouter les abilities de race et de classe
        this.abilities.addAll(race.getRaceAbilities());
        this.abilities.addAll(profession.getClassAbilities());
    }

    @Override
    public void attack(Character target) {
        // Implémenter la logique IA d'attaque
    }

    @Override
    public void defend() {
        // Implémenter la logique IA de défense
    }
}