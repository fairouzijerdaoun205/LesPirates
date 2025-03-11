package model;

import pirate.Affichage;
import pirate.IAffichage;

public class Jeu {
    private static final int NB_JOUEURS = 2;
    private static IAffichage affichage = new Affichage();
    private Joueur[] joueurs = new Joueur[NB_JOUEURS];
    private Pioche pioche ;

    public Jeu() {
    	this.pioche = new Pioche(affichage);
        joueurs[0] = new Joueur(Nom.JACK_LE_BORGNE);
        joueurs[1] = new Joueur(Nom.BILL_JAMBE_DE_BOIS);
    }

    public static IAffichage getAffichage() {
        return affichage;
    }

    public void lancerJeu() {
        affichage.souhaiterBienvenue();
        affichage.raconterHistoire();
        affichage.presenterJeux();
        distribuerCartesInitiales();
        jouer();
    }

    private void distribuerCartesInitiales() {
        for (Joueur joueur : joueurs) {
            for (int i = 0; i < Main.getTailleMain() - 1; i++) {
                joueur.ajouterCarte(pioche.piocher());
            }
            affichage.piocherMain(joueur.getNom().toString(), Main.getTailleMain() - 1);
            joueur.afficherMain();
        }
    }

    private void jouer() {
        boolean partieTerminee = false;
        while (!partieTerminee) {
            for (Joueur joueur : joueurs) {
                affichage.afficherTour(joueur.getNom().toString());
                Carte cartePiochee = pioche.piocher();
                if (cartePiochee != null) {
                    joueur.ajouterCarte(cartePiochee);
                    affichage.piocherCarte(joueur.getNom().toString());
                }
                joueur.afficherMain();
                int choixCarte = affichage.choisirCarte(joueur.getNom().toString(), Main.getTailleMain());
                joueur.jouerCarte(choixCarte, getAdversaire(joueur));
                affichage.afficherJoueurs();
                for (Joueur j : joueurs) {
                    j.afficher();
                }
                if (verifierGagnant()) {
                    partieTerminee = true;
                    affichage.afficherGagnant(donnerGagnant().getNom().toString());
                    break;
                }
            }
        }
    }

    private Joueur getAdversaire(Joueur joueur) {
        return joueur == joueurs[0] ? joueurs[1] : joueurs[0];
    }

    private boolean verifierGagnant() {
        for (Joueur joueur : joueurs) {
            if (joueur.getPointsDeVie() == 0 || joueur.getPopularite() == 5) {
                return true;
            }
        }
        return false;
    }

    private Joueur donnerGagnant() {
        for (Joueur joueur : joueurs) {
            if (joueur.getPopularite() == 5) {
                return joueur;
            }
            if (joueur.getPointsDeVie() == 0) {
                return getAdversaire(joueur);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancerJeu();
    }
}