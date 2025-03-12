package model;

import java.util.Random;

public class Pioche {
    private Carte[] cartes;
    private int indexPioche;

    public Pioche(Carte[] cartes) {
        this.cartes = cartes;
        this.indexPioche = 0;
        melangerPioche();
    }

    private void melangerPioche() {
        Random rand = new Random();
        for (int i = cartes.length - 1; i > 0; i--) {
            int indexAleatoire = rand.nextInt(i + 1);
            Carte temp = cartes[i];
            cartes[i] = cartes[indexAleatoire];
            cartes[indexAleatoire] = temp;
        }
    }

    public Carte piocherCarte() {
        return (indexPioche < cartes.length) ? cartes[indexPioche++] : null;
    }

    public boolean estVide() {
        return indexPioche >= cartes.length;
    }
}
