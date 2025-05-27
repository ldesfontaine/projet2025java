package com.arena.ability.impl;

import com.arena.ability.SimpleDamageAbility;
import com.arena.model.Character;

public class PiercingArrow extends SimpleDamageAbility {
    @Override public String getName() { return "Piercing Arrow"; }
    @Override protected int computeBaseDamage(Character source) {
        return source.getAgility() * 2;
    }
}