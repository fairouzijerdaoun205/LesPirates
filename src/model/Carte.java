package model;

import pirate.ActionZone;

public class Carte {
    private String nom;
    private String description;
    private int effet;
    private int numCarte;
    private ActionZone actionZone;

    public Carte(String nom, String description, int effet, int numCarte, ActionZone actionZone) {
        this.nom = nom;
        this.description = description;
        this.effet = effet;
        this.numCarte = numCarte;
        this.actionZone = actionZone;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getEffet() {
        return effet;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public ActionZone getActionZone() {
        return actionZone;
    }
}
