package jetons;

import Autres.Detectives;
import Autres.District;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Jetons {
	//Cette classe permet de creer le tableau de Jetons choixAction[], et donc de faire choixAction[i].getNom(), .action(...)
	//ou .getImView(), quel que soit le jeton en question.
	public static Image im;
	public static ImageView imView;
	public static String nom;
	boolean joue = false;

	abstract public String getNom();

	abstract public void action(Detectives[] listeDetectives, District[] board, int jActuel);

	abstract public ImageView getImView();
}
