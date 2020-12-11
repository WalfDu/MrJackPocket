package Autres;

import jetons.JetonAlibi;
import jetons.Jetons;
import tour.TourImpairs;
import tour.TourPairs;

import java.util.ArrayDeque;
import java.util.Scanner;


public class Jeu {
    private static Jetons[] choixActions = TourImpairs.debut();
    static Scanner scanner = new Scanner(System.in);
    /*private static Joueur mrJack = new Joueur("Mr. Jack");
    private static Joueur detective = new Joueur("Detective");
    private static Joueur[] listeJoueurs = { mrJack, detective };*/
    static JetonAlibi pileAlibi = new JetonAlibi("test");
    static String[][] jetonsAction = {{"Echanger", "Tourner"}, {"Tobie", "Watson"}, {"Sherlock", "Alibi"},
            {"Detective", "Tourner"}};
    static District[][] board = TableauTuiles.shuffleArray();
    static Detectives[] listeDetectives = TableauTuiles.listeDetectives();
    static int action;
    static String joueurActuel;
    static ArrayDeque<String> visibles = new ArrayDeque<>();
    static ArrayDeque<String> innocents = new ArrayDeque<>();

    private static TableauTuiles plateau = new TableauTuiles();

    public static void main(String[] args) {
        initialisation();
        plateau.lancement();
		/*for (int i = 1; i <= 8; i++) {
			switch (i % 2) {
				case 1:
					tourImpairs();
					break;
				case 0:
					tourPairs();
					break;
			}
			finDuTour();
		}*/
        estVisible(listeDetectives);
        for (String i : innocents) {
            System.out.println(i);
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
        choixActions = TourImpairs.debut();
        for (int nbActionsRestantes = 4; nbActionsRestantes > 0; nbActionsRestantes--) {
            switch (nbActionsRestantes) {
                case 1:
                case 4:
                    joueurActuel = "M. le détective";
                    break;
                case 2:
                case 3:
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
                case 1:
                    joueurActuel = "Mr. Jack";
                    break;
                case 4:
                    joueurActuel = "Mr. Jack";
                    break;
                case 2:
                    joueurActuel = "M. le détective";
                    break;
                case 3:
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
        System.out.println("Mr. Jack, est-ce que l'un des détective vous voit ?\n1: Oui\n2: Non");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
            case 2:
                break;
        }
    }

    public static void estVisible(Detectives[] listeDetectives) {
        int abscisse = -1;
        int ordonnee = -1;
        District tuile = new District();
        Detectives detective;
        int detectivePosition;
        int detectiveInc;
        for (int i = 0; i < listeDetectives.length; i++) {
            detective = listeDetectives[i];
            detectivePosition = (int) (detective.getPlace() - 1) / 3;
            detectiveInc = (int) 10 * (detective.getPlace() - 1) % 3;
            System.out.println(detectivePosition + " " + detectiveInc);
            //switch(detectivePosition){
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
				for (int k = 0; k < 3; k++) {
                    tuile = board[ordonnee][abscisse];
                    if (tuile.getMur() == detectivePosition) {
						k = 3;
					} else if(tuile.getMur() % 2 == detectivePosition % 2){
                    	innocents.add(tuile.getNomSuspect());
                    	k = 3;
                    } else if (tuile.getMur() != detectivePosition) {
                        innocents.add(tuile.getNomSuspect());
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
}
