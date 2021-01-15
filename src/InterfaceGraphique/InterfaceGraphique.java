package InterfaceGraphique;

import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jetons.JetonAlibi;
import tour.TourImpairs;

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
	Image toby = new Image("file:images/detectives/Tobi.png", 50, 50, false, false);
	ImageView tobyView = new ImageView(toby);
	Image sherlock = new Image("file:images/detectives/Sherlock.png", 50, 50, false, false);
	ImageView sherlockView = new ImageView(sherlock);
	Image watson = new Image("file:images/detectives/Watson.png", 50, 50, false, false);
	ImageView watsonView = new ImageView(watson);
	Image pileHautAlibi = new Image("file:images/alibis/alibi-card.png", 60, 100, false, false);
	ImageView pileHautAlibiView = new ImageView(pileHautAlibi);
	Image mrJack = new Image(JetonAlibi.sourceImage(Jeu.nomMrJack[0]), 60, 100, false, false);
	ImageView mrJackView = new ImageView(mrJack);
	public static Image alibi2 = new Image("file:/image", 60, 100, false, false);
	public static ImageView alibi2View = new ImageView(alibi2);

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
	Button terminer = new Button();
	Button joueurSuivant = new Button();
	final Text vousEtes = new Text("Vous etes:");
	public static String idEnCours;

	ColumnConstraints column = new ColumnConstraints();
	RowConstraints row = new RowConstraints();

	public static void main(String[] args) {
		// Jeu.main(args);
		Jeu.initialisation();
		launch(args);
	}

	public void printBoardInterface() {
		root.getChildren().remove(joueurSuivant);
		root.getRowConstraints().remove(row);
		root.getColumnConstraints().remove(column);

		for (int i = 0; i < 9; i++) {
			root.add(tuile[i], 2 + i % 3, 3 + i / 3);
		}
		for (int i = 0; i < 24; i++) {
			if (i < 3) {
				root.add(d[i], i + 2, 2);
			} else if (i < 6) {
				root.add(d[i], 5, i);
			} else if (i < 9) {
				root.add(d[i], 10 - i, 6);
			} else if (i < 12) {
				root.add(d[i], 1, 14 - i);
			} else if (i < 15) {
				root.add(d[i], i - 10, 1);
			} else if (i < 18) {
				root.add(d[i], 6, i - 12);
			} else if (i < 21) {
				root.add(d[i], 22 - i, 7);
			} else if (i < 24) {
				root.add(d[i], 0, 26 - i);
			}
		}
		for (int i = 0; i < 4; i++) {
			root.add(action[i], i + 2, 0);
		}
		root.add(alibi, 0, 7);
		//root.add(alibi2View, 1, 7);
		root.add(terminer, 6, 0);
		// Si le joueur actuel est Mr. Jack, on affiche qui il est et son nombre de
		// sablier
		if (Jeu.jActuel == 1) {
			root.add(vousEtes, 6, 6);
			root.add(mrJackView, 6, 7);
			// Cas MrJack :Â montrer la carte + sablier
		}
		for (int nbActions = 0; nbActions < 4; nbActions++) {
			InterfaceGraphique.action[nbActions].setGraphic((Jeu.choixActions[nbActions]).getImView());
		}

		/*
		 * root.add(deplacementT, 1, 0); root.add(deplacementS, 2, 0);
		 * root.add(deplacementW, 3, 0); root.add(troisD, 4, 0); root.add(finDuTour, 5,
		 * 6); root.add(choixTourner, 6, 0); root.add(choixEchangerTuile, 5, 0);
		 */
	}

	public void joueurSuivant() {
		for (Button i : d) {
			root.getChildren().remove(i);
		}
		for (Button i : tuile) {
			root.getChildren().remove(i);
		}
		for (Button i : action) {
			root.getChildren().remove(i);
		}
		root.getChildren().remove(alibi);
		root.getChildren().remove(terminer);
		root.getChildren().remove(vousEtes);
		root.getColumnConstraints().add(column);
		root.getRowConstraints().add(row);
		root.add(joueurSuivant, 5, 0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le
															// modifier
		
		column.setPercentWidth(32);
		row.setPercentHeight(90);
		root.getColumnConstraints().add(column);
		root.getRowConstraints().add(row);
		root.add(joueurSuivant, 5, 0);
		root.add(commencer, 0, 0);
		
		// Les jetons
		finDuTour.setText("FIN");

		finDuTour.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Jeu.finDuTour();
			}
		});

		commencer.setText("Commencer");
		commencer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Jeu.jActuel = (++Jeu.jActuel % 2);
				joueurSuivant.setText("	C'est à  " + Jeu.joueurActuel[Jeu.jActuel] + " de jouer.\nSi vous etes pret, cliquez sur ce message");
				joueurSuivant();
				root.getChildren().remove(commencer);
			}
		});

		terminer.setText("Terminer l'action");
		terminer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Jeu.jActuel = (++Jeu.jActuel % 2);
				joueurSuivant.setText("	C'est à  " + Jeu.joueurActuel[Jeu.jActuel] + " de jouer.\nSi vous etes pret, cliquez sur ce message");
				joueurSuivant();
			}
		});
		
		joueurSuivant.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				printBoardInterface();
			}
		});

		/*choixTourner.setGraphic(tournerView);
		choixTourner.setShape(new Circle(30));
		choixTourner.setStyle("-fx-background-color: transparent;");
		choixTourner.setContentDisplay(ContentDisplay.CENTER);

		choixEchangerTuile.setGraphic(echangerView);
		choixEchangerTuile.setShape(new Circle(30));
		choixEchangerTuile.setStyle("-fx-background-color: transparent;");
		choixEchangerTuile.setContentDisplay(ContentDisplay.CENTER);*/

		// creation des tuiles
		for (int i = 0; i < 9; i++) {
			tuile[i] = new Button();
			tuile[i].setGraphic(Jeu.board[i].sourceImage());
			tuile[i].setStyle("-fx-background-color: transparent;");
			tuile[i].setRotate((double) Jeu.board[i].getMur() * 90 + 180);
			tuile[i].setId("Q" + i);
		}

		// Boutons detectives
		for (int i = 0; i < 24; i++) {
			d[i] = new Button();
			d[i].setId("D" + i);
			d[i].setMinWidth(50);
			d[i].setMinHeight(50);
			d[i].setShape(new Circle(30));
			d[i].setStyle("-fx-background-color: transparent;");
			//d[i].setContentDisplay(ContentDisplay.CENTER);
			if (i == 3) {
				d[i].setGraphic(watsonView);
			}
			if (i == 11) {
				d[i].setGraphic(sherlockView);
			}
			if (i == 7) {
				d[i].setGraphic(tobyView);
			}
		}

		// Boutons des actions proposÃ©es
		for (int i = 0; i < 4; i++) {
			action[i] = new Button();
			action[i].setMinWidth(50);
			action[i].setMinHeight(50);
			action[i].setShape(new Circle(30));
			action[i].setStyle("-fx-background-color: transparent;");
			action[i].setId("A" + i);
		}

		/*
		 * for (Button i : d) { i.setOnAction(event -> /* idEnCours =
		 *//*
			 * System.out.println(i.getId())); } for (Button i : tuile) {
			 * i.setOnAction(event -> System.out.println(i.getId()));// , idEnCours =
			 * i.getId()); // //System.out.println(i.getId())); } for (Button i : action) {
			 * i.setOnAction(event -> System.out.println(i.getId()));// , idEnCours =
			 * i.getId()); // //System.out.println(i.getId())); }
			 */
		for (Button i : action) {
			i.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					System.out.println(i.getId());
				}
			});
		}
		for (Button i : tuile) {
			i.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					System.out.println(i.getId());
				}
			});
		}
		for (Button i : d) {
			i.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					System.out.println(i.getId());
				}
			});
		}
		// Bouton Tourner les tuiles


		/*
		 * // Bouton Tourner les tuiles choixTourner.setOnAction(new
		 * EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) { for (int i = 0; i < 9; i++) {
		 * Node imTuile = tuile[i].getGraphic(); tuile[i].setOnAction(new
		 * EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent e) {
		 * imTuile.setRotate(imTuile.getRotate() + 90); } // tuileTournante = i; }); } }
		 * });
		 */

		// Echange de tuile a revoir probleme avec j et i qui doivent etre final
		
		action[0].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {	
				Jeu.choixActions[0].action(Jeu.listeDetectives,Jeu.board,Jeu.jActuel);
			}
		});
				
		action[1].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {	
				Jeu.choixActions[0].action(Jeu.listeDetectives,Jeu.board,Jeu.jActuel);
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
		alibi.setGraphic(pileHautAlibiView);
		alibi.setStyle("-fx-background-color: transparent;");

		// JetonAlibi pileAlibi = new JetonAlibi("alibi");

		alibi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String[] carte = ((JetonAlibi) TourImpairs.actionAlibi).piocherCarte();
				String sourceImage = ((JetonAlibi) TourImpairs.actionAlibi).sourceImage(carte[0]);
				if (!sourceImage.equals("Lapileestvide-alibi.png")) { // a modifier pour eviter la syntaxe bizare
					ImageView carteRetournee = new ImageView(getClass().getResource(sourceImage).toString());
					carteRetournee.setFitHeight(100);
					carteRetournee.setFitWidth(60);
					//alibi2.setGraphic(carteRetournee);
				} else {
					// Enlever image alibi
				}

			}
		});

		// innocent.setGraphic();
		innocent.setText("Innocent");

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
		/**
		 * Button Valider = new Button (); Valider.setGraphic(ticverte);
		 * Valider.setStyle("-fx-background-color: transparent;");
		 * Valider.setContentDisplay(ContentDisplay.RIGHT); //Valider.setText("Valider
		 * ");
		 * 
		 * Button Annuler = new Button (); Annuler.setGraphic(False);
		 * Annuler.setStyle("-fx-background-color: transparent;");
		 * Annuler.setContentDisplay(ContentDisplay.RIGHT); //Annuler.setText("Annuler
		 * ");
		 */

		
		
		printBoardInterface();
		root.getChildren().remove(terminer);
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