package com.arena.stats;

import com.arena.ability.impl.*;
import com.arena.ability.Ability;
import java.util.List;

/**
 * Enumération définissant les professions des joueurs.
 */
public enum Profession {
    /**
     * Guerrier avec des bonus en force et santé.
     */
    WARRIOR(3,2,1,20, List.of(new Slash())),
    /**
     * Mage avec des bonus en intelligence.
     */
    MAGE   (1,2,4,10, List.of(new Fireball())),
    /**
     * Voleur avec des bonus en agilité.
     */
    ROGUE  (2,4,1,15, List.of(new Backstab()));

    private final int strB, agiB, intlB, hpB;
    private final List<Ability> classAbilities;

    /**
     * Construit une profession avec des bonus et des capacités.
     *
     * @param s   Bonus de force.
     * @param a   Bonus d'agilité.
     * @param i   Bonus d'intelligence.
     * @param h   Bonus de santé.
     * @param abs Liste des capacités.
     */
    Profession(int s,int a,int i,int h, List<Ability> abs) {
        this.strB = s;
        this.agiB = a;
        this.intlB= i;
        this.hpB  = h;
        this.classAbilities = abs;
    }
    /**
     * Retourne le bonus de force.
     *
     * @return Le bonus de force.
     */
    public int getStrengthBonus()    { return strB; }
    /**
     * Retourne le bonus d'agilité.
     *
     * @return Le bonus d'agilité.
     */
    public int getAgilityBonus()     { return agiB; }
    /**
     * Retourne le bonus d'agilité.
     *
     * @return Le bonus d'agilité.
     */
    public int getIntelligenceBonus(){ return intlB; }
    /**
     * Retourne le bonus de santé.
     *
     * @return Le bonus de santé.
     */
    public int getHealthBonus()      { return hpB; }
    /**
     * Retourne la liste des capacités de la profession.
     *
     * @return La liste des capacités.
     */
    public List<Ability> getClassAbilities() { return classAbilities; }
}