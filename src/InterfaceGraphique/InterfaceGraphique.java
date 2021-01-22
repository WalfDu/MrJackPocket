package InterfaceGraphique;

import java.util.ArrayList;
import java.util.List;

import Autres.District;
import Autres.Jeu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jetons.JetonAlibi;
import jetons.Jetons;
import tour.TourImpairs;
import tour.TourPairs;

public class InterfaceGraphique extends Application {

	public static GridPane root = new GridPane();

	Image echanger = new Image("file:images/actions/Jeton1-Face1.png", 50, 50, false, false);
	ImageView echangerView = new ImageView(echanger);
	Image tourner = new Image("file:images/actions/Jeton1-Face2.png", 50, 50, false, false);
	ImageView tournerView = new ImageView(tourner);
	Image deplacementWatson = new Image("file:images/actions/Jeton2-Face2.png", 50, 50, false, false);
	ImageView deplacementWatsonView = new ImageView(deplacementWatson);
	Image deplacementSherlock = new Image("file:images/actions/Jeton3-Face1.png", 50, 50, false, false);
	ImageView deplacementSherlockView = new ImageView(deplacementSherlock);
	Image deplacementToby = new Image("file:images/actions/Jeton2-Face1.png", 50, 50, false, false);
	ImageView deplacementTobyView = new ImageView(deplacementToby);
	Image actionAlibi = new Image("file:images/actions/Jeton3-Face2.png", 50, 50, false, false);
	ImageView actionAlibiView = new ImageView(actionAlibi);
	Image troisDetectives = new Image("file:images/actions/Jeton4-Face1.png", 50, 50, false, false);
	ImageView troisDetectivesView = new ImageView(troisDetectives);
	static Image toby = new Image("file:images/detectives/Toby.png", 50, 50, false, false);
	public static ImageView tobyView = new ImageView(toby);
	static Image sherlock = new Image("file:images/detectives/Sherlock.png", 50, 50, false, false);
	public static ImageView sherlockView = new ImageView(sherlock);
	static Image watson = new Image("file:images/detectives/Watson.png", 50, 50, false, false);
	public static ImageView watsonView = new ImageView(watson);
	Image pileHautAlibi = new Image("file:images/alibis/alibi-card.png", 60, 100, false, false);
	ImageView pileHautAlibiView = new ImageView(pileHautAlibi);
	static Image mrJack = new Image(JetonAlibi.sourceImage(Jeu.nomMrJack[0]), 60, 100, false, false);
	static ImageView mrJackView = new ImageView(mrJack);
	public static Image alibi2 = new Image("file:images/Annuler.png", 60, 100, false, false);
	public static ImageView alibi2View = new ImageView(alibi2);
	static Image valider = new Image("file:images/Valider.png", 50, 50, false, false);
	static ImageView validerView = new ImageView(valider);
	static Image sablier = new Image("file:images/sablier.png", 30, 30, false, false);
	public static ImageView sablierView = new ImageView(sablier);

	public static Button choixTourner = new Button();
	public static Button choixEchangerTuile = new Button();
	public static Button[] d = new Button[24];
	public static Button troisD = new Button();
	public static Button deplacementW = new Button();
	public static Button deplacementS = new Button();
	public static Button deplacementT = new Button();
	public static Button alibi = new Button();
	// public static Button alibi2 = new Button();
	Button innocent = new Button();
	public static Button[] tuile = new Button[9];
	public static Button finDuTour = new Button();
	public static Button[] action = new Button[4];
	Button commencer = new Button();
	static Button joueurSuivant = new Button();
	public static Button validerB = new Button();
	static String nomMrJack = "";
	final static Text vousEtes = new Text("Vous etes:" + nomMrJack);
	public final static Text nbSabliers = new Text("Vous avez:" + Jeu.sabliers);
	public final static Text nbTours = new Text();

	//Cette colonne et ligne permettent de centrer le message du changement de jouueur
	static ColumnConstraints column = new ColumnConstraints();
	static RowConstraints row = new RowConstraints();

