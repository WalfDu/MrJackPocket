package Autres;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import InterfaceGraphique.InterfaceGraphique;
//import InterfaceGraphique.HelloApp;
import jetons.JetonAlibi;
import jetons.Jetons;
import tour.TourImpairs;
import tour.TourPairs;

public class Jeu {
	public static Jetons[] choixActions = TourImpairs.debut();						//Les 4 actions possibles au début sont définies à ce moment là
	public static District[] board = TableauTuiles.shuffleArray();
	public static Detectives[] listeDetectives = TableauTuiles.listeDetectives();	//Liste de détectives contenant entre autre leurs positions
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
		// Le nom de Mr. Jack est une string, d'où nécessité d'avoir un tableau de tuile et un tableau de String
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
		int abscisse = -1;			// Les abscisses et ordonnees servent à définir les abscisses et ordonnees de la
		int ordonnee = -1;			// tuiles du suspect que l'on va regarder
		int coordonnee = 3 * ordonnee + abscisse;
		District tuile = new District();
		Detectives detective;		// La variable détective intancie les 3 détectives les uns après les autres
		int detectivePosition;		// L'entier detectivePosition prend la valeur 0, 1, 2, ou 3 si le détective en
									// question est au Nord, à l'Est, au Sud, ou à l'Ouest
		int detectiveInc;			// L'entier detectiveInc prend la valeur 0, 1 ou 2 si le détective est à la 1e,
									// 2e ou 3e du côté où il est, en tournant dans le sens horaire
		for (int i = 0; i < listeDetectives.length; i++) {// Cette boucle permet traiter la visibilité des trois détectives un par  un
			detective = listeDetectives[i];
			detectivePosition = (int) ((detective.getPlace() - 1) % 12) / 3;		// detective.getPlace() renvoie un entier entre 1 et 24, pour les 24 positions
			detectiveInc = (int) (/* 10 **/ (detective.getPlace() - 1) % 12) % 3;	// possibles des détectives, avec le 1 étant la position à gauche au Nord, et en
																					// tournant dans le sens horaire, faisant ainsi 2 tours
			switch (detectivePosition) {	// On défini ici la position de la tuile devant le détective
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
											// car un détective peut voir 3 suspects au maximum
				coordonnee = 3 * ordonnee + abscisse;
				tuile = board[coordonnee];
				if (tuile.getMur() == detectivePosition) {// Si le mur est entre le détective et le suspect, on termine 
														  //  la boucle for, et on passe au détective suivant
					k = 3;
				} else if (tuile.getMur() % 2 == detectivePosition % 2) {// Si le mur est à l'opposé du détective, le suspect
					visibles.add(tuile);								 // est visible, mais pas celui d'après
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
		winner = 
			(sabliers + sabliersCaches >= 6 && innocents.size() == 8 && visiblesStr.contains(nomMrJack[0])) ? joueurActuel[0]	//On rappelle que 	
			: (innocents.size() >= 8) 																		? joueurActuel[0]	//joueurActuel[0] == "M. le détective"
			: ((sabliers + sabliersCaches >= 6) || i >= 8) 													? joueurActuel[1]	// et joueurActuel[1] == "Mr. Jack"
			: "nobody";
		System.out.println((!winner.equals("nobody")) ? "Le vainqueur est: " + winner : "");

		visibles.clear();
		visiblesStr.clear();
	}
}
