package src.Autres;

import java.util.ArrayDeque;
import java.util.Scanner;

import src.jetons.JetonAlibi;
import src.jetons.Jetons;
import src.tour.TourImpairs;
import src.tour.TourPairs;

public class Jeu {
	static Scanner scanner = new Scanner(System.in);
	static JetonAlibi pileAlibi = new JetonAlibi("test");
	static District[][] board = TableauTuiles.shuffleArray();
	static Detectives[] listeDetectives = TableauTuiles.listeDetectives();
	static int action;
	static String joueurActuel;
	static ArrayDeque<String> visibles = new ArrayDeque<>();
	static ArrayDeque<String> innocents = new ArrayDeque<>();
	static Jetons[] choixActions = TourImpairs.debut();
	private static TableauTuiles plateau = new TableauTuiles();

	public static void main(String[] args) {
		initialisation();
		plateau.lancement();
		for (int i = 1; i <= 8; i++) {
			switch (i % 2) {
				case 1:
					tourImpairs();
					break;
				case 0:
					tourPairs();
					break;
			}
			finDuTour();
		}
	}

	public static void initialisation() {
		System.out.print("Mr. Jack, nous allons vous réveler votre identité. Êtes-vous prêt ?");
		scanner.nextLine();
		String[] nomMrJack = pileAlibi.piocherCarte();
		System.out.print("Vous êtes " + nomMrJack[0] + "\nAppuyez sur <entrer> pour continuer");
		scanner.nextLine();
	}

	public static void tourImpairs() {
		choixActions = TourImpairs.debut();
		for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
			switch (nbActionsRestantes) {
				case 1, 4:
					joueurActuel = "M. le détective";
					break;
				case 2, 3:
					joueurActuel = "Mr. Jack";
					break;
			}
			finAction(choixActions, nbActionsRestantes);
		}
	}

	public static void tourPairs() {
		choixActions = TourPairs.debut(choixActions);
		for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
			switch (nbActionsRestantes) {
				case 1, 4:
					joueurActuel = "Mr. Jack";
					break;
				case 2, 3:
					joueurActuel = "M. le détective";
					break;
			}
			finAction(choixActions, nbActionsRestantes);
		}
	}

	public static void finAction(Jetons[] choixActions, int nbActionsRestantes) {
		System.out.println("\n" + joueurActuel + ", c'est votre tour, quelle action voulez-vous faire ?");
		for (int nbActions = 0; nbActions < nbActionsRestantes; nbActions++) {
			System.out.println(nbActions + 1 + ": " + choixActions[nbActions].getNom());
		}
		action = scanner.nextInt() - 1;
		choixActions[action].action(listeDetectives, board, joueurActuel);
		Jetons temp = choixActions[action];
		choixActions[action] = choixActions[nbActionsRestantes - 1];
		choixActions[nbActionsRestantes - 1] = temp;
		TableauTuiles.printBoardConsole(board);
	}

	public static void finDuTour() {
		System.out.println("Mr. Jack, est-ce que l'un des détectives vous voit ?\n1: Oui\n2: Non");
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				break;
			case 2:
				break;
		}
	}

	public static void estVisible() {

	}
}
