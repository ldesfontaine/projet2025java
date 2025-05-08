package com.game.abilities;

/**
 * Marqueur pour capacités liées aux classes.
 */

import com.game.characters.Player;

public interface ClassAbility extends Ability {
    @Override
    void execute(Player source, Player target);
}

