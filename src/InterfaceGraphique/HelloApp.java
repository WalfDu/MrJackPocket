package InterfaceGraphique;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import Autres.District;
import Autres.Jeu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import jetons.JetonAlibi;
import jetons.JetonTourner;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

import javafx.scene.layout.*;

public class HelloApp extends Application {

	//public static void main(String[] args) {
		//Jeu.main(args);
		//launch(args);
	//}

	static GridPane root = new GridPane();

	public static void printBoardInterface() {
		root.add(tuile[0], 1, 2);
		root.add(tuile[1], 2, 2);
		root.add(tuile[2], 3, 2);
		root.add(tuile[3], 1, 3);
		root.add(tuile[4], 2, 3);
		root.add(tuile[5], 3, 3);
		root.add(tuile[6], 1, 4);
		root.add(tuile[7], 2, 4);
		root.add(tuile[8], 3, 4);
		root.add(D[0], 1, 1);
		root.add(D[1], 2, 1);
		root.add(D[2], 3, 1);
		root.add(D[3], 4, 2);
		root.add(D[4], 4, 3);
		root.add(D[5], 4, 4);
		root.add(D[6], 3, 5);
		root.add(D[7], 2, 5);
		root.add(D[8], 1, 5);
		root.add(D[9], 0, 4);
		root.add(D[10], 0, 3);
		root.add(D[11], 0, 2);
		root.add(Alibi2, 1, 7);
		root.add(Alibi, 0, 7);
		root.add(DeplacementT, 1, 0);
		root.add(DeplacementS, 2, 0);
		root.add(DeplacementW, 3, 0);
		root.add(TroisD, 4, 0);
	}
	
	ImageView ticverte = new ImageView(getClass().getResource("ticverte.png").toString());
	ImageView False = new ImageView(getClass().getResource("False.png").toString());
	ImageView Echanger = new ImageView(getClass().getResource("Jeton1-Face1.png").toString());
	ImageView Tourner = new ImageView(getClass().getResource("Jeton1-Face2.png").toString());
	ImageView DeplacementWatson = new ImageView(getClass().getResource("Jeton2-Face2.png").toString());
	ImageView DeplacementSherlock = new ImageView(getClass().getResource("Jeton3-Face1.png").toString());
	ImageView DeplacementTobi = new ImageView(getClass().getResource("Jeton2-Face1.png").toString());
	ImageView Watson = new ImageView(getClass().getResource("Watson.png").toString());
	ImageView Tobi = new ImageView(getClass().getResource("Tobi.png").toString());
	ImageView Sherlock = new ImageView(getClass().getResource("Sherlock.png").toString());
	ImageView TroisDetectives = new ImageView(getClass().getResource("Jeton4-Face1.png").toString());
	ImageView PileHautALibi = new ImageView(getClass().getResource("alibi-card.png").toString());

	Button ChoixTourner = new Button();
	Button choixEchangerTuile = new Button();
	static Button[] D = new Button[12];
	static Button TroisD = new Button();
	static Button DeplacementW = new Button();
	static Button DeplacementS = new Button();
	static Button DeplacementT = new Button();
	static Button Alibi = new Button();
	static Button Alibi2 = new Button();
	Button innocent = new Button();
	static Button[] tuile = new Button[9];
	Button finDuTour = new Button();

	@Override
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le
		
		
		PileHautALibi.setFitHeight(100);
		ticverte.setFitWidth(50);
		ticverte.setFitHeight(50);
		False.setFitWidth(50);
		False.setFitHeight(50);
		Echanger.setFitWidth(50);
		Echanger.setFitHeight(50);
		Tourner.setFitWidth(50);
		Tourner.setFitHeight(50);
		TroisDetectives.setFitWidth(50);
		TroisDetectives.setFitHeight(50);
		PileHautALibi.setFitWidth(60);
		PileHautALibi.setFitHeight(100);
		DeplacementWatson.setFitHeight(50);
		DeplacementWatson.setFitWidth(50);
		DeplacementTobi.setFitHeight(50);
		DeplacementTobi.setFitWidth(50);
		DeplacementSherlock.setFitHeight(50);
		DeplacementSherlock.setFitWidth(50);
		Tobi.setFitWidth(50);
		Tobi.setFitHeight(50);
		Sherlock.setFitWidth(50);
		Sherlock.setFitHeight(50);
		Watson.setFitWidth(50);
		Watson.setFitHeight(50);

		// Les jetons

		finDuTour.setContentDisplay(ContentDisplay.CENTER);
		root.add(finDuTour, 5, 6);
		finDuTour.setText("FIN");
		
