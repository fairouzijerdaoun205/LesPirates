package model;

import pirate.IAffichage;
import pirate.ZoneJeu;

public class CarteDiffamation extends Carte {
    private int pertePopularite;
    private  IAffichage affichage ;

    public CarteDiffamation(String titre, String description, int pertePopularite, IAffichage affichage) {
        super(titre, description);
        this.pertePopularite = pertePopularite;
        this.affichage = affichage;
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        adversaire.perdrePopularite(pertePopularite);
    }

    @Override
    public ZoneJeu donnerZone() {
        return ZoneJeu.SPECIAL;
    }

    @Override
    public void afficher(int numCarte) {
        affichage.afficherCarte(titre, description, pertePopularite, numCarte);
    }
}