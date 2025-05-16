package com.arena.ability;

import com.arena.game.model.Character;

public interface Ability {
    String getName();
    void applyEffect(Character source, Character target);
    default void execute(Character source, Character target) {
        System.out.printf("%s uses %s on %s\n", source.getName(), getName(), target.getName());
        applyEffect(source, target);
    }
}