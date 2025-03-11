package model;

import pirate.IAffichage;
import pirate.ZoneJeu;

public class CarteFinal extends Carte {
    private static final IAffichage affichage = Jeu.getAffichage();

    public CarteFinal(String titre, String description) {
        super(titre, description);
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        adversaire.setVie(0); // L'adversaire perd automatiquement
    }

    @Override
    public ZoneJeu donnerZone() {
        return ZoneJeu.SPECIAL;
    }

    @Override
    public void afficher(int numCarte) {
        affichage.afficherCarteSpecial(titre, description, numCarte);
    }
}