package model;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Pioche pioche;

    public Jeu(String nomJoueur1, String nomJoueur2) {
        joueur1 = new Joueur(nomJoueur1);
        joueur2 = new Joueur(nomJoueur2);

        // Création de toutes les cartes du jeu sous forme de tableau
        Carte[] cartes = {
            new CartePopularite("Discours Inspirant", "Le joueur gagne 2 points de popularité", 1, 2),
            new CartePopularite("Révolte Organisée", "Le joueur gagne 1 point de popularité", 2, 1),
            new CarteAttaque("Coup de Sabre", "L'adversaire perd 2 points de vie", 3, 2),
            new CarteAttaque("Abordage Réussi", "L'adversaire perd 2 points de vie", 4, 2),
            new CartePopularite("Stratégie Audacieuse", "Le joueur gagne 2 points de popularité", 5, 2),
            new CartePopularite("Renforts Pirates", "Le joueur gagne 1 point de popularité", 6, 1),
            new CarteAttaque("Canon en Flammes", "L'adversaire perd 2 points de vie", 7, 2),
            new CarteAttaque("Trahison", "L'adversaire perd 2 points de vie", 8, 2),
            new CartePopularite("Mystique Voodoo", "Le joueur gagne 2 points de popularité", 9, 2),
            new CarteAttaque("Explosion de Poudre", "L'adversaire perd 3 points de vie", 10, 3),
            new CarteDefense("Bouclier en Bois", "Réduit les dégâts reçus de 1 pendant un tour", 11, 1),
            new CarteSabotage("Espionnage", "L'adversaire perd une carte au hasard", 12)
        };

        // Initialisation de la pioche avec un tableau
        pioche = new Pioche(cartes);
        distribuerCartes();
    }

    private void distribuerCartes() {
        joueur1.recevoirCartes(pioche.piocherCartes(4));
        joueur2.recevoirCartes(pioche.piocherCartes(4));
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }
    public Pioche getPioche() {
        return pioche;
    }

    public boolean estFini() {
        return joueur1.estElimine() || joueur2.estElimine() || joueur1.aGagne(joueur2) || joueur2.aGagne(joueur1);
    }


    public Joueur getGagnant() {
        if (joueur1.aGagne(joueur2)) return joueur1;
        if (joueur2.aGagne(joueur1)) return joueur2;
        return null;
    }

}

