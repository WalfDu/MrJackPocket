package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;
import Autres.TableauTuiles;

public class JetonTourner extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;

    public JetonTourner() {
    }

    public JetonTourner(String nom) {
        this.nom = nom;
    }


    @Override
    public void action(Detectives[] listeDetectives, District[] board, String joueurActuel) {
        System.out.println("Entrez l'abscisse puis l'ordonnée de la tuile que vous voulez tourner:");

        int abscisse = scanner.nextInt() - 1;
        int ordonnee = scanner.nextInt() - 1;
        int coordonnee = 3 * abscisse + ordonnee;
        System.out.println("Appuyez sur <entrer> puis tapper 'stop' quand la disposition vous convient");
        scanner.nextLine();
        do {
            board[coordonnee].setMur();
            TableauTuiles.printBoardConsole(board);
        } while (!scanner.nextLine().equals("stop"));
    }


    @Override

    public String getNom() {
        return nom;
    }
}