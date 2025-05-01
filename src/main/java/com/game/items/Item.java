package com.game.items;

import com.game.characters.Character;

/**
 * Interface générique pour items consommables ou équipements.
 */
public interface Item {
    void use(Character target);
}