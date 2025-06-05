package com.arena;

import com.arena.combat.CombatEngine;

/**
 * Point d'entrée principal du jeu de combat textuel.
 */
public class Main {
    /**
     * Lance le jeu en initialisant un moteur de combat.
     *
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args){
        new CombatEngine().start();
    }
}