package com.arena.combat;

import com.arena.characters.Player;
import java.util.Queue;

public class TurnManager {
    private final Queue<Player> turnQueue;

    public TurnManager(Queue<Player> queue) {
        this.turnQueue = queue;
    }

    public Queue<Player> getTurnQueue() {
        return turnQueue;
    }

    public Player getCurrentPlayer() {
        return turnQueue.peek(); // Retourne le joueur en tête de la file
    }

    public void nextTurn() {
        Player current = turnQueue.poll();
        turnQueue.offer(current);
    }
}