package pirate;

public interface IAffichage {
    void souhaiterBienvenue();
    void afficherHistoire();
    void presenterLeJeu(); 
    void afficherInfosJoueur(String nom, int vie, int popularite);
    void afficherActionCarte(String message);
    void annoncerTour(String nom);
    void annoncerGagnant(String nom);
    void indiquerPiocheCarte(String nom);
    int demanderChoixCarte(String nom, int nbMaxCarte);
}
