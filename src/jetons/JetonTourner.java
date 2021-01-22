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

public class JetonTourner extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;
	public static Image im = new Image("file:images/actions/Jeton1-Face2.png", 50, 50, false, false); // image du jeton tourner
	public static ImageView imView = new ImageView(im);

	public JetonTourner() {
	}

	public JetonTourner(String nom) {
		this.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		
		InterfaceGraphique.root.add(InterfaceGraphique.validerB, 6, 1);
		for (int i = 0; i < 9; i++) {
			final int k = i; // declaration d'une variable final pour eviter une erreur dans la methode qui suit
			InterfaceGraphique.tuile[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Jeu.board[k].setMur(); //On reccupere la position du mur a chaque clique
					InterfaceGraphique.tuile[k].setRotate((double) Jeu.board[k].getMur() * 90 + 180);  
					// rotation de 90° de la tuile a chaque clique
					for (int j = 0; j < 9; j++) {
						InterfaceGraphique.tuile[j].setDisable(true);
					}
					InterfaceGraphique.tuile[k].setDisable(false);
					InterfaceGraphique.validerB.setOnAction(new EventHandler<ActionEvent>() {// Le joueur doit valider la rotation qu'il a choisit
						@Override
						public void handle(ActionEvent e) {
							InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.validerB);
							for (int h = 0; h < 9; h++) {
								InterfaceGraphique.tuile[h].setDisable(false);
								InterfaceGraphique.tuile[h].setOnAction(new EventHandler<ActionEvent>() { // Empeche le joueur de faire tourner une autre tuille
									@Override
									public void handle(ActionEvent e) {
									}
								});
							}
							InterfaceGraphique.finAction();
						}
					});
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