package src.jetons;

import java.util.Scanner;

import src.Autres.Detectives;
import src.Autres.District;

public class JetonWatson extends Jetons {
    Scanner scanner = new Scanner(System.in);
    public String nom;

    public JetonWatson() {
    }

    public JetonWatson(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[][] board) {
        System.out.println("Waston peut se déplacer d'une ou deux cases. Entrez 1 ou 2 pour le nombre de pas.");
        int choix = scanner.nextInt();
        listeDetectives[1].setPlace(choix);
        System.out.println("Watson a avancé de " + choix + " pas.");
    }

    @Override
    public String getNom() {
        return nom;
    }
}
