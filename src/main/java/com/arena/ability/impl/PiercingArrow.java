package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;

/**
 * Capacité de flèche perforante infligeant des dégâts basés sur l'agilité.
 */
public class PiercingArrow extends SimpleDamageAbility {
    /**
     * Retourne le nom de la capacité.
     *
     * @return "Piercing Arrow".
     */
    @Override public String getName() { return "Piercing Arrow"; }


    /**
     * Calcule les dégâts de base en multipliant l'agilité du personnage par 2.
     *
     * @param source Le personnage utilisant la capacité.
     * @return Les dégâts de base.
     */
    @Override protected int computeBaseDamage(Character source) {
        return source.getAgility() * 2;
    }

}