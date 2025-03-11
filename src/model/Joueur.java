package model;

import pirate.IAffichage;

public class Joueur {
    private Nom nom;
    private int pointsDeVie = 5;
    private int popularite = 0;
    private Main main;
    private static final IAffichage affichage = Jeu.getAffichage();

    public Joueur(Nom nom) {
        this.nom = nom;
        this.main = new Main();
    }
    
    public void setVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0; // Les points de vie ne peuvent pas être négatifs
        }
    }

    public Nom getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int getPopularite() {
        return popularite;
    }

    public void setPopularite(int popularite) {
        this.popularite = popularite;
    }

    public Main getMain() {
        return main;
    }

    public void afficher() {
        affichage.afficherJoueur(nom.toString(), pointsDeVie, popularite);
    }

    public void afficherMain() {
        affichage.afficherCartes(nom.toString());
        main.afficher();
    }

    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        if (pointsDeVie < 0) {
            pointsDeVie = 0;
        }
    }

    public void recevoirSoin(int soin) {
        pointsDeVie += soin;
        if (pointsDeVie > 5) {
            pointsDeVie = 5;
        }
    }

    public void gagnerPopularite(int points) {
        popularite += points;
        if (popularite > 5) {
            popularite = 5;
        }
    }

    public void perdrePopularite(int points) {
        popularite -= points;
        if (popularite < 0) {
            popularite = 0;
        }
    }

    public boolean ajouterCarte(Carte carte) {
        return main.ajouterCarte(carte);
    }

    public void jouerCarte(int numCarte, Joueur adversaire) {
        Carte carte = main.retirerCarte(numCarte);
        if (carte != null) {
            carte.appliquerEffet(this, adversaire);
            affichage.jouerCarte(nom.toString(), carte.donnerZone());
        }
    }
}