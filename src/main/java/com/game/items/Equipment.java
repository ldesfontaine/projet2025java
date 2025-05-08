package com.game.items;

import com.game.characters.Player;

public class Equipment implements Item {
    private final int strengthBonus;

    public Equipment(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    @Override
    public void use(Player target) {
        target.setStrength(target.getStrength() + strengthBonus);
        System.out.println(target.getName()
                + " équipe un artefact et gagne +" + strengthBonus + " force !");
    }
}
