package model;

public abstract class Carte {
    private String nom;
    private String description;
    private int id;
    private TypeCarte type;

    public Carte(String nom, String description, int id, TypeCarte type) {
        this.nom = nom;
        this.description = description;
        this.id = id;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public TypeCarte getType() {
        return type;
    }

    public abstract void appliquerEffet(Joueur joueurActif, Joueur joueurCible);
}