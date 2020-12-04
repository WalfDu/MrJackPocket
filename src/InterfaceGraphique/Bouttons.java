package InterfaceGraphique;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.application.Application;
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

public class Bouttons {
	
	private Button tournertuile1;
	private Button tournertuile2;
	private Button tournertuile3;
	private Button tournertuile4;
	private Button tournertuile5;
	private Button tournertuile6;
	private Button tournertuile7;
	private Button tournertuile8;
	private Button tournertuile9;
	
	
	public void start(Stage primaryStage) throws Exception {
		
	private ImageView JohSmith = new ImageView();
	
	private ImageView getJohnSmith() {
		return JohnSmith;
	}
	
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
	
	Button Valider = new Button ();
	Valider.setGraphic(ticverte);
	Valider.setContentDisplay(ContentDisplay.RIGHT);
	Valider.setText("Valider     ");

	Button Annuler = new Button ();
	Annuler.setGraphic(False);
	Annuler.setContentDisplay(ContentDisplay.RIGHT);
	Annuler.setText("Annuler     ");
	
	}

}
