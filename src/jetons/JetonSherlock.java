package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JetonSherlock extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;
	public static Image im = new Image("file:images/actions/Jeton3-Face1.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);

    public JetonSherlock() {
    }

    public JetonSherlock(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[] board, String joueurActuel) {
        System.out.println("Sherlock peut se déplacer d'une ou deux cases. Entrez 1 ou 2 pour le nombre de pas.");
        int choix = scanner.nextInt();
        listeDetectives[0].setPlace(choix);
        System.out.println("Sherlock a avancé de " + choix + " pas.");
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
