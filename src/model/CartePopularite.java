package model;

import pirate.ActionZone;

public class CartePopularite extends Carte {
    private int popularite;

    public CartePopularite(String nom, String description, int effet, int numCarte, int popularite) {
        super(nom, description, effet, numCarte, ActionZone.POPULARITE);
        this.popularite = popularite;
    }

    public int getPopularite() {
        return popularite;
    }
}
