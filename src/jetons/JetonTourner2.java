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

public class JetonTourner2 extends Jetons { // // Nous avons comment� cette classe dans la classe JetonTourner
    Scanner scanner = new Scanner(System.in);
    String nom;
	public static Image im = new Image("file:images/actions/Jeton4-Face2.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);

    public JetonTourner2() {
    }

    public JetonTourner2(String nom) {
        this.nom = nom;
    }
    
    @Override
    public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		InterfaceGraphique.root.add(InterfaceGraphique.validerB, 6, 1);
    	for (int i = 0; i < 9; i++) {
			final int k = i;
			InterfaceGraphique.tuile[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Jeu.board[k].setMur();
					for (int j = 0; j < 9; j++) {
						InterfaceGraphique.tuile[j].setDisable(true);
					}
					InterfaceGraphique.tuile[k].setDisable(false);
					InterfaceGraphique.tuile[k].setRotate((double) Jeu.board[k].getMur() * 90 + 180);
					InterfaceGraphique.validerB.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.validerB);
							for (int h = 0; h < 9; h++) {
								InterfaceGraphique.tuile[h].setDisable(false);
								InterfaceGraphique.tuile[h].setOnAction(new EventHandler<ActionEvent>() {
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
    	/* //HelloApp.idEnCours = "";
    	System.out.println("Entrez l'abscisse puis l'ordonnée de la tuile que vous voulez tourner:");
        /*if (scanner.nextLine().equals("")) {
        	while(!HelloApp.idEnCours.substring(0, 1).equals("Q")) {
        		//Thread.sleep((long) 1);
        	}
        	board[Integer.parseInt(HelloApp.idEnCours.substring(1, 2))].setMur();
        	System.out.println("La tuile " + Integer.parseInt(HelloApp.idEnCours.substring(1, 2)) + " a tourné");
        } else {
        int abscisse = scanner.nextInt() - 1;
        int ordonnee = scanner.nextInt() - 1;
        int coordonnee = 3 * abscisse + ordonnee;
        System.out.println("Appuyez sur <entrer> puis tapper 'stop' quand la disposition vous convient");
        scanner.nextLine();
        do {
            board[coordonnee].setMur();
            //interfaceG.printBoardInterface();
            //TableauTuiles.printBoardConsole(board);
        } while (!scanner.nextLine().equals("stop"));
        //}*/
    }
    
    @Override
    public String getNom() {
        return nom;
    }
    
	public ImageView getImView() {
		return imView;
	}
}
