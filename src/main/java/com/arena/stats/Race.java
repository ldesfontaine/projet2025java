package com.arena.stats;

import com.arena.ability.impl.PiercingArrow;
import com.arena.ability.Ability;
import java.util.List;

/**
 * Enumération définissant les races des joueurs.
 */
public enum Race {
    /**
     * Humain avec des statistiques équilibrées.
     */
    HUMAN(5,5,5,50, List.of(new PiercingArrow())),
    /**
     * Elfe avec un bonus en agilité et intelligence.
     */
    ELF  (4,7,6,40, List.of(new PiercingArrow())),
    /**
     * Orc avec un bonus en force et santé.
     */
    ORC  (7,5,4,70, List.of(new PiercingArrow()));

    private final int baseStr, baseAgi, baseIntl, baseHp;
    private final List<Ability> abilities;
    /**
     * Construit une race avec des statistiques de base et des capacités.
     *
     * @param str  Force de base.
     * @param agi  Agilité de base.
     * @param intl Intelligence de base.
     * @param hp   Santé de base.
     * @param abs  Liste des capacités.
     */
    Race(int str, int agi, int intl, int hp, List<Ability> abs) {
        this.baseStr = str;
        this.baseAgi = agi;
        this.baseIntl= intl;
        this.baseHp  = hp;
        this.abilities = abs;
    }

    /**
     * Retourne la force de base.
     *
     * @return La force.
     */
    public int getBaseStrength()     { return baseStr; }
    /**
     * Retourne l'agilité de base.
     *
     * @return L'agilité.
     */
    public int getBaseAgility()      { return baseAgi; }
    /**
     * Retourne l'intelligence de base.
     *
     * @return L'intelligence.
     */
    public int getBaseIntelligence() { return baseIntl; }
    /**
     * Retourne la santé de base.
     *
     * @return La santé.
     */
    public int getBaseHealth()       { return baseHp; }
    /**
     * Retourne le bonus de santé (0 par défaut).
     *
     * @return Le bonus de santé.
     */
    public int getHealthBonus()      { return 0; }
    /**
     * Retourne la liste des capacités de la race.
     *
     * @return La liste des capacités.
     */
    public List<Ability> getRaceAbilities() { return abilities; }
}