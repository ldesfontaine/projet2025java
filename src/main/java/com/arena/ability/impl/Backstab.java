package com.arena.ability.impl;

import com.arena.ability.Ability;
import com.arena.model.Character;

public class Backstab implements Ability {
    @Override public String getName() { return "Backstab"; }
    @Override
    public void applyEffect(Character src, Character tgt) {
        int dmg = src.getStrength() + 5;
        tgt.takeDamage(dmg);
        System.out.printf("%s takes %d damage!\n", tgt.getName(), dmg);
    }
}
