package src.Autres;

import java.util.Scanner;

public class Jeu {
	private static Joueur mrJack = new Joueur("Mr Jack");
	private static Joueur detective = new Joueur("Detective");
	private static Joueur[] listeJoueurs = { mrJack, detective };
	static Alibi pileAlibi = new Alibi();

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
	}

	public static void initialisation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(listeJoueurs[0].getNom() + ", c'est ton tour. Es-tu prêt ?");
		scanner.nextLine();
		String nomMrJack = pileAlibi.retirerCarte()[0];
		System.out.println("Tu es " + nomMrJack);
		scanner.close();
	}
}
