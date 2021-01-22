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

public class JetonWatson extends Jetons { // Nous avons commente cette classe dans la classe JetonSherlock
	Scanner scanner = new Scanner(System.in);
	public String nom;
	public static Image im = new Image("file:images/actions/Jeton2-Face2.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);

	public JetonWatson() {
	}

	public JetonWatson(String nom) {
		this.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		final Detectives watson = Jeu.listeDetectives[1];
		Node imD1 = InterfaceGraphique.d[watson.getPlace() - 1].getGraphic();
		for (int i = 1; i < 3; i++) {
			int j = (watson.getPlace() - 1 + i) % 24;
			if (InterfaceGraphique.d[j].getGraphic() != null) {
				j = (j + 12) % 24;
			}
			InterfaceGraphique.d[(j)].setStyle("-fx-background-color: grey;");
		}
		for (int i = 1; i < 3; i++) {
			int j = (watson.getPlace() - 1 + i) % 24;
			if (InterfaceGraphique.d[j].getGraphic() != null) {
				j = (j + 12) % 24;
			}
			final int k = j;
			InterfaceGraphique.d[k].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					InterfaceGraphique.d[k].setGraphic(imD1);
					Jeu.listeDetectives[1].setPlace(k);
					for (int m = 0; m < 24; m++) {
						InterfaceGraphique.d[m].setStyle("-fx-background-color: transparent;");
					}
					InterfaceGraphique.finAction();
					InterfaceGraphique.d[k].setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {

						}
					});
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
