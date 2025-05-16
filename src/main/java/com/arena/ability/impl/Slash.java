package com.arena.ability.impl;

import com.arena.ability.Ability;
import com.arena.model.Character;

public class Slash implements Ability {
    @Override public String getName() { return "Slash"; }
    @Override public void applyEffect(Character src, Character tgt) {
        int dmg = src.getStrength() + 2;
        tgt.takeDamage(dmg);
        System.out.printf("%s takes %d damage!\n", tgt.getName(), dmg);
    }
}