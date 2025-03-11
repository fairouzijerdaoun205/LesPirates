package model;

import pirate.IAffichage;
import pirate.ZoneJeu;

public class CarteSoin extends Carte {
    private int soin;
    private  IAffichage affichage ;

    public CarteSoin(String titre, String description, int soin,IAffichage affichage) {
        super(titre, description);
        this.soin = soin;
        this.affichage = affichage;
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.recevoirSoin(soin);
    }

    @Override
    public ZoneJeu donnerZone() {
        return ZoneJeu.SPECIAL;
    }

    @Override
    public void afficher(int numCarte) {
        affichage.afficherCarte(titre, description, soin, numCarte);
    }
}