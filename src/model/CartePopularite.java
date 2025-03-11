package model;

import pirate.IAffichage;
import pirate.ZoneJeu;

public class CartePopularite extends Carte {
    private int popularite;
    private IAffichage affichage; // On ne l'initialise plus statiquement

    public CartePopularite(String titre, String description, int popularite, IAffichage affichage) {
        super(titre, description);
        this.popularite = popularite;
        this.affichage = affichage; // On passe l'affichage en paramètre
    }

    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.gagnerPopularite(popularite);
    }

    public ZoneJeu donnerZone() {
        return ZoneJeu.POPULARITE;
    }

    
    public void afficher(int numCarte) {
        affichage.afficherCarte(titre, description, popularite, numCarte);
    }
}