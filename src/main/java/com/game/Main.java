package com.game;

import com.game.characters.*;
import com.game.stats.*;
import com.game.combat.CombatManager;

public class Main {
    public static void main(String[] args) {


        Player aelrion = new Player("Aelrion", Race.ELF, Profession.MAGE);
        aelrion.setHealth(100);

        NPC gorgul = new NPC("Gorgul", Race.ORC, Profession.WARRIOR, DifficultyLevel.MEDIUM);
        gorgul.setHealth(120);

        System.out.println("Aelrion HP après attaque : " + aelrion.getHealth());

        CombatManager combat = new CombatManager();
        combat.startCombat(aelrion, gorgul);
    }
}
