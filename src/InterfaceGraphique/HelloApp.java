package InterfaceGraphique;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;


import jetons.JetonAlibi;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;


public class HelloApp extends Application {

	public static void main(String[] args) {
		//Jeu.main(args);
		launch(args);
	}

	static GridPane root = new GridPane();
	static GridPane root2 = new GridPane();

	public static void printBoardInterface() {
		root.add(tuile[0], 2, 3);
		root.add(tuile[1], 3, 3);
		root.add(tuile[2], 4, 3);
		root.add(tuile[3], 2, 4);
		root.add(tuile[4], 3, 4);
		root.add(tuile[5], 4, 4);
		root.add(tuile[6], 2, 5);
		root.add(tuile[7], 3, 5);
		root.add(tuile[8], 4, 5);
		root.add(d[0], 2, 2);
		root.add(d[1], 3, 2);
		root.add(d[2], 4, 2);
		root.add(d[3], 5, 3);
		root.add(d[4], 5, 4);
		root.add(d[5], 5, 5);
		root.add(d[6], 4, 6);
		root.add(d[7], 3, 6);
		root.add(d[8], 2, 6);
		root.add(d[9], 1, 5);
		root.add(d[10], 1, 4);
		root.add(d[11], 1, 3);
		for (int i = 12; i<24; i++) {		
			if (i<15) {
				root.add(d[i], i -10, 1);
			}
			else if(i<18) {
				root.add(d[i], 6, i-12);
			}
			else if (i<21) {
				root.add(d[i], 22-i, 7);
			}
			else if (i<24) {
				root.add(d[i], 0, 26-i);
			}
		}		
		root.add(alibi2, 1, 7);
		root.add(alibi, 0, 7);
		root.add(deplacementT, 1, 0);
		root.add(deplacementS, 2, 0);
		root.add(deplacementW, 3, 0);
		root.add(troisD, 4, 0);
	}
	ImageView ticverteView = new ImageView(getClass().getResource("ticverte.png").toString());
	ImageView faux = new ImageView(getClass().getResource("False.png").toString());
	ImageView echanger = new ImageView(getClass().getResource("Jeton1-Face1.png").toString());
	ImageView tourner = new ImageView(getClass().getResource("Jeton1-Face2.png").toString());
	ImageView deplacementWatson = new ImageView(getClass().getResource("Jeton2-Face2.png").toString());
	ImageView deplacementSherlock = new ImageView(getClass().getResource("Jeton3-Face1.png").toString());
	ImageView deplacementToby = new ImageView(getClass().getResource("Jeton2-Face1.png").toString());
	ImageView watson = new ImageView(getClass().getResource("Watson.png").toString());
	ImageView toby = new ImageView(getClass().getResource("Tobi.png").toString());
	ImageView sherlock = new ImageView(getClass().getResource("Sherlock.png").toString());
	ImageView troisDetectives = new ImageView(getClass().getResource("Jeton4-Face1.png").toString());
	ImageView pileHautAlibi = new ImageView(getClass().getResource("alibi-card.png").toString());

	Button choixTourner = new Button();
	Button choixEchangerTuile = new Button();
	static Button[] d = new Button[24];
	static Button troisD = new Button();
	static Button deplacementW = new Button();
	static Button deplacementS = new Button();
	static Button deplacementT = new Button();
	static Button alibi = new Button();
	static Button alibi2 = new Button();
	Button innocent = new Button();
	static Button[] tuile = new Button[9];
	Button finDuTour = new Button();

	@Override
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le modifier
		
		
		VBox vertical1 = new VBox(); // met un espace entre les infos
		VBox vertical2 = new VBox();
		VBox vertical3 = new VBox();
		
		// ajouter une image
		/*ImageView johnSmith = new ImageView(getClass().getResource("JohnSmith-recto.png").toString());
		ImageView johnPizer = new ImageView(getClass().getResource("JohnPizer-recto.png").toString());
		ImageView josephLane = new ImageView(getClass().getResource("JosephLane-recto.png").toString());
		ImageView madame = new ImageView(getClass().getResource("Madame-recto.png").toString());
		ImageView sgtGoodley = new ImageView(getClass().getResource("SgtGoodley-recto.png").toString());
		ImageView inspLestrade = new ImageView(getClass().getResource("InspLestrade-recto.png").toString());
		ImageView missStealthy = new ImageView(getClass().getResource("MissStealthy-recto.png").toString());
		ImageView williamGull = new ImageView(getClass().getResource("WilliamGull-recto.png").toString());
		ImageView jeremyBert = new ImageView(getClass().getResource("JeremyBert-recto.png").toString());
		
		
		ImageVie
		johnSmith.setFitHeight(100);
		johnPizer.setFitHeight(100);
		johnSmith.setFitWidth(100);
		johnPizer.setFitWidth(100);
		josephLane.setFitHeight(100);
		josephLane.setFitWidth(100);
		sgtGoodley.setFitHeight(100);
		sgtGoodley.setFitWidth(100);
		inspLestrade.setFitHeight(100);
		inspLestrade.setFitWidth(100);
		MissStealthy.setFitHeight(100);
		MissStealthy.setFitWidth(100);
		WilliamGull.setFitHeight(100);
		WilliamGull.setFitWidth(100);
		Madame.setFitHeight(100);
		Madame.setFitWidth(100);
		JeremyBert.setFitHeight(100);
		JeremyBert.setFitWidth(100);*/
		
		ImageView[] listeBouttons = new ImageView[]{faux, echanger, tourner, troisDetectives, toby, sherlock, watson, deplacementSherlock, deplacementWatson, deplacementToby};
		
		for (ImageView i : listeBouttons) {
			i.setFitWidth(50);
			i.setFitHeight(50);
		}
		pileHautAlibi.setFitWidth(60);
		pileHautAlibi.setFitHeight(100);

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
		
