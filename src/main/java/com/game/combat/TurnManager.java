package com.game.combat;

import com.game.characters.Character;
import java.util.Queue;

public class TurnManager {
    private final Queue<Character> turnQueue;

    public TurnManager(Queue<Character> queue) {
        this.turnQueue = queue;
    }

    public void nextTurn() {
        Character current = turnQueue.poll();
        // Ici : logique de sélection d'action et exécution
        turnQueue.offer(current);
    }
}
