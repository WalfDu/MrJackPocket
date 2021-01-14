package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JetonEchanger extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;
	public static Image im = new Image("file:images/actions/Jeton1-Face1.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);

    public JetonEchanger(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[] board, String joueurActuel) {
        System.out.println(
                "Quelle est la 1ere tuile que vous voulez echanger (entrez l'abscisse puis l'ordonnee de la tuile (entre 1 et 3)");
        int abscisse = scanner.nextInt() - 1;
        int ordonnee = scanner.nextInt() - 1;
        int coordonnee = 3 * abscisse + ordonnee;
        System.out.println(
                "Quelle est la 2eme tuile que vous voulez échanger (entrez l'abscisse puis l'ordonnée de la tuile (entre 1 et 3))");

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
	@Override
	public ImageView getImView() {
		return imView;
	}
}
