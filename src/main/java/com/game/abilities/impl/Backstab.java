package com.game.abilities.impl;

import com.game.abilities.ClassAbility;
import com.game.characters.Player;

public class Backstab implements ClassAbility {
    @Override
    public void execute(Player source, Player target) {
        int damage = source.getAgility() * 2;
        System.out.println(source.getName() + " exécute Backstab et inflige " + damage + " dégâts !");
        target.takeDamage(damage);
    }
}
