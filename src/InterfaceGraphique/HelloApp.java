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

public class HelloApp extends Application {
	
	
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
		
		
		
		tournertuile1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				JohnSmith.setRotate(90);
			}
		});
		
		tournertuile2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				JohnPizer.setRotate(90);
			}
		});
		
		tournertuile3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				JosephLane.setRotate(90);
			}
		});
		
		tournertuile4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Madame.setRotate(90);
			}
		});
		
		tournertuile5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				SgtGoodley.setRotate(90);
			}
		});
		
		tournertuile6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				InspLestrade.setRotate(90);
			}
		});
		
		tournertuile7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				MissStealthy.setRotate(90);
			}
		});
		
		tournertuile8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				WilliamGull.setRotate(90);
			}
		});
		
		tournertuile9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				JeremyBert.setRotate(90);
			}
		});
		

		
		vertical1.getChildren().addAll(tournertuile1, tournertuile2, tournertuile3);
		vertical2.getChildren().addAll(tournertuile4, tournertuile5, tournertuile6);
		vertical3.getChildren().addAll(tournertuile7, tournertuile8, tournertuile9);
		
		Group root = new Group();
		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(vertical1);
		borderPane.setCenter(vertical2);
		borderPane.setRight(vertical3);
		Scene scene = new Scene(root);
		
		root.getChildren().add(borderPane);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();													 
		
		
		
		
	}

	

}
 