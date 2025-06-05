package com.arena.model.difficulty;

import com.arena.ability.impl.*;
import com.arena.ability.Ability;
import java.util.List;

/**
 * Enumération définissant les niveaux de difficulté des ennemis.
 */
public enum Difficulty {
    /**
     * Difficulté facile avec des statistiques faibles.
     */
    EASY(1, 100, 5, 3, 2, List.of(new Slash())),
    /**
     * Difficulté moyenne avec des statistiques modérées.
     */
    MEDIUM(2, 120, 7, 5, 3, List.of(new Slash(), new Backstab())),
    /**
     * Difficulté élevée avec des statistiques élevées.
     */
    HARD(3, 150,10, 7, 5, List.of(new Slash(), new Backstab(), new Fireball()));

    private final int level;
    private final int baseHealth, baseStr, baseAgi, baseIntl;
    private final List<Ability> abilities;

    /**
     * Construit une difficulté avec un niveau, des statistiques et des capacités.
     *
     * @param lvl   Le niveau de difficulté.
     * @param hp    Les points de vie de base.
     * @param str   La force de base.
     * @param agi   L'agilité de base.
     * @param intl  L'intelligence de base.
     * @param abs   La liste des capacités.
     */
    Difficulty(int lvl, int hp, int str, int agi, int intl, List<Ability> abs) {
        this.level = lvl;
        this.baseHealth = hp;
        this.baseStr    = str;
        this.baseAgi    = agi;
        this.baseIntl   = intl;
        this.abilities  = abs;
    }

    /**
     * Retourne le niveau de la difficulté.
     *
     * @return Le niveau.
     */
    public int getLevel()        { return level; }
    /**
     * Retourne les points de vie de base.
     *
     * @return Les points de vie.
     */
    public int baseHealth()      { return baseHealth; }
    /**
     * Retourne la force de base.
     *
     * @return La force.
     */
    public int baseStrength()    { return baseStr; }
    /**
     * Retourne l'agilité de base.
     *
     * @return L'agilité.
     */
    public int baseAgility()     { return baseAgi; }
    /**
     * Retourne l'intelligence de base.
     *
     * @return L'intelligence.
     */
    public int baseIntelligence(){ return baseIntl; }
    /**
     * Retourne la liste des capacités associées.
     *
     * @return La liste des capacités.
     */
    public List<Ability> getAbilities() { return abilities; }
}