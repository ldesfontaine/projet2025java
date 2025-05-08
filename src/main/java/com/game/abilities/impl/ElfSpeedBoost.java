package com.game.abilities.impl;

import com.game.abilities.RaceAbility;
import com.game.characters.Player;

public class ElfSpeedBoost implements RaceAbility {
    @Override
    public void execute(Player source, Player target) {
        source.setSpeed(source.getSpeed() + 2);
        System.out.println(source.getName() + " gagne +2 de vitesse grâce à l’ElfSpeedBoost !");
    }
}
