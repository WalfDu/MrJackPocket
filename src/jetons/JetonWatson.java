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

public class JetonWatson extends Jetons {
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
		/*
		 * System.out.
		 * println("Waston peut se deplacer d'une ou deux cases. Entrez 1 ou 2 pour le nombre de pas."
		 * ); int choix = scanner.nextInt(); listeDetectives[1].setPlace(choix);
		 * System.out.println("Watson a avance de " + choix + " pas.");
		 */

		final Detectives watson = Jeu.listeDetectives[1];
		Node imD1 = InterfaceGraphique.d[watson.getPlace() -1].getGraphic();
		for (int i = 1; i < 3; i++) {
			int j = (watson.getPlace() -1 + i) % 24;
			if (InterfaceGraphique.d[j].getGraphic() != null) {
				j = (j + 12) % 24;
			}
			InterfaceGraphique.d[(j)].setStyle("-fx-background-color: grey;");
		}
		for (int i = 1; i < 3; i++) {
			int j = (watson.getPlace() -1 + i) % 24;
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
					InterfaceGraphique.d[k].setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							
						}
					});
				}

			});
			
		}
	
		
		/*for (int j = 1; j < 3; j++) {
			final int k = j;
			InterfaceGraphique.d[(watson.getPlace() + k) % 24].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					int l = watson.getPlace();

					if (InterfaceGraphique.d[watson.getPlace() + k].getGraphic() != null) {
						l = (watson.getPlace() + 12) % 24;
					}
					InterfaceGraphique.d[(l + k) % 24].setGraphic(imD1);
					InterfaceGraphique.d[(l + k) % 24].setStyle("-fx-background-color: transparent;");
					InterfaceGraphique.d[(l + k + 1) % 24].setStyle("-fx-background-color: transparent;");
					InterfaceGraphique.d[(l + k - 1) % 24].setStyle("-fx-background-color: transparent;");
				}
			});
		}

		/*
		 * InterfaceGraphique.d[10].setOnAction(new EventHandler<ActionEvent>() { public
		 * void handle(ActionEvent e) { InterfaceGraphique.d[indice +
		 * 1].setStyle("-fx-background-color: grey;"); InterfaceGraphique.d[indice +
		 * 2].setStyle("-fx-background-color: grey;");
		 * InterfaceGraphique.d[11].setOnAction(new EventHandler<ActionEvent>() { public
		 * void handle(ActionEvent e) { Node imD1 =
		 * InterfaceGraphique.d[10].getGraphic();
		 * InterfaceGraphique.d[11].setGraphic(imD1);
		 * InterfaceGraphique.d[11].setStyle("-fx-background-color: transparent;");
		 * InterfaceGraphique.d[0].setStyle("-fx-background-color: transparent;"); } });
		 * InterfaceGraphique.d[0].setOnAction(new EventHandler<ActionEvent>() { public
		 * void handle(ActionEvent e) { Node imD1 =
		 * InterfaceGraphique.d[10].getGraphic();
		 * InterfaceGraphique.d[0].setGraphic(imD1);
		 * InterfaceGraphique.d[11].setStyle("-fx-background-color: transparent;");
		 * InterfaceGraphique.d[0].setStyle("-fx-background-color: transparent;"); } });
		 * } }); InterfaceGraphique.d[11].setOnAction(new EventHandler<ActionEvent>() {
		 * public void handle(ActionEvent e) {
		 * InterfaceGraphique.d[0].setStyle("-fx-background-color: grey;");
		 * InterfaceGraphique.d[1].setStyle("-fx-background-color: grey;");
		 * InterfaceGraphique.d[0].setOnAction(new EventHandler<ActionEvent>() { public
		 * void handle(ActionEvent e) { Node imD1 =
		 * InterfaceGraphique.d[11].getGraphic();
		 * InterfaceGraphique.d[0].setGraphic(imD1);
		 * InterfaceGraphique.d[0].setStyle("-fx-background-color: transparent;");
		 * InterfaceGraphique.d[1].setStyle("-fx-background-color: transparent;"); } });
		 * InterfaceGraphique.d[1].setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imD1 =
		 * InterfaceGraphique.d[11].getGraphic();
		 * InterfaceGraphique.d[1].setGraphic(imD1);
		 * InterfaceGraphique.d[0].setStyle("-fx-background-color: transparent;");
		 * InterfaceGraphique.d[1].setStyle("-fx-background-color: transparent;"); } });
		 * } });
		 * 
		 * }
		 */
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
