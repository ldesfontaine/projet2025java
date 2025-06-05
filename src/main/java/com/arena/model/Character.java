package com.arena.model;

import com.arena.ability.Ability;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un personnage dans le jeu (joueur ou ennemi).
 */
public abstract class Character {
    private final String name;
    private int health;
    private int maxHealth;
    private int strength;
    private int agility;
    private int intelligence;
    protected final List<Ability> abilities = new ArrayList<>();

    /**
     * Construit un personnage avec ses attributs de base.
     *
     * @param name        Le nom du personnage.
     * @param health      Les points de vie.
     * @param str         La force.
     * @param agi         L'agilité.
     * @param intl        L'intelligence.
     */
    public Character(String name, int health, int str, int agi, int intl) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.strength = str;
        this.agility = agi;
        this.intelligence = intl;
    }
    /**
     * Retourne le nom du personnage.
     *
     * @return Le nom.
     */
    public String getName() { return name; }
    /**
     * Retourne les points de vie actuels.
     *
     * @return Les points de vie.
     */
    public int getHealth() { return health; }
    /**
     * Retourne les points de vie maximum.
     *
     * @return Les points de vie maximum.
     */
    public int getMaxHealth() { return maxHealth; }
    /**
     * Retourne la force du personnage.
     *
     * @return La force.
     */
    public int getStrength() { return strength; }
    /**
     * Retourne l'agilité du personnage.
     *
     * @return L'agilité.
     */
    public int getAgility() { return agility; }
    /**
     * Retourne l'intelligence du personnage.
     *
     * @return L'intelligence.
     */
    public int getIntelligence() { return intelligence; }
    /**
     * Retourne la liste des capacités du personnage.
     *
     * @return La liste des capacités.
     */
    public List<Ability> getAbilities() { return abilities; }
    /**
     * Vérifie si le personnage est en vie.
     *
     * @return true si les points de vie sont supérieurs à 0, false sinon.
     */
    public boolean isAlive() { return health > 0; }
    /**
     * Applique des dégâts au personnage.
     *
     * @param dmg Les dégâts reçus.
     */
    public void takeDamage(int dmg) {
        health = Math.max(0, health - dmg);
    }
    /**
     * Définit les points de vie maximum et restaure les points de vie.
     *
     * @param maxHp Les points de vie maximum.
     */
    protected void setMaxHealth(int maxHp) {
        this.maxHealth = maxHp;
        this.health = maxHp;
    }
    /**
     * Définit les statistiques du personnage.
     *
     * @param str  La force.
     * @param agi  L'agilité.
     * @param intl L'intelligence.
     */
    protected void setStats(int str, int agi, int intl) {
        this.strength = str;
        this.agility = agi;
        this.intelligence = intl;
    }
    /**
     * Exécute une capacité sur une cible.
     *
     * @param idx    L'index de la capacité dans la liste.
     * @param target Le personnage ciblé.
     */
    protected void executeAbility(int idx, Character target) {
        abilities.get(idx).execute(this, target);
    }
    /**
     * Choisit une capacité à exécuter contre un adversaire.
     *
     * @param opponent L'adversaire ciblé.
     */
    public abstract void chooseAbility(Character opponent);
    /**
     * Retourne le niveau du personnage.
     *
     * @return Le niveau.
     */
    public abstract int getLevel();
}