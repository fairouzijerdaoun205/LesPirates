package model;

import pirate.ActionZone;

public abstract class Carte {
    protected String nom;
    protected String description;
    protected int numCarte;
    protected ActionZone actionZone;

    public Carte(String nom, String description, int numCarte, ActionZone actionZone) {
        this.nom = nom;
        this.description = description;
        this.numCarte = numCarte;
        this.actionZone = actionZone;
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public ActionZone getActionZone() { return actionZone; }

    public abstract void appliquerEffet(Joueur joueur, Joueur adversaire);
}
