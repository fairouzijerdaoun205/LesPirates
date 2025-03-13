package model;

public class CarteDefense extends Carte {
    private int reductionDegats;

    public CarteDefense(String nom, String description, int numCarte, int reductionDegats) {
        super(nom, description, numCarte, pirate.ActionZone.POPULARITE);
        this.reductionDegats = reductionDegats;
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        joueur.ajouterBouclier(reductionDegats);
        System.out.println(joueur.getNom() + " se protège et réduit les dégâts de " + reductionDegats + " !");
    }
}
