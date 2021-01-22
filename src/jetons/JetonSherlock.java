package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;
import Autres.Jeu;
import InterfaceGraphique.InterfaceGraphique;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
	public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		final Detectives sherlock = Jeu.listeDetectives[0]; // Sherlock correspond à l'indice 0, Waston est l'indice 1 et Toby est l'indice 2
		for (int i = 1; i < 3; i++) {
			int j = (sherlock.getPlace() - 1 + i) % 24; // Réccupération de la place Sherlock, le modulo 24 est présent car on a 24 positions possibles pour les détectives 
			if (InterfaceGraphique.d[j].getGraphic() != null) { // décalage du detective sur la seconde ligne dans le cas de deux detectives au même en endroit
				j = (j + 12) % 24;
			}
			InterfaceGraphique.d[(j)].setStyle("-fx-background-color: grey;"); // Les cases où l'on peut avancer le détective sont grisées
		}
		for (int i = 1; i < 3; i++) {
			int j = (sherlock.getPlace() - 1 + i) % 24;
			if (InterfaceGraphique.d[j].getGraphic() != null) {
				j = (j + 12) % 24;
			}
			final int k = j;
			InterfaceGraphique.d[k].setOnAction(new EventHandler<ActionEvent>() { // choix de la nouvelle position de Sherlock
				@Override
				public void handle(ActionEvent e) {
					InterfaceGraphique.d[k].setGraphic(InterfaceGraphique.sherlockView); // placement de Sherlock sur l'interface
					Jeu.listeDetectives[0].setPlace(k); // Reccupération de la nouvelle position
					for (int m = 0; m < 24; m++) { 
						InterfaceGraphique.d[m].setStyle("-fx-background-color: transparent;");
						InterfaceGraphique.d[m].setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
							}
						});
					}
					InterfaceGraphique.finAction();
				}
			});
		}
	}

	//Getters
	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public ImageView getImView() {
		return imView;
	}
}
