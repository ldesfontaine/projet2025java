package com.arena.ability;

import com.arena.model.Character;

/**
 * Classe abstraite pour les capacités infligeant des dégâts simples.
 */
public abstract class SimpleDamageAbility implements Ability {
    /**
     * Calcule les dégâts de base de la capacité.
     *
     * @param source Le personnage utilisant la capacité.
     * @return Les dégâts de base calculés.
     */
    protected abstract int computeBaseDamage(Character source);

    /**
     * Applique des dégâts à la cible en fonction du niveau et des statistiques du source.
     *
     * @param source Le personnage utilisant la capacité.
     * @param target Le personnage ciblé par la capacité.
     */
    @Override
    public void applyEffect(Character source, Character target) {
        int dmg = computeBaseDamage(source) * source.getLevel();
        target.takeDamage(dmg);
        System.out.printf("%s takes %d damage! (Level multiplier x%d)\n",
                target.getName(), dmg, source.getLevel());
    }
}