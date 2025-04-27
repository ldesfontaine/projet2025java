package com.game.abilities;

import com.game.characters.Character;

/**
 * Interface générique pour toute capacité (attaque, sort, race).
 */
public interface Ability {
    void execute(Character source, Character target);
}
