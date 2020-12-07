package InterfaceGraphique;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

import javafx.scene.layout.*;
import javafx.scene.control.Tooltip;
public class HelloApp extends Application {
	
	
	public static void main(String[] args){
	 launch(args);
}
	
	//HelloJava.HelloApp
	@Override
	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le modifier
		
		
		VBox vertical1 = new VBox(); // met un espace entre les infos
		VBox vertical2 = new VBox();
		VBox vertical3 = new VBox();
		HBox Horizontal1 = new HBox();
		HBox Horizontal2 = new HBox();
		
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
		ImageView ticverte = new ImageView(getClass().getResource("ticverte.png").toString());
		ImageView False = new ImageView(getClass().getResource("False.png").toString());
		ImageView Echanger = new ImageView(getClass().getResource("Jeton1-Face1.png").toString());
		ImageView Tourner = new ImageView(getClass().getResource("Jeton1-Face2.png").toString());
		ImageView Verso = new ImageView(getClass().getResource("common-verso.png").toString());
		ImageView JosephLaneVerso = new ImageView(getClass().getResource("JosephLane-verso.png").toString());
		ImageView Watson = new ImageView(getClass().getResource("Watson.png").toString());
		ImageView Tobi = new ImageView(getClass().getResource("Tobi.png").toString());
		ImageView Sherlock = new ImageView(getClass().getResource("Sherlock.png").toString());
		
		JohnSmith.setFitHeight(100);
		JohnPizer.setFitHeight(100);
		JohnSmith.setFitWidth(100);
		JohnPizer.setFitWidth(100);
		JosephLane .setFitHeight(100);
		JosephLane .setFitWidth(100);
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
		ticverte.setFitWidth(30);
		ticverte.setFitHeight(30);
		False.setFitWidth(30);
		False.setFitHeight(30);
		Echanger.setFitWidth(40);
		Echanger.setFitHeight(40);
		Tourner.setFitWidth(40);
		Tourner.setFitHeight(40);
		Verso.setFitWidth(100);
		Verso.setFitHeight(100);
		JosephLaneVerso.setFitWidth(100);
		JosephLaneVerso.setFitHeight(100);
		Tobi.setFitWidth(50);
		Tobi.setFitHeight(50);
		Sherlock.setFitWidth(50);
		Sherlock.setFitHeight(50);
		Watson.setFitWidth(50);
		Watson.setFitHeight(50);
		
		vertical1.setPadding(new Insets(0)); // met des espacement partout
		vertical1.setAlignment(Pos.CENTER); //(centre tout)
		vertical2.setPadding(new Insets(0)); // met des espacement partout
		vertical2.setAlignment(Pos.CENTER); //(centre tout)
		Horizontal1.setPadding(new Insets(0));
		
		
		// Création des Bouttons
		
		Button tuile1 = new Button ();
		tuile1.setGraphic(JohnSmith);
		tuile1.setStyle("-fx-background-color: transparent;");
		tuile1.setContentDisplay(ContentDisplay.RIGHT );
		
		Button tuile2 = new Button ();
		tuile2.setGraphic(JohnPizer);
		tuile2.setStyle("-fx-background-color: transparent;");
		tuile2.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile3 = new Button ();
		tuile3.setGraphic(JosephLane);
		tuile3.setStyle("-fx-background-color: transparent;");
		tuile3.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile4 = new Button ();
		tuile4.setGraphic(Madame);
		tuile4.setStyle("-fx-background-color: transparent;");
		tuile4.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile5 = new Button ();
		tuile5.setGraphic(SgtGoodley);
		tuile5.setStyle("-fx-background-color: transparent;");
		tuile5.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile6 = new Button ();
		tuile6.setGraphic(InspLestrade);
		tuile6.setStyle("-fx-background-color: transparent;");
		tuile6.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile7 = new Button ();
		tuile7.setGraphic(MissStealthy);
		tuile7.setStyle("-fx-background-color: transparent;");
		tuile7.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile8 = new Button ();
		tuile8.setGraphic(WilliamGull);
		tuile8.setStyle("-fx-background-color: transparent;");
		tuile8.setContentDisplay(ContentDisplay.RIGHT);
		
