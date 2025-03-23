package model;

public class CartePopularite extends Carte {
    private int pointsPopularite;

    public CartePopularite(String nom, String description, int id, int pointsPopularite) {
        super(nom, description, id, TypeCarte.POPULARITE);
        this.pointsPopularite = pointsPopularite;
    }

    @Override
    public void appliquerEffet(Joueur joueurActif, Joueur joueurCible) {
        joueurActif.setPopularite(joueurActif.getPopularite() + pointsPopularite);
        System.out.println(joueurActif.getNom() + " gagne " + pointsPopularite + " points de popularité !");
    }
}