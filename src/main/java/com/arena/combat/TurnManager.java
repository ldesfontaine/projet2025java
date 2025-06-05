package com.arena.combat;

import com.arena.model.Player;
import java.util.Queue;

/**
 * Gère les tours des joueurs dans le jeu.
 */
public class TurnManager {
    private final Queue<Player> turnQueue;

    /**
     * Construit un gestionnaire de tours avec une file de joueurs.
     *
     * @param queue La file des joueurs.
     */
    public TurnManager(Queue<Player> queue) {
        this.turnQueue = queue;
    }

    /**
     * Retourne la file des tours.
     *
     * @return La file des joueurs.
     */
    public Queue<Player> getTurnQueue() {
        return turnQueue;
    }

    /**
     * Retourne le joueur actuel.
     *
     * @return Le joueur en tête de la file.
     */
    public Player getCurrentPlayer() {
        return turnQueue.peek(); // Retourne le joueur en tête de la file
    }

    /**
     * Passe au tour suivant en réorganisant la file.
     */
    public void nextTurn() {
        Player current = turnQueue.poll();
        turnQueue.offer(current);
    }
}