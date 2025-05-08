package com.game.combat;

import com.game.characters.Player;   // <— remplacer Character par Player
import java.util.Queue;

public class TurnManager {
    private final Queue<Player> turnQueue;  // Queue de Player

    public TurnManager(Queue<Player> queue) {
        this.turnQueue = queue;
    }

    public void nextTurn() {
        Player current = turnQueue.poll();
        // Ici : logique de sélection d'action et exécution
        turnQueue.offer(current);
    }
}
