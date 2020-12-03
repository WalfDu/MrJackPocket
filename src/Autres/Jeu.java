package src.Autres;

import java.util.Scanner;

public class Jeu {
	/*private static Joueur mrJack = new Joueur("MrJack");
	private static Joueur detective = new Joueur("Detective");
	private static Joueur[] listeJoueurs = { mrJack, detective };
	*/
	static Alibi pileAlibi = new Alibi();

	/**
	private JetonsTemps jeton1;
	private JetonsTemps jeton2;
	private JetonsTemps jeton3;
	private JetonsTemps jeton4;
	private JetonsTemps jeton5;
	private JetonsTemps jeton6;
	private JetonsTemps jeton7;
	private JetonsTemps jeton8;
	private TableauTuiles plateau;
	*/

	public static void main(String[] args) {
		initialisation();
	}

	public static void initialisation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("C'est le tour de Mr Jack. Es-tu prêt ?");
		scanner.nextLine();
		String identiteMrJack = pileAlibi.retirerCarte();
		String nomAlibi = identiteMrJack.substring(0, identiteMrJack.length() - 4);
		System.out.println("Tu est: " + nomAlibi);
		scanner.close();
	}
}
