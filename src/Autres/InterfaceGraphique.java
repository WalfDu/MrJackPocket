package src.Autres;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceGraphique extends Application {

	public void start(Stage primaryStage) throws Exception { // primaryStage est juste un nom de parametre on peut le modifier

		//primaryStage.setTitle("Hello JavaFX !"); // mettre un titre
		//primaryStage.setWidth(600); // taille fenetre largeur
		//primaryStage.setHeight(500);// taille fenetre hauteur
		//primaryStage.centerOnScreen(); // centrer la fenetre au milieu de l'écran

		//StackPane root = new StackPane(); // composant parent : emplacement et empillement
		//Scene scene = new Scene(root, 600, 400); // scene graphe + dimensions

		//root.getChildren().add(new Rectangle(400, 200, Color.YELLOW ));
		//root.getChildren().add(new Label("Hello World")); // ajout d'un enfant : un label
		// sinon autre methode: (Attention à l'ordre)

		//Label label = new Label ("Hello World");
		//Rectangle rectangle = new Rectangle (400, 200, Color.YELLOW );
		//root.getChildren().add(rectangle);
		//root.getChildren().add(label);
		// sinon addAll avec tous les ajouts

		// fonction rectangle.toFront ou rectangle.toBack modifie l'empillement

		//primaryStage.setScene(scene); // plusieurs scene

		// Projet Coureurs de jupons

		//VBox root = new VBox();

		// ajouter une image

		ImageView JohnSmith = new ImageView(getClass().getResource("JohnSmith-recto.png").toString());
		ImageView JohnPizer = new ImageView(getClass().getResource("JohnPizer-recto.png").toString());
		//ImageView JosephLane = new ImageView(getClass().getResource("JosephLane-recto.png").toString());
		//ImageView Madame = new ImageView(getClass().getResource("Madame-recto.png").toString());
		JohnSmith.setFitHeight(100);
		JohnPizer.setFitHeight(100);
		JohnSmith.setFitWidth(100);
		JohnPizer.setFitWidth(100);

		//ImageView coeurImageView = new ImageView(getClass().getResource("coeur.png").toString());
		//coeurImageView.setFitHeight(20); // redimensionnement du coeur
		//coeurImageView.setFitWidth(20);
		//coeurImageView.setRotate(90); // pivoter de 90°
		VBox root = new VBox(10); // met un espace entre les infos
		HBox horizontal = new HBox(10);
		root.setPadding(new Insets(25)); // met des espacement partout
		root.setAlignment(Pos.CENTER); //(centre tout)
		//Label statuslabel = new Label("Nombre de copine :" + totalGirlfriendsCount ); // on peut utiliser label.setText()

		Button tournertuile1 = new Button();
		tournertuile1.setGraphic(JohnSmith);
		tournertuile1.setContentDisplay(ContentDisplay.RIGHT);
		Button tournertuile2 = new Button();
		tournertuile2.setGraphic(JohnPizer);
		tournertuile1.setContentDisplay(ContentDisplay.RIGHT);
		//tournertuile.setGraphic(JosephLane);
		//tournertuile.setGraphic(Madame);
		tournertuile1.setContentDisplay(ContentDisplay.RIGHT);

		//Button addGirlfriendButton = new Button ("J'ai une nouvelle copine");
		//addGirlfriendButton.setGraphic(coeurImageView);
		//addGirlfriendButton.setContentDisplay(ContentDisplay.RIGHT);
		//addGirlfriendButton.setOnAction(new EventHandler<ActionEvent>() {​​​​​

		//@Override
		//public void handle(ActionEvent e) {​​​​​
		//totalGirlfriendsCount = totalGirlfriendsCount + 1;
		//statuslabel.setText("Nombre de copine actuel :" + totalGirlfriendsCount);
		//}​​​​​

		// }​​​​​);

		//Button removeGirlfriendButton = new Button ("J'ai perdu une copine");

		//removeGirlfriendButton.setOnAction(new EventHandler<ActionEvent>() {​​​​​

		//@Override
		//public void handle(ActionEvent e) {​​​​​
		//totalGirlfriendsCount = totalGirlfriendsCount - 1;
		//statuslabel.setText("Nombre de copine actuel :" + totalGirlfriendsCount);
		//}​​​​​
		//}​​​​​);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		root.getChildren().addAll(tournertuile1, tournertuile2);
		horizontal.getChildren().addAll(tournertuile1, tournertuile2);
		primaryStage.show();
	}
}