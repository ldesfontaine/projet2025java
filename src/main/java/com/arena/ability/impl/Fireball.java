package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;

/**
 * Capacité de boule de feu infligeant des dégâts basés sur l'intelligence.
 */
public class Fireball extends SimpleDamageAbility {
    /**
     * Retourne le nom de la capacité.
     *
     * @return "Fireball".
     */
    @Override public String getName() { return "Fireball"; }


    /**
     * Calcule les dégâts de base en ajoutant 5 à l'intelligence du personnage.
     *
     * @param source Le personnage utilisant la capacité.
     * @return Les dégâts de base.
     */
    @Override protected int computeBaseDamage(Character source) {
        return source.getIntelligence() + 5;
    }

}