		choixTourner.setGraphic(tourner);
		choixTourner.setShape(new Circle(30));
		choixTourner.setStyle("-fx-background-color: transparent;");
		choixTourner.setContentDisplay(ContentDisplay.CENTER);
		root.add(choixTourner, 6, 0);

		choixEchangerTuile.setGraphic(echanger);
		choixEchangerTuile.setShape(new Circle(30));
		choixEchangerTuile.setStyle("-fx-background-color: transparent;");
		choixEchangerTuile.setContentDisplay(ContentDisplay.CENTER);
		root.add(choixEchangerTuile, 5, 0);

		// Creation des Bouttons

		ArrayList<ImageView> tuiles2 = new ArrayList<ImageView>();
		for (int i = 0; i < 9; i++) {
			tuiles2.add(Jeu.board[i].sourceImage());
		}

		// creation des tuiles

		for (int i = 0; i < 9; i++) {
			tuile[i] = new Button();
			tuile[i].setGraphic(tuiles2.get(i));
		}

		for (int i = 0; i < 9; i++) {
			tuile[i].setGraphic(tuiles2.get(i));
			tuile[i].setStyle("-fx-background-color: transparent;");
			tuile[i].setRotate((double) Jeu.board[i].getMur() * 90 + 180);
		}

		// Boutons d�tectives

		for (int i = 0; i < 24; i++) {
			d[i] = new Button();
			d[i].setMinWidth(50);
			d[i].setMinHeight(50);
			d[i].setShape(new Circle(30));
			d[i].setStyle("-fx-background-color: transparent;");
			d[i].setContentDisplay(ContentDisplay.CENTER);
			if (i == 3) {
				d[i].setGraphic(watson);
			}
			if (i == 11) {
				d[i].setGraphic(sherlock);
			}
			if (i == 7) {
				d[i].setGraphic(toby);
			}
		}
	
		// Bouton Tourner les tuiles
		choixTourner.setOnAction(new EventHandler<ActionEvent>() {
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

		// Echange de tuile a revoir probleme avec j et i qui doivent etre final
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

		// Deplacement des detectives
		Button[] listPionDetectives = new Button[] {troisD, deplacementW, deplacementS, deplacementT};
		troisD.setGraphic(troisDetectives);
		deplacementW.setGraphic(deplacementWatson);
		deplacementS.setGraphic(deplacementSherlock);
		deplacementT.setGraphic(deplacementToby);
		
		for (Button i : listPionDetectives) {
			i.setContentDisplay(ContentDisplay.CENTER);
			i.setShape(new Circle(30));
			i.setStyle("-fx-background-color: transparent;");
		}

		deplacementW.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					final int indice = i;
					d[indice].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							d[indice + 1].setStyle("-fx-background-color: grey;");
							d[indice + 2].setStyle("-fx-background-color: grey;");
							d[indice + 1].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = d[indice].getGraphic();
									d[indice + 1].setGraphic(imD1);
									d[indice + 1].setStyle("-fx-background-color: transparent;");
									d[indice + 2].setStyle("-fx-background-color: transparent;");
								}
							});
							d[indice + 2].setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									Node imD1 = d[indice].getGraphic();
									d[indice + 2].setGraphic(imD1);
									d[indice + 1].setStyle("-fx-background-color: transparent;");
									d[indice + 2].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});
					d[10].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							d[indice + 1].setStyle("-fx-background-color: grey;");
							d[indice + 2].setStyle("-fx-background-color: grey;");
							d[11].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = d[10].getGraphic();
									d[11].setGraphic(imD1);
									d[11].setStyle("-fx-background-color: transparent;");
									d[0].setStyle("-fx-background-color: transparent;");
								}
							});
							d[0].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = d[10].getGraphic();
									d[0].setGraphic(imD1);
									d[11].setStyle("-fx-background-color: transparent;");
									d[0].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});
					d[11].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							d[0].setStyle("-fx-background-color: grey;");
							d[1].setStyle("-fx-background-color: grey;");
							d[0].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = d[11].getGraphic();
									d[0].setGraphic(imD1);
									d[0].setStyle("-fx-background-color: transparent;");
									d[1].setStyle("-fx-background-color: transparent;");
								}
							});
							d[1].setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									Node imD1 = d[11].getGraphic();
									d[1].setGraphic(imD1);
									d[0].setStyle("-fx-background-color: transparent;");
									d[1].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});

				}
			}
		});

		// Revelation alibi

		alibi.setGraphic(pileHautAlibi);
		alibi.setContentDisplay(ContentDisplay.RIGHT);
		alibi.setStyle("-fx-background-color: transparent;");
		
	
		alibi2.setContentDisplay(ContentDisplay.RIGHT);
		alibi2.setStyle("-fx-background-color: transparent;");
		//root.add(Alibi, 0, 7);
		//root.add(Alibi2, 1, 7);
		
		JetonAlibi pileAlibi = new JetonAlibi("alibi");

		alibi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String[] carte = pileAlibi.piocherCarte();
				String sourceImage = pileAlibi.sourceImage(carte[0]);
				if (!sourceImage.equals("Lapileestvide-alibi.png")) { // a modifier pour eviter la syntaxe bizare
					ImageView carteRetournee = new ImageView(getClass().getResource(sourceImage).toString());
					carteRetournee.setFitHeight(100);
					carteRetournee.setFitWidth(60);
					alibi2.setGraphic(carteRetournee);
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
	 
		printBoardInterface();
		Scene scene = new Scene(root);
		Scene scene2 = new Scene(root2);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage otherStage = new Stage();
		otherStage.setScene(scene2);
		//otherStage.show();
		
		
		
		        /*Jeu.initialisation();
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
		        }*/
		
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