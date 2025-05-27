package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;

public class Backstab extends SimpleDamageAbility {
    @Override public String getName() { return "Backstab"; }
    @Override protected int computeBaseDamage(Character source) {
        return source.getStrength() + 5;
    }
}