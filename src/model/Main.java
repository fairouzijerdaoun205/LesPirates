package model;

public class Main {
    private static final int TAILLE_MAIN = 5;
    private Carte[] cartes = new Carte[TAILLE_MAIN];

    public Main() {}

    public static int getTailleMain() {
        return TAILLE_MAIN;
    }

    public void afficher() {
        for (int i = 0; i < TAILLE_MAIN; i++) {
            if (cartes[i] != null) {
                cartes[i].afficher(i + 1);
            }
        }
    }

    public boolean ajouterCarte(Carte carte) {
        for (int i = 0; i < TAILLE_MAIN; i++) {
            if (cartes[i] == null) {
                cartes[i] = carte;
                return true;
            }
        }
        return false; // Main pleine
    }

    public Carte retirerCarte(int numCarte) {
        if (numCarte < 1 || numCarte > TAILLE_MAIN || cartes[numCarte - 1] == null) {
            return null; // Carte invalide
        }
        Carte carte = cartes[numCarte - 1];
        cartes[numCarte - 1] = null;
        return carte;
    }
}