package Autres;

import java.util.ArrayDeque;
import java.util.Scanner;

import InterfaceGraphique.InterfaceGraphique;
//import InterfaceGraphique.HelloApp;
import jetons.JetonAlibi;
import jetons.Jetons;
import tour.TourImpairs;
import tour.TourPairs;

public class Jeu {
	public static Jetons[] choixActions = TourImpairs.debut();
	//private static Scanner scanner = new Scanner(System.in);
	// public static JetonAlibi pileAlibi = new JetonAlibi("test");
	public static District[] board = TableauTuiles.shuffleArray();
	public static Detectives[] listeDetectives = TableauTuiles.listeDetectives();
	private static String actionStr;
	private static int action;
	public static String[] joueurActuel = {"M. le detective" ,"Mr. Jack"};
	public static int jActuel = 1;
	private static ArrayDeque<District> visibles = new ArrayDeque<>();
	private static ArrayDeque<String> visiblesStr = new ArrayDeque<>();
	static ArrayDeque<String> innocents = new ArrayDeque<>();
	public static TableauTuiles plateau = new TableauTuiles();
	public static String[] nomMrJack;
	public static int sabliers = 0;
	public static int sabliersCaches = 0;
	public static String winner;
	public int tourEnCours = -1;
	public Jetons actionEnCours;
	public int nbActionsRestantes = -1;
	// private static HelloApp interfaceG = new HelloApp();

	public static void main(String string) {
		// interfaceG.printBoardInterface();
		// Scene scene = new Scene(root);
		// primaryStage.setScene(scene);
		// primaryStage.show();
		/*
		 * initialisation(); plateau.lancement(); for (int i = 1; i <= 8; i++) { switch
		 * (i % 2) { case 1: tourImpairs(); break; case 0: tourPairs(); break; }
		 * finDuTour(); finPartie(i); }
		 */
	}

	public static void initialisation() {
		System.out.print("Mr Jack, nous allons vous reveler votre identité. Etes-vous prêt ?\n");
		nomMrJack = ((JetonAlibi) TourImpairs.actionAlibi).piocherCarte();
		System.out.println("Vous êtes " + nomMrJack[0] + "\nAppuyez sur <entrer> pour continuer");
		// scanner.nextLine();
	}

	public static void tourImpairs() {
		choixActions = TourImpairs.debut();
		for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
			switch (nbActionsRestantes) {
			case 1:
			case 4:
				jActuel = 0;
				break;
			case 2:
			case 3:
				jActuel = 1;
				break;
			}
			finAction(choixActions, nbActionsRestantes);
		}
	}

	public static void tourPairs() {
		choixActions = TourPairs.debut(choixActions);
		for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
			switch (nbActionsRestantes) {
			case 1:
			case 4:
				jActuel = 1;
				break;
			case 2:
			case 3:
				jActuel = 0;
				break;
			}
			finAction(choixActions, nbActionsRestantes);
		}
	}

	public static void finAction(Jetons[] choixActions, int nbActionsRestantes) {
		System.out.println("\n" + joueurActuel + ", c'est votre tour, quelle action voulez-vous faire ?");
		for (int nbActions = 0; nbActions < nbActionsRestantes; nbActions++) {
			InterfaceGraphique.action[nbActions].setGraphic((choixActions[nbActions]).getImView());
			System.out.println(nbActions + 1 + ": " + choixActions[nbActions].getNom());
		}
		//actionStr = scanner.next().substring(1);
		//action = Integer.parseInt(actionStr) + 1;
		InterfaceGraphique.idEnCours = null;
		while (InterfaceGraphique.idEnCours == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		actionStr = InterfaceGraphique.idEnCours.substring(1);
		action = Integer.parseInt(actionStr) + 1;
		choixActions[action].action(listeDetectives, board, jActuel);
		Jetons temp = choixActions[action];
		choixActions[action] = choixActions[nbActionsRestantes - 1];
		choixActions[nbActionsRestantes - 1] = temp;
	}

	public static void finDuTour() {
		estVisible(listeDetectives);
		for (District i : visibles) {
			visiblesStr.add(i.getNomSuspect());
		}
		if (visiblesStr.contains(nomMrJack[0])) {
			for (int i=0; i<9; i++){
				if (!visibles.contains(board[i])) {
					board[i].innocenter(i);
				}
			}
		} else {
			for (int i=0; i<9; i++) {
				board[i].innocenter(i);
				sabliers++;
			}
		}
		TableauTuiles.printBoardConsole(board);
		System.out.print("\nLes personnes suivantes sont visibles ");
		if (visiblesStr.contains(nomMrJack[0])) {
			System.out.println("dont Mr. Jack:");
		} else {
			System.out.println("mais pas Mr. Jack");
		}
		for (District i : visibles) {
			System.out.println(i.getNomSuspect());
		}
		visibles.clear();
		visiblesStr.clear();
	}

	public static void estVisible(Detectives[] listeDetectives) {
		// Les abscisses et ordonnees servent à définir les abscisses et ordonnees de la
		// tuiles du suspect que l'on va regarder
		int abscisse = -1;
		int ordonnee = -1;
		int coordonnee = 3 * abscisse + ordonnee;
		District tuile = new District();
		// La variable détective intancie les 3 détectives les uns après les autres
		Detectives detective;
		// L'entier detectivePosition prend la valeur 0, 1, 2, ou 3 si le détective en
		// question est au Nord, à l'Est, au Sud, ou à l'Ouest
		int detectivePosition;
		// L'entier detectiveInc prend la valeur 0, 1 ou 2 si le détective est à la 1e,
		// 2e ou 3e du côté où il est, en tournant dans le sens des aiguilles d'une
		// montre
		int detectiveInc;
		// La boucle suivante permet traiter la visibilité des trois détectives un par
		// un
		for (int i = 0; i < listeDetectives.length; i++) {
			detective = listeDetectives[i];
			// detective.getPlace() renvoie un entier entre 1 et 12, pour les 12 positions
			// possibles des détectives, avec le 1 étant la position à gauche au Nord, et en
			// tournant dans le sens des aiguilles d'une montre
			detectivePosition = (int) (detective.getPlace() - 1) / 3;
			detectiveInc = (int) 10 * (detective.getPlace() - 1) % 3;
			// On défini ici la position de la tuile devant le détective
			switch (detectivePosition) {
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
			coordonnee = 3 * abscisse + ordonnee;
			// On effectue 3 fois les instructions suivantes, car un détective peut voir 3
			// suspects au maximum
			for (int k = 0; k < 3; k++) {
				tuile = board[coordonnee];
				if (tuile.getMur() == detectivePosition) {
					// Si le mur est entre le détective et le suspect, on termine la boucle for, et
					// on passe au détective suivant
					k = 3;
				} else if (tuile.getMur() % 2 == detectivePosition % 2) {
					// Si le mur est à l'opposé du détective, le suspect est visible, mais pas celui
					// d'après
					visibles.add(tuile);
					k = 3;
				} else if (tuile.getMur() != detectivePosition) {
					// Sinon, le suspect est visible, et on continue en regardant la tuile du board
					// suivante
					visibles.add(tuile);
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
		if (sabliers + sabliersCaches >= 8) {
			i = 9;
			winner = "Mr. Jack";
		}
		if (i == 8) {
			winner = "Mr. Jack";
		}
		if (innocents.size() >= 8) {
			winner = "M. le detective";
		}
	}
}
