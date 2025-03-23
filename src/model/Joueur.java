package model;

public class Joueur {
    private String nom;
    private int vie;
    private int popularite;
    private Carte[] main;

    public Joueur(String nom, int vie, int popularite) {
        this.nom = nom;
        this.vie = vie;
        this.popularite = popularite;
        this.main = new Carte[5]; // Chaque joueur a une main de 5 cartes
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getPopularite() {
        return popularite;
    }

    public void setPopularite(int popularite) {
        this.popularite = popularite;
    }

    public Carte[] getMain() {
        return main;
    }

    public void ajouterCarte(Carte carte) {
        for (int i = 0; i < main.length; i++) {
            if (main[i] == null) {
                main[i] = carte;
                break;
            }
        }
    }

    public void retirerCarte(int index) {
        if (index >= 0 && index < main.length) {
            main[index] = null; // Retire la carte en la mettant à null
        }
    }
}