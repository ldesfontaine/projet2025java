package com.arena.model;

import com.arena.game.exceptions.InvalidChoiceException;
import java.util.Scanner;

public class Player extends Character {
    private Scanner scanner = new Scanner(System.in);

    public Player(String name, int health,int str,int agi,int intl) {
        super(name, health, str, agi, intl);
    }

    @Override
    public void chooseAbility(Character opponent) {
        System.out.println("Choose ability:");
        for (int i=0;i<abilities.size();i++){
            System.out.printf("%d: %s\n", i+1, abilities.get(i).getName());
        }
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice<1||choice>abilities.size()) throw new InvalidChoiceException("Invalid choice");
            executeAbility(choice-1, opponent);
        } catch(NumberFormatException|InvalidChoiceException e) {
            System.err.println(e.getMessage());
            chooseAbility(opponent);
        }
    }
}