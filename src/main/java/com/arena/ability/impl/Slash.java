package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;

public class Slash extends SimpleDamageAbility {
    @Override public String getName() { return "Slash"; }
    @Override protected int computeBaseDamage(Character source) {
        return source.getStrength() + 2;
    }
}