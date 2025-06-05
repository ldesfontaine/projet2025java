package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;


/**
 * Capacité de coup tranchant infligeant des dégâts basés sur la force.
 */
public class Slash extends SimpleDamageAbility {
    /**
     * Retourne le nom de la capacité.
     *
     * @return "Slash".
     */
    @Override public String getName() { return "Slash"; }


    /**
     * Calcule les dégâts de base en ajoutant 2 à la force du personnage.
     *
     * @param source Le personnage utilisant la capacité.
     * @return Les dégâts de base.
     */
    @Override protected int computeBaseDamage(Character source) {
        return source.getStrength() + 2;
    }

}