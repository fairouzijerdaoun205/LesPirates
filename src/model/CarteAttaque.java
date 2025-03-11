package model;

import pirate.IAffichage;
import pirate.ZoneJeu;

public class CarteAttaque extends Carte {
    private int degats;
    private IAffichage affichage ;

    public CarteAttaque(String titre, String description, int degats,IAffichage affichage) {
        super(titre, description);
        this.degats = degats;
        this.affichage = affichage;
        
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        adversaire.recevoirDegats(degats);
    }

    @Override
    public ZoneJeu donnerZone() {
        return ZoneJeu.ATTAQUE;
    }

    @Override
    public void afficher(int numCarte) {
        affichage.afficherCarte(titre, description, degats, numCarte);
    }
}