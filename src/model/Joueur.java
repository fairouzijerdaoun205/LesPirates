package model;

public class Joueur {
    private String nom;
    private int vie;
    private int popularite;
    private Carte[] main;

    public Joueur(String nom) {
        this.nom = nom;
        this.vie = 5;
        this.popularite = 0;
        this.main = new Carte[5]; 
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void perdreVie(int degats) {
        this.vie -= degats;
        if (this.vie < 0) this.vie = 0;
    }

    public int getPopularite() {
        return popularite;
    }

    public void gagnerPopularite(int points) {
        this.popularite += points;
    }

    public boolean estElimine() {
        return vie <= 0;
    }

    public boolean aGagne() {
        return popularite >= 5;
    }

    public void recevoirCartes(Carte[] cartes) {
        for (int i = 0; i < cartes.length; i++) {
            main[i] = cartes[i];
        }
    }

    public void afficherEtat() {
        System.out.println("\n🔹 " + nom + " - Vie : " + vie + " ❤️ | Popularité : " + popularite + " ⭐");
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
    public String jouerCarte(int index, Joueur adversaire) {
        if (index >= 0 && index < main.length && main[index] != null) {
            Carte carteJouee = main[index];
            String message = "";

            if (carteJouee.getActionZone() == pirate.ActionZone.ATTAQUE) {
                CarteAttaque carteAttaque = (CarteAttaque) carteJouee;
                adversaire.perdreVie(carteAttaque.getDegats());
                message = nom + " attaque " + adversaire.getNom() + " et lui inflige " + carteAttaque.getDegats() + " dégâts ! ⚔️";
            } else if (carteJouee.getActionZone() == pirate.ActionZone.POPULARITE) {
                CartePopularite cartePopularite = (CartePopularite) carteJouee;
                gagnerPopularite(cartePopularite.getPopularite());
                message = nom + " gagne " + cartePopularite.getPopularite() + " points de popularité ! 🌟";
            }

            main[index] = null;
            return message;
        }
        return "Action invalide.";
    }

}
