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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le
																// modifier

		GridPane root = new GridPane();

		// ajouter une image

		ImageView ticverte = new ImageView(getClass().getResource("ticverte.png").toString());
		ImageView False = new ImageView(getClass().getResource("False.png").toString());
		ImageView Echanger = new ImageView(getClass().getResource("Jeton1-Face1.png").toString());
		ImageView Tourner = new ImageView(getClass().getResource("Jeton1-Face2.png").toString());
		ImageView DeplacementWatson = new ImageView(getClass().getResource("Jeton2-Face2.png").toString());
		ImageView DeplacementSherlock = new ImageView(getClass().getResource("Jeton3-Face1.png").toString());
		ImageView DeplacementTobi = new ImageView(getClass().getResource("Jeton2-Face1.png").toString());
		ImageView Verso1 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso2 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso3 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso4 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso5 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso6 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso7 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso8 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView Verso9 = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView JosephLaneVerso = new ImageView(getClass().getResource("JosephLane-verso.png").toString());
		ImageView Watson = new ImageView(getClass().getResource("Watson.png").toString());
		ImageView Tobi = new ImageView(getClass().getResource("Tobi.png").toString());
		ImageView Sherlock = new ImageView(getClass().getResource("Sherlock.png").toString());
		ImageView TroisDetectives = new ImageView(getClass().getResource("Jeton4-Face1.png").toString());
		ImageView PileHautALibi = new ImageView(getClass().getResource("alibi-card.png").toString());
		/*
		 * ImageView AlibiInspLestrade = new
		 * ImageView(getClass().getResource("InspLestrade-alibi.png").toString());
		 * ImageView AlibiJeremyBert = new
		 * ImageView(getClass().getResource("JeremyBert-alibi.png").toString());
		 * ImageView AlibiJohnPizer = new
		 * ImageView(getClass().getResource("JohnPizer-alibi.png").toString());
		 * ImageView AlibiJohnSmith = new
		 * ImageView(getClass().getResource("JohnSmith-alibi.png").toString());
		 * ImageView AlibiJosephLane = new
		 * ImageView(getClass().getResource("JosephLane-alibi.png").toString());
		 * ImageView AlibiMadame = new
		 * ImageView(getClass().getResource("Madame-alibi.png").toString()); ImageView
		 * AlibiMissStealthy = new
		 * ImageView(getClass().getResource("MissStealthy-alibi.png").toString());
		 * ImageView AlibiSgtGoodley = new
		 * ImageView(getClass().getResource("SgtGoodley-alibi.png").toString());
		 * ImageView AlibiWilliamGull= new
		 * ImageView(getClass().getResource("WilliamGull-alibi.png").toString());
		 */

		// ImageView fond = new
		// ImageView(getClass().getResource("fond.jpg").toString());

		PileHautALibi.setFitHeight(100);
		ticverte.setFitWidth(50);
		ticverte.setFitHeight(50);
		False.setFitWidth(50);
		False.setFitHeight(50);
		Echanger.setFitWidth(50);
		Echanger.setFitHeight(50);
		Tourner.setFitWidth(50);
		Tourner.setFitHeight(50);
		Verso1.setFitWidth(100);
		Verso1.setFitHeight(100);
		Verso2.setFitWidth(100);
		Verso2.setFitHeight(100);
		Verso3.setFitWidth(100);
		Verso3.setFitHeight(100);
		Verso4.setFitWidth(100);
		Verso4.setFitHeight(100);
		Verso5.setFitWidth(100);
		Verso5.setFitHeight(100);
		Verso6.setFitWidth(100);
		Verso6.setFitHeight(100);
		Verso7.setFitWidth(100);
		Verso7.setFitHeight(100);
		Verso8.setFitWidth(100);
		Verso8.setFitHeight(100);
		Verso9.setFitWidth(100);
		Verso9.setFitHeight(100);
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
		JosephLaneVerso.setFitWidth(100);
		JosephLaneVerso.setFitHeight(100);
		Tobi.setFitWidth(50);
		Tobi.setFitHeight(50);
		Sherlock.setFitWidth(50);
		Sherlock.setFitHeight(50);
		Watson.setFitWidth(50);
		Watson.setFitHeight(50);

		// Les jetons

		Button ChoixTourner = new Button();
		ChoixTourner.setGraphic(Tourner);
		ChoixTourner.setShape(new Circle(30));
		ChoixTourner.setStyle("-fx-background-color: transparent;");
		ChoixTourner.setContentDisplay(ContentDisplay.CENTER);*/
		root.add(JetonTourner.ChoixTourner, 6, 0);

		Button choixEchangerTuile = new Button();
		choixEchangerTuile.setGraphic(Echanger);
		choixEchangerTuile.setShape(new Circle(30));
		choixEchangerTuile.setStyle("-fx-background-color: transparent;");
		choixEchangerTuile.setContentDisplay(ContentDisplay.CENTER);
		root.add(choixEchangerTuile, 5, 0);

		// Création des Bouttons

		ArrayList<ImageView> tuiles2 = new ArrayList<ImageView>();
		for (int i = 0; i < 9; i++) {
			tuiles2.add(Jeu.board[(int) Math.round(i / 3)][(int) Math.round(i % 3)].sourceImage());
		}

		// création des tuiles

		Button[] tuile = new Button[9];
		for (int i = 0; i < 9; i++) {
			tuile[i] = new Button();
			tuile[i].setGraphic(tuiles2.get(i));
		}

		for (int i = 0; i < 9; i++) {
			tuile[i].setGraphic(tuiles2.get(i));
			tuile[i].setStyle("-fx-background-color: transparent;");
			tuile[i].setRotate((double) Jeu.board[(int) Math.round(i / 3)][(int) Math.round(i % 3)].getMur() * 90);
		}

		root.add(tuile[0], 1, 2);
		root.add(tuile[1], 1, 3);
		root.add(tuile[2], 1, 4);
		root.add(tuile[3], 2, 2);
		root.add(tuile[4], 2, 3);
		root.add(tuile[5], 2, 4);
		root.add(tuile[6], 3, 2);
		root.add(tuile[7], 3, 3);
		root.add(tuile[8], 3, 4);

		// Boutons détectives

		Button[] D = new Button[12];
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

		Button TroisD = new Button();
		TroisD.setGraphic(TroisDetectives);
		TroisD.setContentDisplay(ContentDisplay.RIGHT);
		TroisD.setShape(new Circle(30));
		TroisD.setStyle("-fx-background-color: transparent;");
		root.add(TroisD, 4, 0);

		Button DeplacementW = new Button();
		DeplacementW.setGraphic(DeplacementWatson);
		DeplacementW.setContentDisplay(ContentDisplay.CENTER);
		DeplacementW.setShape(new Circle(30));
		DeplacementW.setStyle("-fx-background-color: transparent;");
		root.add(DeplacementW, 3, 0);

		Button DeplacementS = new Button();
		DeplacementS.setGraphic(DeplacementSherlock);
		DeplacementS.setContentDisplay(ContentDisplay.CENTER);
		DeplacementS.setShape(new Circle(30));
		DeplacementS.setStyle("-fx-background-color: transparent;");
		root.add(DeplacementS, 2, 0);

		Button DeplacementT = new Button();
		DeplacementT.setGraphic(DeplacementTobi);
		DeplacementT.setContentDisplay(ContentDisplay.RIGHT);
		DeplacementT.setShape(new Circle(30));
		DeplacementT.setStyle("-fx-background-color: transparent;");
		root.add(DeplacementT, 1, 0);

		
		int placement = Jeu.listeDetectives[2].getPlace();
		
		DeplacementW.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < 12; i++) {
					final int indice = i;
					D[indice].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							D[indice +1].setStyle("-fx-background-color: grey;");
							D[indice +2].setStyle("-fx-background-color: grey;");
							D[indice + 1].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[indice].getGraphic();
									D[indice + 1].setGraphic(imD1);
									D[indice +1].setStyle("-fx-background-color: transparent;");
									D[indice +2].setStyle("-fx-background-color: transparent;");
								}
							});
							D[indice + 2].setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									Node imD1 = D[indice].getGraphic();
									D[indice + 2].setGraphic(imD1);
									D[indice +1].setStyle("-fx-background-color: transparent;");
									D[indice +2].setStyle("-fx-background-color: transparent;");
								}
							});
						}
					});
					D[10].setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							D[indice +1].setStyle("-fx-background-color: grey;");
							D[indice +2].setStyle("-fx-background-color: grey;");
							D[11].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[10].getGraphic();
									D[11].setGraphic(imD1);
								}
							});
							D[0].setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									Node imD1 = D[10].getGraphic();
									D[0].setGraphic(imD1);
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
								}
							});
						}
					});
					
				}
			}
		});

		// Révélation alibi

		Button Alibi = new Button();
		Alibi.setGraphic(PileHautALibi);
		Alibi.setContentDisplay(ContentDisplay.RIGHT);
		Alibi.setStyle("-fx-background-color: transparent;");
		root.add(Alibi, 0, 7);

		Button Alibi2 = new Button();
		Alibi2.setContentDisplay(ContentDisplay.RIGHT);
		Alibi2.setStyle("-fx-background-color: transparent;");
		root.add(Alibi2, 1, 7);

		JetonAlibi pileAlibi = new JetonAlibi("alibi");

		Alibi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String[] carte = pileAlibi.piocherCarte();
				String sourceImage = pileAlibi.sourceImage(carte[0]);
				if (!sourceImage.equals("Lapileestvid-alibi.png")) { // a modifier pour éviter la syntaxe bizzare
					ImageView carteRetournee = new ImageView(getClass().getResource(sourceImage).toString());
					carteRetournee.setFitHeight(100);
					carteRetournee.setFitWidth(60);
					Alibi2.setGraphic(carteRetournee);
				} else {
					// Enlever image alibi
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

		/*
		 * Button innocent = new Button(); //innocent.setGraphic();
		 * innocent.setContentDisplay(ContentDisplay.RIGHT);
		 * innocent.setText("Innocent");
		 
		 * 
		 * 
		 * 
		 * // Création d'un évenement
		 * 
		 * //EventHandler AppuyerValider = new EventHandler (<ActionEvent>() { //public
		 * void handle(ActionEvent event) { //System.out.println("Handling event "+
		 * event.getEventType()); //event.consume(); //} //};
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // Retourner une carte passage quartier à ville
		 * 
		 * innocent.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { tuile1.setOnAction(new
		 * EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile1 =
		 * tuile1.getGraphic(); Double Rotation = imTuile1.getRotate(); if (imTuile1 ==
		 * JosephLane) { tuile1.setGraphic(JosephLaneVerso); } else {
		 * tuile1.setGraphic(Verso1); Verso1.setRotate(Rotation);} } });
		 * tuile2.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile2 =
		 * tuile2.getGraphic(); Double Rotation = imTuile2.getRotate(); if (imTuile2 ==
		 * JosephLane) { tuile2.setGraphic(JosephLaneVerso); } else {
		 * tuile2.setGraphic(Verso2); Verso2.setRotate(Rotation);} } });
		 * tuile3.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile3=
		 * tuile3.getGraphic(); Double Rotation = imTuile3.getRotate(); if (imTuile3 ==
		 * JosephLane) { tuile3.setGraphic(JosephLaneVerso); } else {
		 * tuile3.setGraphic(Verso3); Verso3.setRotate(Rotation);} } });
		 * tuile4.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile4 =
		 * tuile4.getGraphic(); Double Rotation = imTuile4.getRotate(); if (imTuile4 ==
		 * JosephLane) { tuile4.setGraphic(JosephLaneVerso); } else {
		 * tuile4.setGraphic(Verso4); Verso4.setRotate(Rotation);} } });
		 * tuile5.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile5 =
		 * tuile5.getGraphic(); Double Rotation = imTuile5.getRotate(); if (imTuile5 ==
		 * JosephLane) { tuile5.setGraphic(JosephLaneVerso); } else {
		 * tuile5.setGraphic(Verso5); Verso5.setRotate(Rotation);} } });
		 * tuile6.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile6 =
		 * tuile6.getGraphic(); Double Rotation = imTuile6.getRotate(); if (imTuile6 ==
		 * JosephLane) { tuile6.setGraphic(JosephLaneVerso); } else {
		 * tuile6.setGraphic(Verso6); Verso6.setRotate(Rotation);} } });
		 * tuile7.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile7 =
		 * tuile7.getGraphic(); Double Rotation = imTuile7.getRotate(); if (imTuile7 ==
		 * JosephLane) { tuile7.setGraphic(JosephLaneVerso); } else {
		 * tuile7.setGraphic(Verso7); Verso7.setRotate(Rotation);} } });
		 * tuile8.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile8 =
		 * tuile8.getGraphic(); Double Rotation = imTuile8.getRotate(); if (imTuile8 ==
		 * JosephLane) { tuile8.setGraphic(JosephLaneVerso); } else {
		 * tuile8.setGraphic(Verso8); Verso8.setRotate(Rotation);} } });
		 * tuile9.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { Node imTuile9 =
		 * tuile9.getGraphic(); Double Rotation = imTuile9.getRotate(); if (imTuile9 ==
		 * JosephLane) { tuile9.setGraphic(JosephLaneVerso); } else {
		 * tuile9.setGraphic(Verso9); Verso9.setRotate(Rotation);} } });
		 * 
		 * } });
		 * 
		 * 
		 */
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}