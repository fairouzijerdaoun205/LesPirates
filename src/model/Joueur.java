package model;

public class Joueur {
    private String nom;
    private int vie;
    private int popularite;
    private Carte[] main;
    private int bouclier; // Protection contre les attaques

    public Joueur(String nom) {
        this.nom = nom;
        this.vie = 5;
        this.popularite = 0;
        this.bouclier = 0;
        this.main = new Carte[5]; 
    }

    public String getNom() { return nom; }
    public int getVie() { return vie; }
    public int getPopularite() { return popularite; }
    public boolean estElimine() { return vie <= 0; }
    public boolean aGagne(Joueur adversaire) {
        return this.popularite >= 5 || adversaire.estElimine();
    }

    public void recevoirCartes(Carte[] cartes) {
        if (cartes == null || cartes.length == 0) {
            System.out.println("⚠️ Aucune carte à recevoir.");
            return;
        }
        System.arraycopy(cartes, 0, main, 0, cartes.length);
    }


    public void afficherMain() {
        System.out.println("📜 Main de " + nom + " :");
        for (int i = 0; i < main.length; i++) {
            if (main[i] != null) {
                System.out.println((i + 1) + ". " + main[i].getNom() + " - " + main[i].getDescription());
            }
        }
    }
    public Carte[] getMain() {
        return main;
    }

    public void jouerCarte(int index, Joueur adversaire) {
        if (index < 0 || index >= main.length || main[index] == null) {
            System.out.println("⚠️ Choix invalide.");
            return;
        }

        Carte carteJouee = main[index];
        carteJouee.appliquerEffet(this, adversaire);
        main[index] = null; // La carte est jouée et supprimée de la main
    }

    public void perdreVie(int degats) {
        int degatsSubis = Math.max(0, degats - bouclier);
        this.vie = Math.max(0, this.vie - degatsSubis);
        bouclier = 0; // Bouclier utilisé
        System.out.println(nom + " perd " + degatsSubis + " points de vie !");
    }
    public void gagnerPopularite(int popularite) {
        this.popularite += popularite;
    }
    public void ajouterBouclier(int reductionDegats) {
        this.bouclier += reductionDegats;
    }
    public void retirerCarte(int index) {
        if (index >= 0 && index < main.length && main[index] != null) {
            System.out.println("⚔️ " + nom + " perd la carte : " + main[index].getNom());
            main[index] = null; // Retirer la carte de la main
        }
    }
}

