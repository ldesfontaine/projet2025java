package com.game.items;

import com.game.characters.Player;

/**
 * Interface générique pour items consommables ou équipements.
 */
public interface Item {
    /**
     * Applique l'effet de l'item sur la cible.
     * @param target Le joueur (ou adversaire) visé.
     */
    void use(Player target);
}
