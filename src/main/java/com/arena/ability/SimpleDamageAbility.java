package com.arena.ability;

import com.arena.model.Character;

public abstract class SimpleDamageAbility implements Ability {
    protected abstract int computeBaseDamage(Character source);

    @Override
    public void applyEffect(Character source, Character target) {
        int dmg = computeBaseDamage(source) * source.getLevel();
        target.takeDamage(dmg);
        System.out.printf("%s takes %d damage! (Level multiplier x%d)\n",
                target.getName(), dmg, source.getLevel());
    }
}