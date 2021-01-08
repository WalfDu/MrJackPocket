package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;

public class JetonEchanger extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;

    public JetonEchanger(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[] board, String joueurActuel) {
        System.out.println(

                "Quelle est la 1ère tuile que vous voulez échanger (entrez l'abscisse puis l'ordonnée de la tuile)");

        int abscisse = scanner.nextInt() - 1;
        int ordonnee = scanner.nextInt() - 1;
        int coordonnee = 3 * abscisse + ordonnee;
        System.out.println(

                "Quelle est la 2ème tuile que vous voulez échanger (entrez l'abscisse puis l'ordonnée de la tuile)");

        int abscisse2 = scanner.nextInt() - 1;
        int ordonnee2 = scanner.nextInt() - 1;
        int coordonnee2 = 3 * abscisse2 + ordonnee2;
        District temp = board[coordonnee];
        board[coordonnee] = board[coordonnee2];
        board[coordonnee2] = temp;
    }

    @Override

    public String getNom() {
        return nom;
    }
}
