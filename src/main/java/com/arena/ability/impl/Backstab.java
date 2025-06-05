package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;


/**
 * Capacité de coup dans le dos infligeant des dégâts basés sur la force.
 */
public class Backstab extends SimpleDamageAbility {
    /**
     * Retourne le nom de la capacité.
     *
     * @return "Backstab".
     */
    @Override public String getName() { return "Backstab"; }

    /**
     * Calcule les dégâts de base en ajoutant 5 à la force du personnage.
     *
     * @param source Le personnage utilisant la capacité.
     * @return Les dégâts de base.
     */
    @Override protected int computeBaseDamage(Character source) {
        return source.getStrength() + 5;
    }
}