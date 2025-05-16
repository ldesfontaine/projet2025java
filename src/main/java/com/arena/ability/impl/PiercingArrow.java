package com.arena.ability.impl;

import com.arena.ability.Ability;
import com.arena.model.Character;

public class PiercingArrow implements Ability {

    @Override
    public void execute(Character user, Character target) {
        int damage = user.getAgility() * 2; // Exemple : dégâts basés sur l'agilité
        target.takeDamage(damage);
        System.out.println(user.getName() + " utilise Piercing Arrow sur " + target.getName() + " et inflige " + damage + " dégâts !");
    }

    @Override
    public String getName() {
        return "Piercing Arrow";
    }

    @Override
    public void applyEffect(Character source, Character target) {

    }
}