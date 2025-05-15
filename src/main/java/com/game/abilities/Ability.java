package com.game.abilities;

import com.game.characters.Player;

/**
 * Interface générique pour toute capacité (attaque, sort, race).
 */

public interface Ability {
    void applyEffect(Player target);
    void execute(Player source, Player target);
}