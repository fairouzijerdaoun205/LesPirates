package model;

import java.security.SecureRandom;
import pirate.IAffichage;


public class Pioche {
    private static final int TAILLE_PIOCHE = 20;
    private Carte[] cartes = new Carte[TAILLE_PIOCHE];
    private int nbCartesRestantes = TAILLE_PIOCHE;
    private SecureRandom random = new SecureRandom();
    private IAffichage affichage; 

    public Pioche(IAffichage affichage) {
        this.affichage = affichage;
        initialiserPioche();
    }

    private void initialiserPioche() {
        // Ajout de cartes à la pioche
        for (int i = 0; i < TAILLE_PIOCHE; i++) {
            int typeCarte = random.nextInt(4); // 0: Attaque, 1: Popularité, 2: Soin, 3: Diffamation
            switch (typeCarte) {
                case 0:
                    cartes[i] = new CarteAttaque("Coup de sabre", "Attaque directe",2,affichage);
                    break;
                case 1:
                    cartes[i] = new CartePopularite("Discours inspirant", "Gagne en popularité",1,affichage);
                    break;
                case 2:
                    cartes[i] = new CarteSoin("Bandages", "Soigne des blessures",1,affichage);
                    break;
                case 3:
                    cartes[i] = new CarteDiffamation("Diffamation","Perte de popularité",1,affichage);
                    break;
            }
        }
    }

    public Carte piocher() {
        if (nbCartesRestantes == 0) {
            return null; // Pioche vide
        }
        int index = random.nextInt(nbCartesRestantes);
        Carte carte = cartes[index];
        cartes[index] = cartes[nbCartesRestantes - 1];
        cartes[nbCartesRestantes - 1] = null;
        nbCartesRestantes--;
        return carte;
    }
}