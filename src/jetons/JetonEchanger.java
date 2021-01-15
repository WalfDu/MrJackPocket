package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import InterfaceGraphique.InterfaceGraphique;
public class JetonEchanger extends Jetons {
    Scanner scanner = new Scanner(System.in);
    String nom;
	public static Image im = new Image("file:images/actions/Jeton1-Face1.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);

    public JetonEchanger(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
        /*System.out.println(
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
    */
		for (int i = 0; i < 9; i++) {
			Node imTuile1 = InterfaceGraphique.tuile[i].getGraphic();
			final int indice1 = i;
			InterfaceGraphique.tuile[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					for (int j = 0; j < 9; j++) {
						Node imTuile2 = InterfaceGraphique.tuile[j].getGraphic();
						final int indice2 = j;
						InterfaceGraphique.tuile[j].setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								InterfaceGraphique.tuile[indice2].setGraphic(imTuile1);
								InterfaceGraphique.tuile[indice1].setGraphic(imTuile2);
							}
						});
					}
				}

			});

		}
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
