package InterfaceGraphique;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Bouttontest {

	private ImageView personnage;

	public void start(Stage primaryStage) throws Exception {
		
	}
	
	public Bouttontest(String nomImage) {
		ImageView personnage = new ImageView(getClass().getResource(nomImage).toString());
		this.personnage = personnage;
	}
	
	
	public ImageView getpersonnage() {
		return personnage;
	}

	public void setpersonnage(ImageView personnage) {
		this.personnage = personnage;
	

	Button bouttonJohnSmith = new Button();
	
	bouttonJohnSmith.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			bouttonJohnSmith.setRotate(bouttonJohnSmith.getRotate() +90);
		}
	});
}
}