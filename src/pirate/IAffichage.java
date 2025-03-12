package pirate;



public interface IAffichage {
    void souhaiterBienvenue();
    void afficherHistoire();
    void presenterLeJeu(); 
    void afficherDetailCarte(String nom,String description , int effet, int numCarte);
    void afficherInfosJoueur(String nom, int vie, int popularite);
    void afficherActionCarte(String message);
    void afficherJoueurs();
   void indiquerPiocheCarte(String nom);
    void piocherMain(String nom, int nbCarte);
    void jouerCarte(String nom, ActionZone actionZone);
    void annoncerTour(String nom);
    void annoncerGagnant(String nom);
  
     int demanderChoixCarte(String nom , int nbMaxCarte);
}
