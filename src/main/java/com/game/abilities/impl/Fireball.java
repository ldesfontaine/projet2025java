package com.game.abilities.impl;

import com.game.abilities.ClassAbility;
import com.game.characters.Player;

public class Fireball implements ClassAbility {
    @Override
    public void execute(Player source, Player target) {
        int damage = 15; // Exemple de valeur fixe
        System.out.println(source.getName() + " lance une boule de feu sur " + target.getName() + " infligeant " + damage + " dégâts !");
        target.takeDamage(damage);
    }

    @Override
    public void applyEffect(Player target) {
        int damage = 15; // Exemple de valeur fixe
        System.out.println("Fireball inflige " + damage + " dégâts à " + target.getName() + " !");
        target.takeDamage(damage);
    }
}