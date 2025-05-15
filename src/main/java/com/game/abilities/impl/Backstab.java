package com.game.abilities.impl;

import com.game.abilities.ClassAbility;
import com.game.characters.Player;

public class Backstab implements ClassAbility {
    @Override
    public void applyEffect(Player target) {
        int damage = 10; // Exemple de valeur fixe ou calculée
        System.out.println("Backstab inflige " + damage + " dégâts à " + target.getName() + " !");
        target.takeDamage(damage);
    }

    @Override
    public void execute(Player source, Player target) {
        System.out.println(source.getName() + " utilise Backstab sur " + target.getName() + " !");
        applyEffect(target);
    }
}