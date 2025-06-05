package com.arena.ability;

import com.arena.model.Character;

/**
 * Interface définissant une capacité utilisable par un personnage dans le jeu.
 */
public interface Ability {
    /**
     * Retourne le nom de la capacité.
     *
     * @return Le nom de la capacité.
     */
    String getName();

    /**
     * Applique l'effet de la capacité sur une cible.
     *
     * @param source Le personnage utilisant la capacité.
     * @param target Le personnage ciblé par la capacité.
     */
    void applyEffect(Character source, Character target);

    /**
     * Exécute la capacité en affichant un message et en appliquant l'effet.
     *
     * @param source Le personnage utilisant la capacité.
     * @param target Le personnage ciblé par la capacité.
     */
    default void execute(Character source, Character target) {
        System.out.printf("%s uses %s on %s!\n", source.getName(), getName(), target.getName());
        applyEffect(source, target);
    }
}