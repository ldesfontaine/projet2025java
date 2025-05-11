package com.game.items.equipment;

public class Staff extends Equipment {
    public Staff() {
        super("Bâton");
    }

    @Override
    public void applyEffect() {
        System.out.println("Augmente la puissance magique !");
    }
}


// TODO MAUVAIS HERITAGE DE EQUIPEEMTNS SUR LES EQUIPEEMNT