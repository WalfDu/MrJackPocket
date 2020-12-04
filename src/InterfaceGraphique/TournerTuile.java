package InterfaceGraphique;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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

public class TournerTuile {
	
	
	public void start(Stage primaryStage) throws Exception {
	
		
	tournertuile1.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			JohnSmith.setRotate(JohnSmith.getRotate() +90);
		}
	});
	
	tournertuile2.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			JohnPizer.setRotate(JohnPizer.getRotate() + 90);
			
		}
	});
	
	tournertuile3.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			JosephLane.setRotate(JosephLane.getRotate() +90);
		}
	});
	
	tournertuile4.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			Madame.setRotate(Madame.getRotate() +90);
		}
	});
	
	tournertuile5.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			SgtGoodley.setRotate(SgtGoodley.getRotate() +90);
		}
	});
	
	tournertuile6.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			InspLestrade.setRotate(InspLestrade.getRotate() +90);
		}
	});
	
	tournertuile7.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			MissStealthy.setRotate(MissStealthy.getRotate() +90);
		}
	});
	
	tournertuile8.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			WilliamGull.setRotate(WilliamGull.getRotate() +90);
		}
	});
	
	tournertuile9.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			JeremyBert.setRotate(JeremyBert.getRotate() +90);
		}
	});
	}
}
