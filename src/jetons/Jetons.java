package jetons;

import Autres.Detectives;
import Autres.District;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Jetons {
	public static Image im;
	public static ImageView imView;
	public static String nom;
	boolean joue = false;

	abstract public String getNom();

	abstract public void action(Detectives[] listeDetectives, District[] board, int jActuel);

	abstract public ImageView getImView();
}