		Button tuile9 = new Button ();
		tuile9.setGraphic(JeremyBert);
		tuile9.setStyle("-fx-background-color: transparent;");
		tuile9.setContentDisplay(ContentDisplay.RIGHT);
		
		// Bouttons actions 
		
		
		Button Valider = new Button ();
		Valider.setGraphic(ticverte);
		Valider.setStyle("-fx-background-color: transparent;");
		Valider.setContentDisplay(ContentDisplay.RIGHT);
		//Valider.setText("Valider     ");
	
		Button Annuler = new Button ();
		Annuler.setGraphic(False);
		Annuler.setStyle("-fx-background-color: transparent;");
		Annuler.setContentDisplay(ContentDisplay.RIGHT);
		//Annuler.setText("Annuler     ");
		
		Button ChoixTourner = new Button();
		ChoixTourner.setGraphic(Tourner);
		ChoixTourner.setShape(new Circle(30));
		ChoixTourner.setStyle("-fx-background-color: transparent;");
		ChoixTourner.setContentDisplay(ContentDisplay.CENTER );
		
		Button choixEchangerTuile = new Button ();
		choixEchangerTuile.setGraphic(Echanger);
		choixEchangerTuile.setShape(new Circle(30));
		choixEchangerTuile.setStyle("-fx-background-color: transparent;");
		choixEchangerTuile.setContentDisplay(ContentDisplay.CENTER);
		
		Button innocent = new Button();
		//innocent.setGraphic();
		innocent.setContentDisplay(ContentDisplay.RIGHT);
		innocent.setText("Innocent");
	
	
		// Button Detectives
		
		Button D1 = new Button ();
		D1.setShape(new Circle(30));
		//D1.setStyle("-fx-background-color: transparent;");
		D1.setContentDisplay(ContentDisplay.RIGHT);

		Button D2 = new Button ();
		D2.setShape(new Circle(30));
		//D2.setStyle("-fx-background-color: transparent;");
		D2.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D3 = new Button ();
		D3.setShape(new Circle(30));
		//D3.setStyle("-fx-background-color: transparent;");
		D3.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D4 = new Button ();
		D4.setShape(new Circle(30));
		D4.setGraphic(Watson);
		//D4.setStyle("-fx-background-color: transparent;");
		D4.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D5 = new Button ();
		D5.setShape(new Circle(30));
		//D5.setStyle("-fx-background-color: transparent;");
		D5.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D6 = new Button ();
		D6.setShape(new Circle(30));
		//D6.setStyle("-fx-background-color: transparent;");
		D6.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D7 = new Button ();
		D7.setShape(new Circle(30));
		//D7.setStyle("-fx-background-color: transparent;");
		D7.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D8 = new Button ();
		D8.setShape(new Circle(30));
		D8.setGraphic(Tobi);
		//D8.setStyle("-fx-background-color: transparent;");
		D8.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D9 = new Button ();
		D9.setShape(new Circle(30));
		//D9.setStyle("-fx-background-color: transparent;");
		D9.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D10 = new Button ();
		D10.setShape(new Circle(30));
		//D10.setStyle("-fx-background-color: transparent;");
		D10.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D11 = new Button ();
		D11.setShape(new Circle(30));
		//D11.setStyle("-fx-background-color: transparent;");
		D11.setContentDisplay(ContentDisplay.RIGHT);
		
		Button D12 = new Button ();
		D12.setShape(new Circle(30));
		D12.setGraphic(Sherlock);
		//D12.setStyle("-fx-background-color: transparent;");
		D12.setContentDisplay(ContentDisplay.RIGHT);
		
		// Déplacement des detectives
		
