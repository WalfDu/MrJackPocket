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

public class JetonDetective extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;
	public static Image im = new Image("file:images/actions/Jeton4-Face1.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);
	int choix;

	public JetonDetective() {
	}

	public JetonDetective(String nom) {
		this.nom = nom;
	}

	@Override

	public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		if (jActuel == 1) {
			InterfaceGraphique.root.add(InterfaceGraphique.validerB, 6, 1);
			InterfaceGraphique.validerB.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					for (int m = 0; m < 24; m++) {
						InterfaceGraphique.d[m].setStyle("-fx-background-color: transparent;");
						InterfaceGraphique.d[m].setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
							}
						});
					}
					InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.validerB);
					InterfaceGraphique.finAction();
				}
			});
		}
		for (int i = 0; i < 3; i++) {
			int positionPotentielle = Jeu.listeDetectives[i].getPlace()%24;
			final int I = i;
			if (InterfaceGraphique.d[positionPotentielle].getGraphic() != null) {
				positionPotentielle = (positionPotentielle + 12) % 24;
			}
			InterfaceGraphique.d[positionPotentielle].setStyle("-fx-background-color: grey;");
			final int k = positionPotentielle;
			InterfaceGraphique.d[k].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Node imD1 = InterfaceGraphique.d[Jeu.listeDetectives[I].getPlace() - 1].getGraphic();
					InterfaceGraphique.d[k].setGraphic(imD1);
					Jeu.listeDetectives[I].setPlace(k);
					for (int m = 0; m < 24; m++) {
						InterfaceGraphique.d[m].setStyle("-fx-background-color: transparent;");
						InterfaceGraphique.d[m].setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
							}
						});
					}
					InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.validerB);
					InterfaceGraphique.finAction();
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
