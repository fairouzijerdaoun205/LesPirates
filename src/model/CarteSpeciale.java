package model;

public abstract class CarteSpeciale extends Carte {
    private int pointsVie;
    private int pointsPopularite;

    public CarteSpeciale(String nom, String description, int id, int pointsVie, int pointsPopularite) {
        super(nom, description, id, TypeCarte.SPECIALE);
        this.pointsVie = pointsVie;
        this.pointsPopularite = pointsPopularite;
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public int getPointsPopularite() {
        return pointsPopularite;
    }

    @Override
    public abstract void appliquerEffet(Joueur joueurActif, Joueur joueurCible);
}