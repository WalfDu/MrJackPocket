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

public class JetonToby extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;
	public static Image im = new Image("file:images/actions/Jeton2-Face1.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);

	public JetonToby() {
	}

	public JetonToby(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		/*System.out.println("Toby peut se deplacer d'une ou deux cases. Entrez 1 ou 2 pour le nombre de pas.");
		int choix = scanner.nextInt();
		listeDetectives[2].setPlace(choix);
		System.out.println("Toby a avance de " + choix + " pas.");*/
		
		final Detectives toby = Jeu.listeDetectives[2];
		Node imD1 = InterfaceGraphique.d[toby.getPlace() -1].getGraphic();
		for (int i = 1; i < 3; i++) {
			int j = (toby.getPlace() -1 + i) % 24;
			if (InterfaceGraphique.d[j].getGraphic() != null) {
				j = (j + 12) % 24;
			}
			InterfaceGraphique.d[(j)].setStyle("-fx-background-color: grey;");
		}
		for (int i = 1; i < 3; i++) {
			int j = (toby.getPlace() -1 + i) % 24;
			if (InterfaceGraphique.d[j].getGraphic() != null) {
				j = (j + 12) % 24;
			}
			final int k = j;
			InterfaceGraphique.d[k].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					InterfaceGraphique.d[k].setGraphic(imD1);
					Jeu.listeDetectives[2].setPlace(k);
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
