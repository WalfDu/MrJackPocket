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

	public static GridPane root = new GridPane(); // Choix du type d'interface graphique que l'on tilise : GridPane se
													// comporte comme un tableau dans lequel nous remplissons les cases

	// Impotation de toutes les images situées dans un autre dossier que l'on
	// redimensionne pour la taille des boutons (on décrit ces images avec le type
	// ImageView)

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
	Image toby = new Image("file:images/detectives/Toby.png", 50, 50, false, false);
	ImageView tobyView = new ImageView(toby);
	Image sherlock = new Image("file:images/detectives/Sherlock.png", 50, 50, false, false);
	ImageView sherlockView = new ImageView(sherlock);
	Image watson = new Image("file:images/detectives/Watson.png", 50, 50, false, false);
	ImageView watsonView = new ImageView(watson);
	Image pileHautAlibi = new Image("file:images/alibis/alibi-card.png", 60, 100, false, false);
	ImageView pileHautAlibiView = new ImageView(pileHautAlibi);
	static Image mrJack = new Image(JetonAlibi.sourceImage(Jeu.nomMrJack[0]), 60, 100, false, false);
	static ImageView mrJackView = new ImageView(mrJack);
	public static Image alibi2 = new Image("file:images/Annuler.png", 60, 100, false, false);
	public static ImageView alibi2View = new ImageView(alibi2);
	static Image valider = new Image("file:images/Valider.png", 50, 50, false, false);
	static ImageView validerView = new ImageView(valider);
	static Image sablier = new Image("file:images/sablier.png", 30, 30, false, false);
	static ImageView sablierView = new ImageView(sablier);

	// Définition des boutons

	public static Button choixTourner = new Button();
	public static Button choixEchangerTuile = new Button();
	public static Button[] d = new Button[24];
	public static Button troisD = new Button();
	public static Button deplacementW = new Button();
	public static Button deplacementS = new Button();
	public static Button deplacementT = new Button();
	public static Button alibi = new Button();
	Button innocent = new Button();
	public static Button[] tuile = new Button[9];
	public static Button finDuTour = new Button();
	public static Button[] action = new Button[4];
	static Button commencer = new Button();
	public static Button terminer = new Button();
	static Button joueurSuivant = new Button();
	public static Button validerB = new Button();

	// Affichage du message pour Mr Jack indiquant son personnage ainsi que son
	// nombre de sablier

	static String nomMrJack = "";
	final static Text vousEtes = new Text("Vous etes:" + nomMrJack);
	final static Text nbSabliers = new Text("Vous avez:" + Jeu.sabliers);
	public static String idEnCours;

	// Colonnes et lignes vides afin de pouvoir centrer un message au centre de
	// l'interface graphique
	static ColumnConstraints column = new ColumnConstraints();
	static RowConstraints row = new RowConstraints();

	public static void main(String[] args) { // fonction qui permet de lancer le jeu et d'initialiser tous les
												// paramètres pour le début de la partie
		Jeu.initialisation();
		for (String i : Jeu.nomMrJack[0].split(" ")) {
			nomMrJack += "\n" + i; // Cela sert à  avoir le nom de Mr. Jack sur deux lignes en bas à  droite
		}
		launch(args);
	}

	// Placement et affichage de tous nos boutons sur l'interface graphique

	public static void printBoardInterface() {

		nbSabliers.setText("Vous avez:\n" + Jeu.sabliers + Jeu.sabliersCaches);
		root.getChildren().remove(joueurSuivant);
		root.getRowConstraints().remove(row);
		root.getColumnConstraints().remove(column);

		// Ajout des tuiles du plateau

		for (int i = 0; i < 9; i++) {
			root.add(tuile[i], 2 + i % 3, 3 + i / 3);
		}

		// Ajout des boutons des detectives sur les lignes et les colonnes autour du
		// plateau de tuile

		for (int i = 0; i < 24; i++) {
			if (i < 3) {
				root.add(d[i], i + 2, 2); // ajout d'une première ligne de bouton autour du plateau
			} else if (i < 6) {
				root.add(d[i], 5, i); // ajout d'une colonne de bouton autour du plateau
			} else if (i < 9) {
				root.add(d[i], 10 - i, 6);
			} else if (i < 12) {
				root.add(d[i], 1, 14 - i);
			} else if (i < 15) {
				root.add(d[i], i - 10, 1); // On ajoute d'une deuxième rangée de bouton pour satisfaire le cas où 2
											// detectives seraient présents sur la même case
			} else if (i < 18) {
				root.add(d[i], 6, i - 12);
			} else if (i < 21) {
				root.add(d[i], 22 - i, 7);
			} else if (i < 24) {
				root.add(d[i], 0, 26 - i);
			}
		}

		// Ajout de bouton
		root.add(alibi, 0, 7); // bouton de la pile d'alibi
		root.add(alibi2View, 1, 7);
		root.add(commencer, 6, 0); // bouton de l'action terminée

		// Si le joueur actuel est Mr. Jack, on affiche qui il est et son nombre de
		// sablier
		if (Jeu.jActuel == 1) {
			root.add(sablierView, 5, 7);
			root.add(vousEtes, 6, 6);
			root.add(nbSabliers, 5, 6);
			root.add(mrJackView, 6, 7);
		}

		//
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

	// On retire tous les boutons pour passer au joueur suivant entre les actions

	public static void joueurSuivant() {
		for (Button i : d) {
			root.getChildren().remove(i); // retrait des boutons détectives
		}
		for (Button i : tuile) {
			root.getChildren().remove(i); // retrait des boutons tuiles
		}
		for (Button i : action) {
			root.getChildren().remove(i); // retrait des boutons actions
		}
		if (Jeu.jActuel == 0) {
			root.getChildren().remove(sablierView); // retrait des boutons dans le cas où c'était Mr Jack qui était en
													// train de jouer
			root.getChildren().remove(vousEtes);
			root.getChildren().remove(nbSabliers);
			root.getChildren().remove(mrJackView);
		}
		root.getChildren().remove(alibi); // retrait des autres boutons
		root.getChildren().remove(commencer);
		root.getChildren().remove(validerB);
		root.getChildren().remove(alibi2View);
		root.getColumnConstraints().add(column);
		root.getRowConstraints().add(row);
		root.add(joueurSuivant, 5, 0);
	}

	// Mise en place de la fin d'une action
	public static void finAction() {
		Jeu.finPartie(Jeu.tourEnCours);
		if (Jeu.actionsFaites.size() > 3) { // Une fois les quatre actions jouées on réactive les boutons
			for (Button i : action) {
				i.setDisable(false);
			}
			Jeu.finDuTour();
			Jeu.tourEnCours++; // On passe au tour suivant, on ajoute un sablier à Mr Jack et on regarde quels
								// sont les detectives à innocenter
			if (Jeu.tourEnCours % 2 == 0) { //choix action est le tableau des jetons qui vont pouvoir être joués au tour suivant
				Jeu.choixActions = TourPairs.debut(Jeu.choixActions); 
			} else {
				Jeu.choixActions = TourImpairs.debut();
			}
			Jeu.actionsFaites.clear(); // Aucune action n'a été faite à ce tour-ci
		}
		if (Jeu.actionsFaites.size() != 2) {// On désigne qui va jouer la première action au début du nouveau tour soit
											// Mr Jack soit Mr Le Détective
			Jeu.jActuel = (++Jeu.jActuel % 2);// Pour un tour pair c'est Mr Jack qui commence, pour un tour impair c'est
												// Mr le Détective qui commence
			joueurSuivant.setText("C'est Ã  " + Jeu.joueurActuel[Jeu.jActuel]
					+ " de jouer.\nSi vous etes pret, cliquez sur ce message");
			joueurSuivant();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		column.setPercentWidth(32);
		row.setPercentHeight(90);
		root.getColumnConstraints().add(column);// centrer le message de joueur suivant
		root.getRowConstraints().add(row); // centrer le message de joueur suivant
		root.add(joueurSuivant, 6, 0);
		root.getChildren().remove(vousEtes); // retrait du message du joueur suivant
		root.getChildren().remove(mrJackView);

		// Les jetons
		finDuTour.setText("FIN");
		finDuTour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Jeu.finDuTour(); // appelle de la fonction fin du tour : innocenter les tuiles qui sont visibles
			}
		});

		// Boutton Valider utilisé pour fixer la rotation d'une tuile lors de l'action
		// tourner la tuile
		validerB.setGraphic(validerView);
		validerB.setStyle("-fx-background-color: transparent;");

		// Button Commencer la partie
		commencer.setText("Commencer\nla partie");
		commencer.setMinWidth(75);
		commencer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Jeu.jActuel == -1) {
					for (Button i : action) {
						i.setDisable(false); // les boutons actions ne peuvent plus être utilisés une fois l'action
												// réalisée
					}
				}
				finAction();
			}
		});

		joueurSuivant.setOnAction(new EventHandler<ActionEvent>() { // Nouvelle écran d'affichage où l'on invite l'autre
																	// joueur à jouer son tour
			@Override
			public void handle(ActionEvent e) {
				printBoardInterface(); // affichage du nouvelle écran
			}
		});

		// creation des tuiles
		for (int i = 0; i < 9; i++) {
			tuile[i] = new Button();
			tuile[i].setGraphic(Jeu.board[i].sourceImage()); // on définit l'image sur la tuile
			tuile[i].setStyle("-fx-background-color: transparent;"); // Fond transparent
			tuile[i].setRotate((double) Jeu.board[i].getMur() * 90 + 180); // initialisation aléatoire de la rotation de
																			// la tuile
			tuile[i].setId("Q" + i); // création de l'id de la tuile
		}

		// Boutons detectives
		for (int i = 0; i < 24; i++) {
			d[i] = new Button();
			d[i].setId("D" + i); // Identifiant de la tuile
			d[i].setMinWidth(50);
			d[i].setMinHeight(50);
			d[i].setShape(new Circle(30));
			d[i].setStyle("-fx-background-color: transparent;");
			if (i == 3) {
				d[i].setGraphic(watsonView); // Watson est toujours placé en haut à droite du plateau
			}
			if (i == 11) {
				d[i].setGraphic(sherlockView); // Sherlock est toujours placé en haut à gauche du plateau
			}
			if (i == 7) {
				d[i].setGraphic(tobyView);// tobiest toujours placé en bas au milieu
			}
		}

		// Boutons des actions proposées
		for (int i = 0; i < 4; i++) {
			action[i] = new Button();
			action[i].setMinWidth(50);
			action[i].setMinHeight(50);
			action[i].setShape(new Circle(30)); // Création d'un bouton rond
			action[i].setStyle("-fx-background-color: transparent;");
			action[i].setId("A" + i);
			action[i].setDisable(true);
		}

		// Création des boutons deplacement des detectives
		Button[] listPionDetectives = new Button[] { troisD, deplacementW, deplacementS, deplacementT };
		troisD.setGraphic(troisDetectivesView);
		deplacementW.setGraphic(deplacementWatsonView);
		deplacementS.setGraphic(deplacementSherlockView);
		deplacementT.setGraphic(deplacementTobyView);

		// Définition du style des boutons
		for (Button i : listPionDetectives) {
			i.setShape(new Circle(30));
			i.setStyle("-fx-background-color: transparent;");
		}

		// Création de la pile alibi
		alibi.setGraphic(pileHautAlibiView);
		alibi.setStyle("-fx-background-color: transparent;");

		// Définition d'un arrière plan
		BackgroundImage myBI = new BackgroundImage(new Image("file:images/bleuv2.jpg", 675, 675, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));

		// Affichage de l'interfave Graphique
		printBoardInterface();
		Scene scene = new Scene(root, 675, 675); // création de la scène
		primaryStage.setScene(scene);
		primaryStage.show(); // affichage du jeu sur l'interface graphique
	}
}