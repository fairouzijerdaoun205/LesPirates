package model;

import pirate.Affichage;

import java.util.Scanner;

public class Jeu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Affichage affichage = new Affichage(scanner);

        affichage.souhaiterBienvenue();
        affichage.afficherHistoire();
        affichage.presenterLeJeu();

        Joueur joueur1 = new Joueur("Jack le Borgne", 5, 0);
        Joueur joueur2 = new Joueur("Bill Jambe-de-Bois", 5, 0);

        Carte[] pioche = creerPioche();
        // Mélanger la pioche
        melangerPioche(pioche);

        // Afficher la pioche mélangée (pour vérification)
        System.out.println("Pioche mélangée :");
        for (Carte carte : pioche) {
            System.out.println(carte.getNom());
        }
        distribuerCartes(pioche, joueur1);
        distribuerCartes(pioche, joueur2);

        boolean partieEnCours = true;
        boolean tourJoueur1 = true;
        int tour = 1;

        while (partieEnCours) {
            affichage.annoncerTour(tourJoueur1 ? joueur1.getNom() : joueur2.getNom());

            if (tourJoueur1) {
                tourDuJoueur(joueur1, joueur2, pioche, affichage);
                tourJoueur1 = false;
            } else {
                tourDuJoueur(joueur2, joueur1, pioche, affichage);
                tourJoueur1 = true;
            }

            String gagnant = verifierVictoire(joueur1, joueur2);
            if (gagnant != null) {
                affichage.annoncerGagnant(gagnant);
                partieEnCours = false;
            }

            tour++;
        }
    }

    private static Carte[] creerPioche() {
        return new Carte[] {
            new CarteSpeciale("Héros Traître", "Vole 2 popularité, mais perd 1 vie pour sa trahison", 1, -1, 2) {
                @Override
                public void appliquerEffet(Joueur joueurActif, Joueur joueurCible) {
                    joueurActif.setPopularite(joueurActif.getPopularite() + 2);
                    joueurActif.setVie(joueurActif.getVie() - 1);
                    System.out.println(joueurActif.getNom() + " gagne 2 points de popularité mais perd 1 point de vie !");
                }
            },
            new CarteSpeciale("Trésor Maudit", "Vole 2 popularité", 2, 0, 2) {
                @Override
                public void appliquerEffet(Joueur joueurActif, Joueur joueurCible) {
                    joueurActif.setPopularite(joueurActif.getPopularite() + 2);
                    System.out.println(joueurActif.getNom() + " gagne 2 points de popularité !");
                }
            },
            new CartePopularite("Abordage Réussi", "+2 Popularité", 3, 2),
            new CarteAttaque("Coup de sabre", "-2 Vie", 4, 2),
            new CarteAttaque("Canon en Feu", "-3 Vie", 5, 3),
            new CarteSpeciale("Sabotage", "L'adversaire perd une carte aléatoire", 6, 0, 0) {
                @Override
                public void appliquerEffet(Joueur joueurActif, Joueur joueurCible) {
                    System.out.println("Sabotage : L'adversaire perd une carte aléatoire !");
                }
            },
            new CartePopularite("Discours de Capitaine", "+2 Popularité", 7, 2),
            new CartePopularite("Main de fer", "+3 Popularité", 8, 3),
            new CarteAttaque("Tempête de Sable", "-3 Vie et empêche de jouer une carte au prochain tour", 10, 3),
            new CartePopularite("Charisme Naturel", "+3 Popularité", 11, 3),
            new CarteAttaque("Tornade Dévastatrice", "-3 Vie mais perd 1 popularité", 12, 5),
            new CarteSpeciale("Chantage", "L'adversaire perd une carte", 17, 0, 0) {
                @Override
                public void appliquerEffet(Joueur joueurActif, Joueur joueurCible) {
                    System.out.println("Chantage : L'adversaire perd une carte !");
                }
            }
        };
    }
    private static void melangerPioche(Carte[] pioche) {
	    for (int i = pioche.length - 1; i > 0; i--) {
	        int j = (int) (Math.random() * (i + 1)); // Choisir un index aléatoire entre 0 et i
	        Carte temp = pioche[i]; // Échanger pioche[i] et pioche[j]
	        pioche[i] = pioche[j];
	        pioche[j] = temp;
	    }
	}
    private static void distribuerCartes(Carte[] pioche, Joueur joueur) {
        for (int i = 0; i < 5; i++) {
            joueur.ajouterCarte(pioche[i]);
        }
    }

    private static String verifierVictoire(Joueur joueur1, Joueur joueur2) {
        if (joueur1.getPopularite() >= 5) {
            return joueur1.getNom() + " a atteint 5 points de popularité !";
        } else if (joueur2.getPopularite() >= 5) {
            return joueur2.getNom() + " a atteint 5 points de popularité !";
        } else if (joueur1.getVie() <= 0) {
            return joueur2.getNom() + " a réduit " + joueur1.getNom() + " à 0 point de vie !";
        } else if (joueur2.getVie() <= 0) {
            return joueur1.getNom() + " a réduit " + joueur2.getNom() + " à 0 point de vie !";
        }
        return null;
    }

    private static void tourDuJoueur(Joueur joueurActif, Joueur adversaire, Carte[] pioche, Affichage affichage) {
        affichage.afficherInfosJoueur(joueurActif.getNom(), joueurActif.getVie(), joueurActif.getPopularite());

        Carte[] main = joueurActif.getMain();
        for (int i = 0; i < main.length; i++) {
            if (main[i] != null) {
                affichage.afficherActionCarte((i + 1) + ". " + main[i].getNom() + " - " + main[i].getDescription());
            }
        }

        int choix = affichage.demanderChoixCarte(joueurActif.getNom(), main.length);
        Carte carteChoisie = main[choix];
        joueurActif.retirerCarte(choix);
        

        carteChoisie.appliquerEffet(joueurActif, adversaire);

        if (pioche.length > 0) {
            joueurActif.ajouterCarte(pioche[0]);
            Carte[] nouvellePioche = new Carte[pioche.length - 1];
            System.arraycopy(pioche, 1, nouvellePioche, 0, nouvellePioche.length);
            pioche = nouvellePioche;
        }
    }
}