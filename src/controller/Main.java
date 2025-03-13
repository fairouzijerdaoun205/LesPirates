package controller;

import java.util.Scanner;

import model.Jeu;
import pirate.Affichage;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de Scanner pour l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Créer une instance de l'affichage pour interagir avec l'utilisateur
        Affichage affichage = new Affichage(scanner);
        
        // Créer une instance du jeu avec deux joueurs
        Jeu jeu = new Jeu("Jack le Borgne", "Bill Jambe-de-Bois");
        
        // Créer l'instance du contrôleur de jeu
        ControleurJeu controleur = new ControleurJeu(jeu, affichage, scanner);
        
        // Démarrer le jeu
        controleur.demarrer();
        
        // Fermer le scanner après l'utilisation
        scanner.close();
    }
}