		finDuTour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Jeu.finDuTour();
			}
		});
		
		ChoixTourner.setGraphic(Tourner);
		ChoixTourner.setShape(new Circle(30));
		ChoixTourner.setStyle("-fx-background-color: transparent;");
		ChoixTourner.setContentDisplay(ContentDisplay.CENTER);
		root.add(ChoixTourner, 6, 0);

		choixEchangerTuile.setGraphic(Echanger);
		choixEchangerTuile.setShape(new Circle(30));
		choixEchangerTuile.setStyle("-fx-background-color: transparent;");
		choixEchangerTuile.setContentDisplay(ContentDisplay.CENTER);
		root.add(choixEchangerTuile, 5, 0);

		// Création des Bouttons

		ArrayList<ImageView> tuiles2 = new ArrayList<ImageView>();
		for (int i = 0; i < 9; i++) {
			tuiles2.add(Jeu.board[i].sourceImage());
		}

		// création des tuiles

		for (int i = 0; i < 9; i++) {
			tuile[i] = new Button();
			tuile[i].setGraphic(tuiles2.get(i));
		}

		for (int i = 0; i < 9; i++) {
			tuile[i].setGraphic(tuiles2.get(i));
			tuile[i].setStyle("-fx-background-color: transparent;");
			tuile[i].setRotate((double) Jeu.board[i].getMur() * 90 + 180);
		}

		/*root.add(tuile[0], 1, 2);
		root.add(tuile[1], 2, 2);
		root.add(tuile[2], 3, 2);
		root.add(tuile[3], 1, 3);
		root.add(tuile[4], 2, 3);
		root.add(tuile[5], 3, 3);
		root.add(tuile[6], 1, 4);
		root.add(tuile[7], 2, 4);
		root.add(tuile[8], 3, 4);*/

		// Boutons détectives

		for (int i = 0; i < 12; i++) {
			D[i] = new Button();
			D[i].setMinWidth(50);
			D[i].setMinHeight(50);
			D[i].setShape(new Circle(30));
			D[i].setStyle("-fx-background-color: transparent;");
			D[i].setContentDisplay(ContentDisplay.CENTER);
			if (i == 3) {
				D[i].setGraphic(Watson);
			}
			if (i == 11) {
				D[i].setGraphic(Sherlock);
			}
			if (i == 7) {
				D[i].setGraphic(Tobi);
			}

		}
	
		/*root.add(D[0], 1, 1);
		root.add(D[1], 2, 1);
		root.add(D[2], 3, 1);
		root.add(D[3], 4, 2);
		root.add(D[4], 4, 3);
		root.add(D[5], 4, 4);
		root.add(D[6], 3, 5);
		root.add(D[7], 2, 5);
		root.add(D[8], 1, 5);
		root.add(D[9], 0, 4);
		root.add(D[10], 0, 3);
		root.add(D[11], 0, 2);*/

		// Bouton Tourner les tuiles

		ChoixTourner.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < 9; i++) {
					Node imTuile = tuile[i].getGraphic();
					tuile[i].setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							imTuile.setRotate(imTuile.getRotate() + 90);
						}
					});
				}
			}
		});

		// Echange de tuile a revoir problème avec j et i qui doivent être final

		choixEchangerTuile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < 9; i++) {
					Node imTuile1 = tuile[i].getGraphic();
					final int indice1 = i;
					tuile[i].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							for (int j = 0; j < 9; j++) {
								Node imTuile2 = tuile[j].getGraphic();
								final int indice2 = j;
								tuile[j].setOnAction(new EventHandler<ActionEvent>() {
									public void handle(ActionEvent e) {
										tuile[indice2].setGraphic(imTuile1);
										tuile[indice1].setGraphic(imTuile2);
									}
								});
							}
						}

					});

				}

			}
		});

		// Déplacement des détectives

		TroisD.setGraphic(TroisDetectives);
		TroisD.setContentDisplay(ContentDisplay.RIGHT);
		TroisD.setShape(new Circle(30));
		TroisD.setStyle("-fx-background-color: transparent;");
		//root.add(TroisD, 4, 0);

		DeplacementW.setGraphic(DeplacementWatson);
		DeplacementW.setContentDisplay(ContentDisplay.CENTER);
		DeplacementW.setShape(new Circle(30));
		DeplacementW.setStyle("-fx-background-color: transparent;");
		//root.add(DeplacementW, 3, 0);
		
		DeplacementS.setGraphic(DeplacementSherlock);
		DeplacementS.setContentDisplay(ContentDisplay.CENTER);
		DeplacementS.setShape(new Circle(30));
		DeplacementS.setStyle("-fx-background-color: transparent;");
		//root.add(DeplacementS, 2, 0);
		
		DeplacementT.setGraphic(DeplacementTobi);
		DeplacementT.setContentDisplay(ContentDisplay.RIGHT);
		DeplacementT.setShape(new Circle(30));
		DeplacementT.setStyle("-fx-background-color: transparent;");
		//root.add(DeplacementT, 1, 0);
		
		DeplacementW.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					final int indice = i;
					D[indice].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							D[indice + 1].setStyle("-fx-background-color: grey;");
							D[indice + 2].setStyle("-fx-background-color: grey;");
							D[indice + 1].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[indice].getGraphic();
									D[indice + 1].setGraphic(imD1);
									D[indice + 1].setStyle("-fx-background-color: transparent;");
									D[indice + 2].setStyle("-fx-background-color: transparent;");
								}
							});
							D[indice + 2].setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									Node imD1 = D[indice].getGraphic();
									D[indice + 2].setGraphic(imD1);
									D[indice + 1].setStyle("-fx-background-color: transparent;");
									D[indice + 2].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});
					D[10].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							D[indice + 1].setStyle("-fx-background-color: grey;");
							D[indice + 2].setStyle("-fx-background-color: grey;");
							D[11].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[10].getGraphic();
									D[11].setGraphic(imD1);
									D[11].setStyle("-fx-background-color: transparent;");
									D[0].setStyle("-fx-background-color: transparent;");
								}
							});
							D[0].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[10].getGraphic();
									D[0].setGraphic(imD1);
									D[11].setStyle("-fx-background-color: transparent;");
									D[0].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});
					D[11].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							D[0].setStyle("-fx-background-color: grey;");
							D[1].setStyle("-fx-background-color: grey;");
							D[0].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[11].getGraphic();
									D[0].setGraphic(imD1);
									D[0].setStyle("-fx-background-color: transparent;");
									D[1].setStyle("-fx-background-color: transparent;");
								}
							});
							D[1].setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									Node imD1 = D[11].getGraphic();
									D[1].setGraphic(imD1);
									D[0].setStyle("-fx-background-color: transparent;");
									D[1].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});

				}
			}
		});

		// Révélation alibi

		Alibi.setGraphic(PileHautALibi);
		Alibi.setContentDisplay(ContentDisplay.RIGHT);
		Alibi.setStyle("-fx-background-color: transparent;");
		
	
		Alibi2.setContentDisplay(ContentDisplay.RIGHT);
		Alibi2.setStyle("-fx-background-color: transparent;");
		//root.add(Alibi, 0, 7);
		//root.add(Alibi2, 1, 7);
		
		JetonAlibi pileAlibi = new JetonAlibi("alibi");

		Alibi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String[] carte = pileAlibi.piocherCarte();
				String sourceImage = pileAlibi.sourceImage(carte[0]);
				if (!sourceImage.equals("Lapileestvide-alibi.png")) { // a modifier pour éviter la syntaxe bizzare
					ImageView carteRetournee = new ImageView(getClass().getResource(sourceImage).toString());
					carteRetournee.setFitHeight(100);
					carteRetournee.setFitWidth(60);
					Alibi2.setGraphic(carteRetournee);
				} else {
					// Enlever image alibi
				}

			}
		});

		// innocent.setGraphic();
		innocent.setContentDisplay(ContentDisplay.RIGHT);
		innocent.setText("Innocent");
		//root.add(innocent, 6, 6);

		innocent.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < 9; i++) {
					final int indice = i;
					tuile[indice].setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							Node imTuile1 = tuile[indice].getGraphic();
							Double Rotation = imTuile1.getRotate();
							tuile[indice].setGraphic(Jeu.board[indice].sourceImageVerso());
							Jeu.board[indice].sourceImageVerso().setRotate(Rotation);
						}
					});
				}
			}
		});

		// Bouttons actions

		/*
		 * Button Valider = new Button (); Valider.setGraphic(ticverte);
		 * Valider.setStyle("-fx-background-color: transparent;");
		 * Valider.setContentDisplay(ContentDisplay.RIGHT);
		 * //Valider.setText("Valider     ");
		 * 
		 * Button Annuler = new Button (); Annuler.setGraphic(False);
		 * Annuler.setStyle("-fx-background-color: transparent;");
		 * Annuler.setContentDisplay(ContentDisplay.RIGHT);
		 * //Annuler.setText("Annuler     ");
		 */
	 
		        Jeu.initialisation();
		        Jeu.plateau.lancement();
		        for (int i = 1; i <= 8; i++) {
		            switch (i % 2) {
		                case 1:
		                    Jeu.tourImpairs();
		                    break;
		                case 0:
		                    Jeu.tourPairs();
		                    break;
		            }
		            Jeu.finDuTour();
		            Jeu.finPartie(i);
		        }
		    
		
		printBoardInterface();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void innocenter(String nomSuspect) {
		for (int i = 0; i < 9; i++) {
			if (Jeu.board[i].getNomSuspect().equals(nomSuspect)) {
				final int indice = i;
				Node imTuile1 = tuile[indice].getGraphic();
				Double Rotation = imTuile1.getRotate();
				tuile[indice].setGraphic(Jeu.board[indice].sourceImageVerso());
				Jeu.board[indice].sourceImageVerso().setRotate(Rotation);
			}
		}

	}

}