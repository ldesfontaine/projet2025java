package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;

public class Fireball extends SimpleDamageAbility {
    @Override public String getName() { return "Fireball"; }
    @Override protected int computeBaseDamage(Character source) {
        return source.getIntelligence() + 5;
    }
}