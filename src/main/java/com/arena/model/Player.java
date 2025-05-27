package com.arena.model;

import com.arena.ability.Ability;
import com.arena.stats.Race;
import com.arena.stats.Profession;

import java.util.Scanner;

public class Player extends Character {
    private final Race race;
    private final Profession profession;
    private final int baseHealth, baseStr, baseAgi, baseIntl;
    private int level = 1;

    public Player(String name, Race race, Profession profession) {
        super(
                name,
                race.getBaseHealth() + profession.getHealthBonus(),
                race.getBaseStrength() + profession.getStrengthBonus(),
                race.getBaseAgility() + profession.getAgilityBonus(),
                race.getBaseIntelligence() + profession.getIntelligenceBonus()
        );
        this.race = race;
        this.profession = profession;
        this.baseHealth = this.getMaxHealth();
        this.baseStr    = this.getStrength();
        this.baseAgi    = this.getAgility();
        this.baseIntl   = this.getIntelligence();
        this.abilities.addAll(race.getRaceAbilities());
        this.abilities.addAll(profession.getClassAbilities());
    }

    @Override
    public void chooseAbility(Character opponent) {
        System.out.println("\nVotre tour (lvl " + level + "): ");
        for (int i = 0; i < abilities.size(); i++) {
            System.out.printf("%d) %s\n", i+1, abilities.get(i).getName());
        }
        System.out.print("Choisissez une capacité : ");
        int choice = new Scanner(System.in).nextInt() - 1;
        executeAbility(choice, opponent);
    }

    public void levelUp() {
        level++;
        int newMaxHp = baseHealth * level;
        setMaxHealth(newMaxHp);
        setStats(baseStr * level, baseAgi * level, baseIntl * level);
        System.out.printf("*** Vous montez au niveau %d ! PV restaurés à %d, STR=%d, AGI=%d, INT=%d ***\n",
                level, getMaxHealth(), getStrength(), getAgility(), getIntelligence());
    }

    @Override
    public int getLevel() {
        return level;
    }

    public Race getRace() { return race; }
    public Profession getProfession() { return profession; }
}