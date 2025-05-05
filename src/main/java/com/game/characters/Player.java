package com.game.characters;

import com.game.stats.Race;
import com.game.stats.Profession;

/**
 * Personnage contrôlé par le joueur.
 */
public class Player extends Character {

    public Player(String name, Race race, Profession profession) {
        super(name,
                race.getBaseStrength() + profession.getStrengthBonus(),
                race.getBaseAgility() + profession.getAgilityBonus(),
                race.getBaseIntelligence() + profession.getIntelligenceBonus(),
                race.getBaseSpeed() + profession.getSpeedBonus(),
                100);
        this.abilities.addAll(race.getRaceAbilities());
        this.abilities.addAll(profession.getClassAbilities());
    }

    @Override
    public void attack(Character target) {
        int damage = this.getStrength();
        System.out.println(this.getName() + " attaque " + target.getName() + " et inflige " + damage + " dégâts !");
        target.takeDamage(damage);
    }

    @Override
    public void defend() {
        // Implémenter la logique de défense de base
    }
}
