package model;

import java.util.Random;

public class CarteSabotage extends Carte {
    public CarteSabotage(String nom, String description, int numCarte) {
        super(nom, description, numCarte, pirate.ActionZone.POPULARITE);
    }

    @Override
    public void appliquerEffet(Joueur joueur, Joueur adversaire) {
        Random rand = new Random();
        int index = rand.nextInt(5);
        
        // Vérifier que la carte à l'index existe
        while (adversaire.getMain()[index] == null) {
            index = rand.nextInt(5);  // Regénérer un index si la carte est nulle
        }

        adversaire.retirerCarte(index);
        System.out.println("💥 " + adversaire.getNom() + " perd une carte au hasard !");
    }

}
