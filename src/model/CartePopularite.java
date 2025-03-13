package model;

public class CartePopularite extends Carte {
    private int popularite;

    public CartePopularite(String nom, String description, int numCarte, int popularite) {
        super(nom, description, numCarte, pirate.ActionZone.POPULARITE);
        this.popularite = popularite;
    }
    public int getPopularite() {
        return popularite;
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.gagnerPopularite(popularite);
        System.out.println(joueur.getNom() + " gagne " + popularite + " points de popularité !");
    }
}
