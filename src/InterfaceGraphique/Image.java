package InterfaceGraphique;

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

public class Image {
	
	private ImageView JohnSmith;
	private ImageView JohnPizer;
	private ImageView JosephLane;
	private ImageView Madame;
	private ImageView SgtGoodley;
	private ImageView InspLestrade;
	private ImageView MissStealthy;
	private ImageView WilliamGull;
	private ImageView JeremyBert;
	
	
	
	public void start(Stage primaryStage) throws Exception {
	
		
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
	ticverte.setFitWidth(30);
	ticverte.setFitHeight(30);
	False.setFitWidth(30);
	False.setFitHeight(30);
	
	}



	public ImageView getJohnSmith() {
		return JohnSmith;
	}



	public void setJohnSmith(ImageView johnSmith) {
		JohnSmith = johnSmith;
	}



	public ImageView getJohnPizer() {
		return JohnPizer;
	}



	public void setJohnPizer(ImageView johnPizer) {
		JohnPizer = johnPizer;
	}



	public ImageView getJosephLane() {
		return JosephLane;
	}



	public void setJosephLane(ImageView josephLane) {
		JosephLane = josephLane;
	}



	public ImageView getMadame() {
		return Madame;
	}



	public void setMadame(ImageView madame) {
		Madame = madame;
	}



	public ImageView getSgtGoodley() {
		return SgtGoodley;
	}



	public void setSgtGoodley(ImageView sgtGoodley) {
		SgtGoodley = sgtGoodley;
	}



	public ImageView getInspLestrade() {
		return InspLestrade;
	}



	public void setInspLestrade(ImageView inspLestrade) {
		InspLestrade = inspLestrade;
	}



	public ImageView getMissStealthy() {
		return MissStealthy;
	}



	public void setMissStealthy(ImageView missStealthy) {
		MissStealthy = missStealthy;
	}



	public ImageView getWilliamGull() {
		return WilliamGull;
	}



	public void setWilliamGull(ImageView williamGull) {
		WilliamGull = williamGull;
	}



	public ImageView getJeremyBert() {
		return JeremyBert;
	}



	public void setJeremyBert(ImageView jeremyBert) {
		JeremyBert = jeremyBert;
	}

}
