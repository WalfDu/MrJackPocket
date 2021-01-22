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
		final Detectives sherlock = Jeu.listeDetectives[0]; // Sherlock correspond a l'indice 0, Waston est l'indice 1 et Toby est l'indice 2
		for (int i = 1; i < 3; i++) {
			int j = (sherlock.getPlace() - 1 + i) % 24; // Reccuperation de la place Sherlock, le modulo 24 est present car on a 24 positions possibles pour les detectives 
			if (InterfaceGraphique.d[j].getGraphic() != null) { // decalage du detective sur la seconde ligne dans le cas de deux detectives au meme en endroit
				j = (j + 12) % 24;
			}
			InterfaceGraphique.d[(j)].setStyle("-fx-background-color: grey;"); // Les cases ou l'on peut avancer le detective sont grisees
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
					Jeu.listeDetectives[0].setPlace(k); // Reccuperation de la nouvelle position
					for (int m = 0; m < 24; m++) {
						InterfaceGraphique.d[m].setStyle("-fx-background-color: transparent;");
						InterfaceGraphique.d[m].setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) { // empeche le joueur de redeplacer Sherlock
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
