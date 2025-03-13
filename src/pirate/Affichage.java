package pirate;

import java.util.Scanner;

public class Affichage implements IAffichage {
    private Scanner scanner;

    public Affichage(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void souhaiterBienvenue() {
        System.out.println("\n Bienvenue dans le jeu des Pirates ! ");
    }

    @Override
    public void afficherHistoire() {
        System.out.println("\n=== L'ÉPOPÉE DES PIRATES ===");
        System.out.println("Jack le Borgne et Bill Jambe-de-Bois se disputent le commandement du navire 'Le Sanguinaire'.");
        System.out.println("L'équipage organise un vote pour désigner le nouveau capitaine.\n");
    }

    @Override
    public void presenterLeJeu() {
        System.out.println("\n=== LES RÈGLES DU JEU ===");
        System.out.println("- Chaque joueur commence avec 5 points de vie et 0 point de popularité.");
        System.out.println("- Le but est d'atteindre 5 points de popularité ou de réduire les points de vie de l'adversaire à 0.");
        System.out.println("- Chaque tour, piochez une carte et jouez-la pour attaquer ou gagner en popularité.\n");
    }

    @Override
    public void annoncerTour(String nom) {
        System.out.println("\n C'est au tour de " + nom);
    }

    @Override
    public void annoncerGagnant(String nom) {
        System.out.println("\n Félicitations à " + nom + " !");
    }

    @Override
    public void afficherInfosJoueur(String nom, int vie, int popularite) {
        System.out.println("🔹 " + nom + " - Vie : " + vie + " ❤️ | Popularité : " + popularite + " ⭐");
    }

    @Override
    public void afficherActionCarte(String message) {
        System.out.println(message);
    }

    @Override
    public void indiquerPiocheCarte(String nom) {
        System.out.println(nom + " pioche une carte...");
    }

    @Override
    public int demanderChoixCarte(String nom, int nbMaxCarte) {
        int numCarte;
        do {
            System.out.println("🃏 " + nom + ", quelle carte veux-tu jouer ?");
            System.out.print("➡️ Entre un numéro de carte (1-4) : ");


            while (!scanner.hasNextInt()) {
                System.out.print("⚠️ Saisie invalide. Veuillez entrer un nombre valide : ");
                scanner.next();
            }

            numCarte = scanner.nextInt();
        } while (numCarte < 1 || numCarte > nbMaxCarte);

        return numCarte - 1;
    }
}
