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
	public static Image im = new Image("file:images/actions/Jeton1-Face1.png", 50, 50, false, false); // Image du bouton échanger les tuiles
	public static ImageView imView = new ImageView(im);

    public JetonEchanger(String nom) {
        this.nom = nom;
    }

    @Override
    public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		for (int i = 0; i < 9; i++) {
			Node imTuile1 = InterfaceGraphique.tuile[i].getGraphic(); // On garde en mémoire l'image de la première tuile cliquée
			final int indice1 = i; 
			InterfaceGraphique.tuile[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					InterfaceGraphique.tuile[indice1].setDisable(true); // il est impossible d'échanger une tuile avec elle même
					for (int j = 0; j < 9; j++) {
						Node imTuile2 = InterfaceGraphique.tuile[j].getGraphic(); // on garde en mémoire la seconde image
						final int indice2 = j;
						InterfaceGraphique.tuile[j].setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								InterfaceGraphique.tuile[indice2].setGraphic(imTuile1); // on échange les images des deux tuiles 
								InterfaceGraphique.tuile[indice1].setGraphic(imTuile2);
								District temp = Jeu.board[indice1];
								Jeu.board[indice1] = Jeu.board[indice2];
								Jeu.board[indice2] = temp;
								InterfaceGraphique.tuile[indice1].setDisable(false); // on réactive les boutons des tuiles
								InterfaceGraphique.finAction(); // passage à l'action suivante
								for (int h = 0; h < 9; h++) {
									InterfaceGraphique.tuile[h].setOnAction(new EventHandler<ActionEvent>() { // permet d'empecher de faire un autre échnage de tuile
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

    // Getters and Setters
    @Override
    public String getNom() {
        return nom;
    }
	@Override
	public ImageView getImView() {
		return imView;
	}
}
