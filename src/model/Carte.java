package model;

import pirate.ZoneJeu;

public abstract class Carte {
    protected String titre;
    protected String description;

    protected Carte(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

 

	public abstract void appliquerEffet(Joueur joueur, Joueur adversaire);
    public abstract ZoneJeu donnerZone();
    public abstract void afficher(int numCarte);
}