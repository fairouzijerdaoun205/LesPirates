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

            // Vérifier si un joueur a atteint 5 points de popularité
            if (joueurActuel.getPopularite() >= 5) {
                affichage.annoncerGagnant(joueurActuel.getNom());
                break;
            } else if (adversaire.getPopularite() >= 5) {
                affichage.annoncerGagnant(adversaire.getNom());
                break;
            }
            

            // Vérifier si un joueur a gagné (par élimination)
            if (jeu.getGagnant() != null) {
                affichage.annoncerGagnant(jeu.getGagnant().getNom());
                break;
            }

            // Changer de joueur pour le tour suivant
            Joueur temp = joueurActuel;
            joueurActuel = adversaire;
            adversaire = temp;
        }
    }
}
