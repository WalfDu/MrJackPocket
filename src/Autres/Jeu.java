package Autres;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import InterfaceGraphique.InterfaceGraphique;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import InterfaceGraphique.HelloApp;
import jetons.JetonAlibi;
import jetons.Jetons;
import tour.TourImpairs;
import tour.TourPairs;

public class Jeu {
	public static Jetons[] choixActions = TourImpairs.debut();						//Les 4 actions possibles au debut sont definies à ce moment là
	public static District[] board = TableauTuiles.shuffleArray();
	public static Detectives[] listeDetectives = TableauTuiles.listeDetectives();	//Liste de detectives contenant entre autre leurs positions
	public static String[] joueurActuel = { "M. le detective", "Mr. Jack" };
	public static int jActuel = -1;
	private static ArrayDeque<District> visibles = new ArrayDeque<>();
	private static ArrayDeque<String> visiblesStr = new ArrayDeque<>();
	static ArrayDeque<String> innocents = new ArrayDeque<>();
	public static String[] nomMrJack = ((JetonAlibi) TourImpairs.actionAlibi).piocherCarte(); //initialisation de Mr. Jack
	public static int sabliers = 0;
	public static int sabliersCaches = 0;
	public static String winner = "nobody";
	public static int tourEnCours = 1;
	public static ArrayDeque<Jetons> actionsFaites = new ArrayDeque<>();

	public static void finDuTour() {
		estVisible();
		// Le nom de Mr. Jack est une string, d'ou necessite d'avoir un tableau de tuile et un tableau de String
		for (District i : visibles) {
			visiblesStr.add(i.getNomSuspect());
		}
		if (visiblesStr.contains(nomMrJack[0])) {
			for (int i = 0; i < 9; i++) {
				if (!visibles.contains(board[i])) {
					board[i].innocenter(i);
				}
			}
		} else {
			for (int i = 0; i < 9; i++) {
				if (visibles.contains(board[i])) {
					board[i].innocenter(i);
				}
			}
			sabliers++;
		}
	}

	public static void estVisible() {
		int abscisse = -1;			// Les abscisses et ordonnees servent à definir les abscisses et ordonnees de la
		int ordonnee = -1;			// tuiles du suspect que l'on va regarder
		int coordonnee = 3 * ordonnee + abscisse;
		District tuile = new District();
		Detectives detective;		// La variable detective intancie les 3 detectives les uns apres les autres
		int detectivePosition;		// L'entier detectivePosition prend la valeur 0, 1,2, ou3si le detective en
									// question est au Nord, à l'Est, au Sud, ou a l'Ouest
		int detectiveInc;			// L'entier detectiveInc prend la valeur 0, 1 ou 2 si le detective est a la 1e,
									// 2e ou 3e du cote ou il est, en tournant dans le sens horaire
		for (int i = 0; i < listeDetectives.length; i++) {// Cette boucle permet traiter la visibilite des trois detectives un par  un
			detective = listeDetectives[i];
			detectivePosition = (int) ((detective.getPlace() - 1) % 12) / 3;		// detective.getPlace() renvoie un entier entre 1 et 24, pour les 24 positions
			detectiveInc = (int) (/* 10 **/ (detective.getPlace() - 1) % 12) % 3;	// possibles des detectives, avec le 1 etant la position à gauche au Nord, et en
																					// tournant dans le sens horaire, faisant ainsi 2 tours
			switch (detectivePosition) {	// On defini ici la position de la tuile devant le detective
			case 0:
				abscisse = detectiveInc;
				ordonnee = 0;
				break;
			case 1:
				ordonnee = detectiveInc;
				abscisse = 2;
				break;
			case 2:
				ordonnee = 2;
				abscisse = 2 - detectiveInc;
				break;
			case 3:
				abscisse = 0;
				ordonnee = 2 - detectiveInc;
			}
			for (int k = 0; k < 3; k++) {	// On effectue 3 fois les instructions suivantes,
											// car un detective peut voir 3 suspects au maximum
				coordonnee = 3 * ordonnee + abscisse;
				tuile = board[coordonnee];
				if (tuile.getMur() == detectivePosition) {// Si le mur est entre le detective et le suspect, on termine 
														  //  la boucle for, et on passe au detective suivant
					k = 3;
				} else if (tuile.getMur() % 2 == detectivePosition % 2) {// Si le mur est à l'oppose du detective, le suspect
					visibles.add(tuile);								 // est visible, mais pas celui d'apres
					k = 3;
				} else {					// Sinon, le suspect est visible, et on continue en regardant
					visibles.add(tuile);	// la tuile du board suivante
					
					switch (detectivePosition) {
					case 0:
						ordonnee++;
						break;
					case 1:
						abscisse--;
						break;
					case 2:
						ordonnee--;
						break;
					case 3:
						abscisse++;
						break;
					}
				}
			}
		}
	}

	public static void finPartie(int i) {
		if (sabliers + sabliersCaches >= 6 && innocents.size() == 8 && visiblesStr.contains(nomMrJack[0])) {
			winner = joueurActuel[0];
		} else if (innocents.size() >= 8) {
			winner = joueurActuel[0];
		} else if ((sabliers + sabliersCaches >= 6) || i >= 8) {
			winner = joueurActuel[1];
		}
		/*winner = 
			(sabliers + sabliersCaches >= 6 && innocents.size() == 8 && visiblesStr.contains(nomMrJack[0])) ? joueurActuel[0]	//On rappelle que 	
			: (innocents.size() >= 8) ? joueurActuel[0]	//joueurActuel[0] == "M. le detective"
			: ((sabliers + sabliersCaches >= 6) || i >= 8) ? joueurActuel[1]	// et joueurActuel[1] == "Mr. Jack"
			: "nobody";*/
		if (!winner.equals("nobody")){
			String[] temp = winner.split(" ");
			String victoireStr = "file:images/Victoire";
			for (String k : temp) {
				victoireStr += "-" + k;
			}
			victoireStr += ".png";
			Image victoire = new Image(victoireStr, 415, 646, true, false);
			ImageView victoireView = new ImageView(victoire);
			InterfaceGraphique.root.getChildren().clear();
			InterfaceGraphique.column.setPercentWidth(20);
			InterfaceGraphique.root.getColumnConstraints().add(InterfaceGraphique.column);
			InterfaceGraphique.root.add(victoireView, 1, 1);
		}
		visibles.clear();
		visiblesStr.clear();
	}
}
