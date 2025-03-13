package controller;

import model.*;
import pirate.Affichage;
import java.util.Scanner;

public class ControleurJeu {
    private Jeu jeu;
    private Affichage affichage;
    private Scanner scanner;

    public ControleurJeu(Jeu jeu, Affichage affichage, Scanner scanner) {
        this.jeu = jeu;
        this.affichage = affichage;
        this.scanner = scanner;
    }

    public void demarrer() {
        affichage.souhaiterBienvenue();
        affichage.afficherHistoire();
        affichage.presenterLeJeu();
        
        Joueur joueurActuel = jeu.getJoueur1();
        Joueur adversaire = jeu.getJoueur2();
        while (!jeu.estFini()) {
            affichage.annoncerTour(joueurActuel.getNom());

            // ✅ Ajout de la pioche d'une carte
            Carte cartePiochee = jeu.getPioche().piocherCarte();
            joueurActuel.recevoirCartes(new Carte[]{cartePiochee});
            affichage.indiquerPiocheCarte(joueurActuel.getNom());

            affichage.afficherInfosJoueur(joueurActuel.getNom(), joueurActuel.getVie(), joueurActuel.getPopularite());
            joueurActuel.afficherMain();
            
            int choix = affichage.demanderChoixCarte(joueurActuel.getNom(), 5);
            joueurActuel.jouerCarte(choix, adversaire);

            if (jeu.getGagnant() != null) {
                affichage.annoncerGagnant(joueurActuel.getNom());
                break;
            }

            Joueur temp = joueurActuel;
            joueurActuel = adversaire;
            adversaire = temp;
        }
    }
}
