package src.jetons;

import java.util.Scanner;

import src.Autres.Detectives;
import src.Autres.District;

public class JetonEchanger extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;

    public JetonEchanger(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[][] board, String joueurActuel) {
        System.out.println(
                "Quelle est la 1ère tuile que vous voulez échanger (entrez l'abscisse puis l'ordonnée de la tuile)");
        int abscisse = scanner.nextInt() - 1;
        int ordonnee = scanner.nextInt() - 1;
        System.out.println(
                "Quelle est la 2ème tuile que vous voulez échanger (entrez l'abscisse puis l'ordonnée de la tuile)");
        int abscisse2 = scanner.nextInt() - 1;
        int ordonnee2 = scanner.nextInt() - 1;
        District temp = board[ordonnee][abscisse];
        board[ordonnee][abscisse] = board[ordonnee2][abscisse2];
        board[ordonnee2][abscisse2] = temp;
    }

    @Override
    public String getNom() {
        return nom;
    }
    /*
    public void rotation(District district) {
        boolean choixDef = false;
    
        while (!choixDef) {
            System.out.println("numero entre 1 et 4");
            Scanner scanner = new Scanner(System.in);
            int nombreMur = scanner.nextInt();
            district.choixTuile();
            choixTuile.setMur(nombreMur);
        }
    }
    
    public void deplacement() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisi le detective à deplacer");
        int choix = scanner.nextInt();
        if (Detectives.getNom() == "Watson") {
            Detectives.setPlace(Detectives.getPlace() + choix);
            switch (Detectives.getPlace()) {
                case 13:
                    Detectives.setPlace(1);
                    break;
                case 14:
                    Detectives.setPlace(2);
                    break;
            }
        }
    }*/
}
