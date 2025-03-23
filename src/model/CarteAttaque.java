package model;

public class CarteAttaque extends Carte {
    private int pointsAttaque;

    public CarteAttaque(String nom, String description, int id, int pointsAttaque) {
        super(nom, description, id, TypeCarte.ATTAQUE);
        this.pointsAttaque = pointsAttaque;
    }

    @Override
    public void appliquerEffet(Joueur joueurActif, Joueur joueurCible) {
        int nouvelleVie = joueurCible.getVie() - pointsAttaque;
        if (nouvelleVie < 0) {
            nouvelleVie = 0; // Les points de vie ne peuvent pas être négatifs
        }
        joueurCible.setVie(nouvelleVie);
        System.out.println(joueurCible.getNom() + " perd " + pointsAttaque + " points de vie !");
    }
}