		D4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				D5.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imD4 = D4.getGraphic();
						D5.setGraphic(imD4);
					}
				});
				D6.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imD4 = D4.getGraphic();
						D6.setGraphic(imD4);
					}
				});
			}
		});
		
		// Création du boutons choix de tourner
		
		ChoixTourner.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				tuile1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile1 = tuile1.getGraphic();
						imTuile1.setRotate(imTuile1.getRotate() +90);
					}
				});
				
				tuile2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile2 = tuile2.getGraphic();
						imTuile2.setRotate(imTuile2.getRotate() + 90);
						
					}
				});
				
				tuile3.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile3 = tuile3.getGraphic();
						imTuile3.setRotate(imTuile3.getRotate() +90);
					}
				});
				
				tuile4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile4 = tuile4.getGraphic();
						imTuile4.setRotate(imTuile4.getRotate() +90);
					}
				});
				
				tuile5.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile5 = tuile5.getGraphic();
						imTuile5.setRotate(imTuile5.getRotate() +90);
					}
				});
				
				tuile6.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile6 = tuile6.getGraphic();
						imTuile6.setRotate(imTuile6.getRotate() +90);
					}
				});
				
				tuile7.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile7 = tuile7.getGraphic();
						imTuile7.setRotate(imTuile7.getRotate() +90);
					}
				});
				
				tuile8.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile8 = tuile8.getGraphic();
						imTuile8.setRotate(imTuile8.getRotate() +90);
					}
				});
				
				tuile9.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile9 = tuile9.getGraphic();
						imTuile9.setRotate(imTuile9.getRotate() +90);
					}
				});
			}
		});
		
		
		// Création du boutons choix d'échanger tuile
		
		choixEchangerTuile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				tuile1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile1 = tuile1.getGraphic();
						tuile2.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile2 = tuile2.getGraphic();
								tuile2.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile2);
							}
						});
						tuile3.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile3 = tuile3.getGraphic();
								tuile3.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile3);
							}
						});
						tuile4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile4 = tuile4.getGraphic();
								tuile4.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile4);
							}
						});
						tuile5.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile5 = tuile5.getGraphic();
								tuile5.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile5);
							}
						});
						tuile6.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile6 = tuile6.getGraphic();
								tuile6.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile6);
							}
						});
						tuile7.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile7 = tuile7.getGraphic();
								tuile7.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile7);
							}
						});
						tuile8.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile8 = tuile8.getGraphic();
								tuile8.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile8);
							}
						});
						tuile9.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile9 = tuile9.getGraphic();
								tuile9.setGraphic(imTuile1);
								tuile1.setGraphic(imTuile9);
							}
						});
					}
				});
				tuile2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile2 = tuile2.getGraphic();
						tuile1.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile1 = tuile1.getGraphic();
								tuile1.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile1);
							}
						});
						tuile3.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile3 = tuile3.getGraphic();
								tuile3.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile3);
							}
						});
						tuile4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile4 = tuile4.getGraphic();
								tuile4.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile4);
							}
						});
						tuile5.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile5 = tuile5.getGraphic();
								tuile5.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile5);
							}
						});
						tuile6.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile6 = tuile6.getGraphic();
								tuile6.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile6);
							}
						});
						tuile7.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile7 = tuile7.getGraphic();
								tuile7.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile7);
							}
						});
						tuile8.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile8 = tuile8.getGraphic();
								tuile8.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile8);
							}
						});
						tuile9.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								Node imTuile9 = tuile9.getGraphic();
								tuile9.setGraphic(imTuile2);
								tuile2.setGraphic(imTuile9);
							}
						});
					}
				});
				
			};
			
		});
												
								
		
		// Création d'un évenement
		
		//EventHandler AppuyerValider = new EventHandler (<ActionEvent>() {
			//public void handle(ActionEvent event) {
				//System.out.println("Handling event "+ event.getEventType());
				//event.consume();
			//}
		//};
		
		
		
		
		
		// Retourner une carte passage quartier à ville 
		
		innocent.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				tuile1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile1 = tuile1.getGraphic();
						Double Rotation = imTuile1.getRotate();
						if (imTuile1 == JosephLane) {
							tuile1.setGraphic(JosephLaneVerso);
						}
						else {
						tuile1.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});
				tuile2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile2 = tuile2.getGraphic();
						Double Rotation = imTuile2.getRotate();
						if (imTuile2 == JosephLane) {
							tuile2.setGraphic(JosephLaneVerso);
						}
						else {
						tuile2.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});
				tuile3.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile3= tuile3.getGraphic();
						Double Rotation = imTuile3.getRotate();
						if (imTuile3 == JosephLane) {
							tuile3.setGraphic(JosephLaneVerso);
						}
						else {
						tuile3.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});
				tuile4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile4 = tuile4.getGraphic();
						Double Rotation = imTuile4.getRotate();
						if (imTuile4 == JosephLane) {
							tuile4.setGraphic(JosephLaneVerso);
						}
						else {
						tuile4.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});
				tuile5.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile5 = tuile5.getGraphic();
						Double Rotation = imTuile5.getRotate();
						if (imTuile5 == JosephLane) {
							tuile5.setGraphic(JosephLaneVerso);
						}
						else {
						tuile5.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});
				tuile6.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile6 = tuile6.getGraphic();
						Double Rotation = imTuile6.getRotate();
						if (imTuile6 == JosephLane) {
							tuile6.setGraphic(JosephLaneVerso);
						}
						else {
						tuile6.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});
				tuile7.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile7 = tuile7.getGraphic();
						Double Rotation = imTuile7.getRotate();
						if (imTuile7 == JosephLane) {
							tuile7.setGraphic(JosephLaneVerso);
						}
						else {
						tuile7.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});	
				tuile8.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile8 = tuile8.getGraphic();
						Double Rotation = imTuile8.getRotate();
						if (imTuile8 == JosephLane) {
							tuile8.setGraphic(JosephLaneVerso);
						}
						else {
						tuile8.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});	
				tuile9.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						Node imTuile9 = tuile9.getGraphic();
						Double Rotation = imTuile9.getRotate();
						if (imTuile9 == JosephLane) {
							tuile9.setGraphic(JosephLaneVerso);
						}
						else {
						tuile9.setGraphic(Verso);
						Verso.setRotate(Rotation);}
					}
				});	
					
			}
		});
		
		

		
		//vertical1.getChildren().addAll(tuile1, tuile2, tuile3);
		//vertical2.getChildren().addAll(tuile4, tuile5, tuile6);
		//vertical3.getChildren().addAll(tuile7, tuile8, tuile9);
		//Horizontal1.getChildren().addAll(Valider, Annuler, choixEchangerTuile, ChoixTourner);
		//Horizontal2.getChildren().addAll(innocent);
		
		GridPane root = new GridPane();
		root.add(choixEchangerTuile,2,0);
		root.add(ChoixTourner,3,0);
		root.add(innocent, 1, 0);
		root.add(tuile1,1,2);
		root.add(tuile2, 1, 3);
		root.add(tuile3, 1, 4);
		root.add(tuile4, 2, 2);
		root.add(tuile5, 2, 3);
		root.add(tuile6, 2, 4);
		root.add(tuile7, 3, 2);
		root.add(tuile8, 3, 3);
		root.add(tuile9, 3, 4);
		root.add(D1, 1, 1);
		root.add(D2, 2, 1);
		root.add(D3, 3, 1);
		root.add(D4, 4, 2);
		root.add(D5, 4, 3);
		root.add(D6, 4, 4);
		root.add(D7, 3, 5);
		root.add(D8, 2, 5);
		root.add(D9, 1, 5);
		root.add(D10, 0, 4);
		root.add(D11, 0, 3);
		root.add(D12, 0, 2);
		
		//Group root = new Group();
		//BorderPane borderPane = new BorderPane();
		//borderPane.setLeft(vertical1);
		//borderPane.setCenter(vertical2);
		//borderPane.setRight(vertical3);
		//borderPane.setBottom(Horizontal2);
		//borderPane.setTop(Horizontal1);
		
		Scene scene = new Scene(root);
		
		//root.getChildren().add(borderPane);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();		
		
	}
}