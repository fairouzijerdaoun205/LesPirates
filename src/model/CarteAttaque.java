package model;

import pirate.ActionZone;

public class CarteAttaque extends Carte {
    private int degats;

    public CarteAttaque(String nom, String description, int effet, int numCarte, int degats) {
        super(nom, description, effet, numCarte, ActionZone.ATTAQUE);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }
}
