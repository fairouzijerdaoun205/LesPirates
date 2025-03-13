package model;

public class CarteAttaque extends Carte {
    private int degats;

    public CarteAttaque(String nom, String description, int numCarte, int degats) {
        super(nom, description, numCarte, pirate.ActionZone.ATTAQUE);
        this.degats = degats;
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        adversaire.perdreVie(degats);
        System.out.println(joueur.getNom() + " attaque et inflige " + degats + " dégâts !");
    }
}