	public static void main(String[] args) {		// fonction qui permet de lancer le jeu et d'initialiser tous les
													// paramètres pour le début de la partie
		for (String i : Jeu.nomMrJack[0].split(" ")) {
			nomMrJack += "\n" + i; 					//Cela sert à avoir le nom de Mr. Jack sur deux lignes en bas à droite
		}
		launch(args);
	}

	
	//printBoardInterface() permet d'afficher le plateau de jeu
	public static void printBoardInterface() {
		
		root.getChildren().clear();
		root.getRowConstraints().remove(row);
		root.getColumnConstraints().remove(column);
		nbSabliers.setText("Mr. Jack a:\n" + (int) (Jeu.sabliers));
		nbTours.setText("Vous etes au tour "  + Jeu.tourEnCours + ".");
		root.add(sablierView, 5, 7);
		nbSabliers.setStyle("-fx-text-inner-color: red;");
		for (int i = 0; i < 9; i++) {
			tuile[i].setRotate((double) Jeu.board[i].getMur() * 90 + 180);
			root.add(tuile[i], 2 + i % 3, 3 + i / 3);
		}
		
		// Ajout des boutons des detectives sur les lignes et les colonnes autour du
		// plateau de tuile
		for (int i = 0; i < 24; i++) {
			if (i < 3) {
				root.add(d[i], i + 2, 2);	// ajout d'une première ligne de bouton autour du plateau
			} else if (i < 6) {
				root.add(d[i], 5, i);		// ajout d'une colonne de bouton autour du plateau
			} else if (i < 9) {
				root.add(d[i], 10 - i, 6);
			} else if (i < 12) {
				root.add(d[i], 1, 14 - i);
			} else if (i < 15) {				// On ajoute d'une deuxième rangée de bouton pour satisfaire le cas où 2
				root.add(d[i], i - 10, 1);		// detectives seraient présents sur la même case
			} else if (i < 18) {
				root.add(d[i], 6, i - 12);
			} else if (i < 21) {
				root.add(d[i], 22 - i, 7);
			} else if (i < 24) {
				root.add(d[i], 0, 26 - i);
			}
		}
		root.add(alibi, 0, 7);
		root.add(alibi2View, 1, 7);
		root.add(nbTours, 6, 1);
		// Si le joueur actuel est Mr. Jack, on affiche qui il est et son nombre de
		// sablier
		if (Jeu.jActuel == 1) {
			nbSabliers.setText("Vous avez:\n" + (int) (Jeu.sabliers + Jeu.sabliersCaches));
			root.add(vousEtes, 6, 6);
			root.add(mrJackView, 6, 7);
		}
		root.add(nbSabliers, 5, 6);
		for (int nbActions = 0; nbActions < 4; nbActions++) {
			root.add(action[nbActions], nbActions + 2, 0);
			InterfaceGraphique.action[nbActions].setGraphic((Jeu.choixActions[nbActions]).getImView());
			final int i = nbActions;
			action[nbActions].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Jeu.actionsFaites.addLast(Jeu.choixActions[i]);
					Jeu.actionEnCours = Jeu.choixActions[i];
					action[i].setDisable(true);
					Jeu.choixActions[i].action(Jeu.listeDetectives, Jeu.board, Jeu.jActuel);
					}
				});
			}
		}

	public static void joueurSuivant() {
		root.getChildren().clear();
		root.getColumnConstraints().add(column);
		root.getRowConstraints().add(row);
		root.add(joueurSuivant, 5, 0);
	}

	public static void finAction() {
		Jeu.finPartie(Jeu.tourEnCours);
		if (Jeu.actionsFaites.size() > 3) {
			for (Button i : action) {
				i.setDisable(false);
			}
			Jeu.finDuTour();
			Jeu.tourEnCours++;
			if (Jeu.tourEnCours % 2 == 0) {
				Jeu.choixActions = TourPairs.debut(Jeu.choixActions);
			} else {
				Jeu.choixActions = TourImpairs.debut();
			}
			Jeu.actionsFaites.clear();
		}
		if (Jeu.actionsFaites.size() != 2) {
			Jeu.jActuel = (++Jeu.jActuel % 2);
			joueurSuivant.setText("C'est à " + Jeu.joueurActuel[Jeu.jActuel]
					+ " de jouer.\nSi vous etes pret, cliquez sur ce message");
			joueurSuivant();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le
																// modifier
		column.setPercentWidth(32);
		row.setPercentHeight(90);
		root.getColumnConstraints().add(column);
		root.getRowConstraints().add(row);

		// Les jetons
		finDuTour.setText("FIN");
		finDuTour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Jeu.finDuTour();
			}
		});

		validerB.setGraphic(validerView);
		validerB.setStyle("-fx-background-color: transparent;");
		// root.add(validerB, 10, 11);

		commencer.setText("Commencer\nla partie");
		commencer.setMinWidth(75);
		commencer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Jeu.jActuel == -1) {
					for (Button i : action) {
						i.setDisable(false);
					}
					root.getChildren().remove(commencer);
				}
				finAction();
			}
		});

		joueurSuivant.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				printBoardInterface();
			}
		});

		// creation des tuiles
		for (int i = 0; i < 9; i++) {
			tuile[i] = new Button();
			tuile[i].setGraphic(Jeu.board[i].sourceImage());
			tuile[i].setStyle("-fx-background-color: transparent;");
			tuile[i].setRotate((double) Jeu.board[i].getMur() * 90 + 180);
		}

		// Boutons detectives
		for (int i = 0; i < 24; i++) {
			d[i] = new Button();
			d[i].setMinWidth(50);
			d[i].setMinHeight(50);
			d[i].setShape(new Circle(30));
			d[i].setStyle("-fx-background-color: transparent;");
			// d[i].setContentDisplay(ContentDisplay.CENTER);
			if (i == 3) {
				d[i].setGraphic(watsonView);
			}
			if (i == 23) {
				d[i].setGraphic(sherlockView);
			}
			if (i == 7) {
				d[i].setGraphic(tobyView);
			}
		}

		// Boutons des actions proposées
		for (int i = 0; i < 4; i++) {
			action[i] = new Button();
			action[i].setMinWidth(50);
			action[i].setMinHeight(50);
			action[i].setShape(new Circle(30));
			action[i].setStyle("-fx-background-color: transparent;");
			action[i].setDisable(true);
		}

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
		Button[] listPionDetectives = new Button[] { troisD, deplacementW, deplacementS, deplacementT };
		troisD.setGraphic(troisDetectivesView);
		deplacementW.setGraphic(deplacementWatsonView);
		deplacementS.setGraphic(deplacementSherlockView);
		deplacementT.setGraphic(deplacementTobyView);

		for (Button i : listPionDetectives) {
			i.setShape(new Circle(30));
			i.setStyle("-fx-background-color: transparent;");
		}

		// Revelation alibi
		alibi.setGraphic(pileHautAlibiView);
		alibi.setStyle("-fx-background-color: transparent;");

		BackgroundImage myBI= new BackgroundImage(new Image("file:images/bleuv2.jpg", 675, 675,false,true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));
		
		printBoardInterface();
		root.add(commencer, 6, 0);
		Scene scene = new Scene(root, 675, 675);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}