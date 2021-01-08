package InterfaceGraphique;

import java.util.ArrayList;
import Autres.Jeu;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le modifier
		
		
		VBox vertical1 = new VBox(); // met un espace entre les infos
		VBox vertical2 = new VBox();
		VBox vertical3 = new VBox();
		
		
		// ajouter une image
	
		ImageView JohnSmith = new ImageView(getClass().getResource("JohnSmith-recto.png").toString());
		ImageView JohnPizer = new ImageView(getClass().getResource("JohnPizer-recto.png").toString());
		ImageView JosephLane = new ImageView(getClass().getResource("JosephLane-recto.png").toString());
		ImageView Madame = new ImageView(getClass().getResource("Madame-rector.png").toString());
		ImageView SgtGoodley = new ImageView(getClass().getResource("SgtGoodley-recto.png").toString());
		ImageView InspLestrade = new ImageView(getClass().getResource("InspLestrade-recto.png").toString());
		ImageView MissStealthy = new ImageView(getClass().getResource("MissStealthy-recto.png").toString());
		ImageView WilliamGull = new ImageView(getClass().getResource("WilliamGull-recto.png").toString());
		ImageView JeremyBert = new ImageView(getClass().getResource("JeremyBert-recto.png").toString());
		
		JohnSmith.setFitHeight(100);
		JohnPizer.setFitHeight(100);
		JohnSmith.setFitWidth(100);
		JohnPizer.setFitWidth(100);
		JosephLane.setFitHeight(100);
		JosephLane.setFitWidth(100);
		SgtGoodley.setFitHeight(100);
		SgtGoodley.setFitWidth(100);
		InspLestrade.setFitHeight(100);
		InspLestrade.setFitWidth(100);
		MissStealthy.setFitHeight(100);
		MissStealthy.setFitWidth(100);
		WilliamGull.setFitHeight(100);
		WilliamGull.setFitWidth(100);
		Madame.setFitHeight(100);
		Madame.setFitWidth(100);
		JeremyBert.setFitHeight(100);
		JeremyBert.setFitWidth(100);
		
		
		vertical1.setPadding(new Insets(0)); // met des espacement partout
		vertical1.setAlignment(Pos.CENTER); //(centre tout)
		vertical2.setPadding(new Insets(0)); // met des espacement partout
		vertical2.setAlignment(Pos.CENTER); //(centre tout)
		
		

		Button tournertuile1 = new Button ();
		tournertuile1.setGraphic(JohnSmith);
		tournertuile1.setContentDisplay(ContentDisplay.RIGHT );
		
		Button tournertuile2 = new Button ();
		tournertuile2.setGraphic(JohnPizer);
		tournertuile2.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile3 = new Button ();
		tournertuile3.setGraphic(JosephLane);
		tournertuile3.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile4 = new Button ();
		tournertuile4.setGraphic(Madame);
		tournertuile4.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile5 = new Button ();
		tournertuile5.setGraphic(SgtGoodley);
		tournertuile5.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile6 = new Button ();
		tournertuile6.setGraphic(InspLestrade);
		tournertuile6.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile7 = new Button ();
		tournertuile7.setGraphic(MissStealthy);
		tournertuile7.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile8 = new Button ();
		tournertuile8.setGraphic(WilliamGull);
		tournertuile8.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tournertuile9 = new Button ();
		tournertuile9.setGraphic(JeremyBert);
		tournertuile9.setContentDisplay(ContentDisplay.RIGHT);
		
		

		
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

		// Cr�ation des Bouttons

		ArrayList<ImageView> tuiles2 = new ArrayList<ImageView>();
		for (int i = 0; i < 9; i++) {
			tuiles2.add(Jeu.board[i].sourceImage());
		}

		// cr�ation des tuiles

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

		// Boutons d�tectives

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

		// Echange de tuile a revoir probl�me avec j et i qui doivent �tre final

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

		// D�placement des d�tectives

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

		// R�v�lation alibi

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
				if (!sourceImage.equals("Lapileestvide-alibi.png")) { // a modifier pour �viter la syntaxe bizzare
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
