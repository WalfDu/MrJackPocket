package src.jetons;

import java.util.Scanner;

import src.Autres.Detectives;
import src.Autres.District;
import src.Autres.TableauTuiles;

public class JetonRotation2 extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;

    public JetonRotation2() {
    }

    public JetonRotation2(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[][] board, String joueurActuel) {
        System.out.println("Entrez l'abscisse puis l'ordonnée de la tuile que vous voulez tourner:");
        int abscisse = scanner.nextInt() - 1;
        int ordonne = scanner.nextInt() - 1;
        System.out.println("Appuyez sur <entrer> puis tapper 'stop' quand la disposition vous convient");
        scanner.nextLine();
        do {
            board[ordonne][abscisse].setMur();
            TableauTuiles.printBoardConsole(board);
        } while (!scanner.nextLine().equals("stop"));
    }

    @Override
    public String getNom() {
        return nom;
    }
}