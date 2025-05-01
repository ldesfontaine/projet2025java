package com.game;

import com.game.characters.*;
import com.game.stats.*;
import com.game.combat.CombatManager;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Aelrion", Race.ELF, Profession.MAGE);
        NPC enemy = new NPC("Gorgul", Race.ORC, Profession.WARRIOR, DifficultyLevel.MEDIUM);

        CombatManager combat = new CombatManager();
        combat.startCombat(player, enemy);
    }
}
