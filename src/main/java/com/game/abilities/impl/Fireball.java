package com.game.abilities.impl;

import com.game.abilities.ClassAbility;
import com.game.characters.Player;

public class Fireball implements ClassAbility {
    @Override
    public void execute(Player source, Player target) {
        int damage = source.getIntelligence() * 2;
        System.out.println(source.getName() + " lance Fireball et inflige " + damage + " dégâts !");
        target.takeDamage(damage);
    }
}
