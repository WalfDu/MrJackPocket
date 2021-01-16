package jetons;

import java.util.Scanner;
import InterfaceGraphique.InterfaceGraphique;

import Autres.Detectives;
import Autres.District;
import Autres.Jeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
    public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
       /* System.out.println(
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
					InterfaceGraphique.tuile[indice1].setDisable(true);
					for (int j = 0; j < 9; j++) {
						Node imTuile2 = InterfaceGraphique.tuile[j].getGraphic();
						final int indice2 = j;
						InterfaceGraphique.tuile[j].setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								InterfaceGraphique.tuile[indice2].setGraphic(imTuile1);
								InterfaceGraphique.tuile[indice1].setGraphic(imTuile2);
								District temp = Jeu.board[indice1];
								Jeu.board[indice1] = Jeu.board[indice2];
								Jeu.board[indice2] = temp;
								InterfaceGraphique.tuile[indice1].setDisable(false);
								InterfaceGraphique.finAction();
								for (int h = 0; h < 9; h++) {
									InterfaceGraphique.tuile[h].setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent e) {

										}
									});
								}
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
