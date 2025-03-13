package controller;

import java.util.Scanner;

import model.Jeu;
import pirate.Affichage;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
      
        Affichage affichage = new Affichage(scanner);
        
        
        Jeu jeu = new Jeu("Jack le Borgne", "Bill Jambe-de-Bois");
        
      
        ControleurJeu controleur = new ControleurJeu(jeu, affichage, scanner);
        
       
        controleur.demarrer();
        
      
        scanner.close();
    }
}
