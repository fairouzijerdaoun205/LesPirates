package model;

import java.util.Scanner;

import pirate.Affichage;

public class Jeu {
  private Affichage affichage;

    private Joueur joueur1;
    private Joueur joueur2;
    private Pioche pioche;
    

    public Jeu(String nomJoueur1, String nomJoueur2) {
        joueur1 = new Joueur(nomJoueur1);
        joueur2 = new Joueur(nomJoueur2);

        Carte[] cartes = {
            new CartePopularite("Discours Inspirant", "Le joueur gagne 2 points de popularité", 1, 1, 2),
            new CartePopularite("Révolte Organisée", "Le joueur gagne 1 point de popularité", 2, 2, 1),
            new CarteAttaque("Coup de Sabre", "L'adversaire perd 2 points de vie", 3, 3, 2),
            new CarteAttaque("Abordage Réussi", "L'adversaire perd 2 points de vie", 4, 4, 2),
            new CartePopularite("Stratégie Audacieuse", "Le joueur gagne 2 points de popularité", 5, 5, 2),
            new CartePopularite("Renforts Pirates", "Le joueur gagne 1 point de popularité", 6, 6, 1),
            new CarteAttaque("Canon en Flammes", "L'adversaire perd 2 points de vie", 7, 7, 2),
            new CarteAttaque("Trahison", "L'adversaire perd 2 points de vie", 8, 8, 2),
            new CartePopularite("Mystique Voodoo", "Le joueur gagne 2 points de popularité", 9, 9, 2),
            new CarteAttaque("Explosion de Poudre", "L'adversaire perd 3 points de vie", 10, 10, 3)
        };

        pioche = new Pioche(cartes);

        distribuerCartes();
    }

    private void distribuerCartes() {
        Carte[] mainJoueur1 = {pioche.piocherCarte(), pioche.piocherCarte(), pioche.piocherCarte(), pioche.piocherCarte(), pioche.piocherCarte()};
        Carte[] mainJoueur2 = {pioche.piocherCarte(), pioche.piocherCarte(), pioche.piocherCarte(), pioche.piocherCarte(), pioche.piocherCarte()};

        joueur1.recevoirCartes(mainJoueur1);
        joueur2.recevoirCartes(mainJoueur2);
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        Joueur joueurActuel = joueur1;
        Joueur adversaire = joueur2;

        while (!joueur1.estElimine() && !joueur2.estElimine() && !joueur1.aGagne() && !joueur2.aGagne()) {
            System.out.println("\n➡️ C'est au tour de " + joueurActuel.getNom());
            joueurActuel.afficherEtat();
            adversaire.afficherEtat();

            Carte cartePiochee = pioche.piocherCarte();
            if (cartePiochee != null) {
                System.out.println(joueurActuel.getNom() + " pioche une carte : " + cartePiochee.getNom());
            }

            joueurActuel.afficherMain();
            System.out.print("🃏 Choisissez une carte à jouer (1 à 5) : ");
            int choix = scanner.nextInt() - 1;

            while (choix < 0 || choix >= 5 || joueurActuel.getMain()[choix] == null) {
                System.out.print("⚠️ Choix invalide, reessayez (1 à 5) : ");
                choix = scanner.nextInt() - 1;
            }

            String message = joueurActuel.jouerCarte(choix, adversaire);
            affichage.afficherActionCarte(message);

            if (joueurActuel.aGagne()) {
                System.out.println("\n🏆 " + joueurActuel.getNom() + " a gagné en atteignant 5 points de popularité !");
                break;
            }

            if (adversaire.estElimine()) {
                System.out.println("\n🏆 " + joueurActuel.getNom() + " a gagné en éliminant son adversaire !");
                break;
            }

            Joueur temp = joueurActuel;
            joueurActuel = adversaire;
            adversaire = temp;
        }

        scanner.close();
    }
}
