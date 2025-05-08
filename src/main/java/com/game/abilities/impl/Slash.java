package com.game.abilities.impl;

import com.game.abilities.ClassAbility;
import com.game.characters.Player;

public class Slash implements ClassAbility {
    @Override
    public void execute(Player source, Player target) {
        int damage = source.getStrength() + 2;
        System.out.println(source.getName() + " utilise Slash et inflige " + damage + " dégâts !");
        target.takeDamage(damage);
    }
}
