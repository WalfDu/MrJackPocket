package src.Autres;

import java.util.Scanner;

import src.jetons.JetonAlibi;
import src.jetons.Jetons;
import src.tour.TourImpairs;

public class Jeu {
	static Scanner scanner = new Scanner(System.in);
	/*private static Joueur mrJack = new Joueur("Mr. Jack");
	private static Joueur detective = new Joueur("Detective");
	private static Joueur[] listeJoueurs = { mrJack, detective };*/
	static JetonAlibi pileAlibi = new JetonAlibi("");
	static String[][] jetonsAction = { { "Echanger", "Tourner" }, { "Tobie", "Watson" }, { "Sherlock", "Alibi" },
			{ "Detective", "Tourner" } };
	static District[][] board = TableauTuiles.shuffleArray();
	static Detectives[] listeDetectives = TableauTuiles.listeDetectives();
	static int action;
	static String joueurActuel;

	/**
	private JetonsTemps jeton1;
	private JetonsTemps jeton2;
	private JetonsTemps jeton3;
	private JetonsTemps jeton4;
	private JetonsTemps jeton5;
	private JetonsTemps jeton6;
	private JetonsTemps jeton7;
	private JetonsTemps jeton8;*/
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
		}
	}

	public static void initialisation() {
		System.out.print("Mr Jack, nous allons vous réveler votre identité. Êtes-vous prêt ?");
		scanner.nextLine();
		String[] nomMrJack = pileAlibi.piocherCarte();
		System.out.print("Vous êtes " + nomMrJack[0] + "\nAppuyez sur <entrer> pour continuer");
		scanner.nextLine();
	}

	public static void tourImpairs() {
		Jetons[] choixActions = TourImpairs.debut();
		for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
			switch (nbActionsRestantes) {
				case 1, 4:
					joueurActuel = "M. le détective";
					break;
				case 2, 3:
					joueurActuel = "Mr. Jack";
					break;
			}
			System.out.println("\n" + joueurActuel + ", c'est votre tour, quelle action voulez-vous faire ?");
			for (int nbActions = 0; nbActions < nbActionsRestantes; nbActions++) {
				System.out.println(nbActions + 1 + ": " + choixActions[nbActions].getNom());
			}
			action = scanner.nextInt() - 1;
			choixActions[action].action(listeDetectives, board);
			Jetons temp = choixActions[action];
			choixActions[action] = choixActions[nbActionsRestantes - 1];
			choixActions[nbActionsRestantes - 1] = temp;
			TableauTuiles.printBoardConsole(board);
		}
	}

	public static void tourPairs() {
		Jetons[] choixActions = TourImpairs.debut();
		for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
			switch (nbActionsRestantes) {
				case 1, 4:
					joueurActuel = "Mr. Jack";
					break;
				case 2, 3:
					joueurActuel = "M. le détective";
					break;
			}
			System.out.println("\n" + joueurActuel + ", c'est votre tour, quelle action voulez-vous faire ?");
			for (int nbActions = 0; nbActions < nbActionsRestantes; nbActions++) {
				System.out.println(nbActions + 1 + ": " + choixActions[nbActions].getNom());
			}
			action = scanner.nextInt() - 1;
			choixActions[action].action(listeDetectives, board);
			Jetons temp = choixActions[action];
			choixActions[action] = choixActions[nbActionsRestantes - 1];
			choixActions[nbActionsRestantes - 1] = temp;
			TableauTuiles.printBoardConsole(board);
		}
	}
}
