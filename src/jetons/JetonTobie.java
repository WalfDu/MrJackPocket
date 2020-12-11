package jetons;

import Autres.Detectives;
import Autres.District;

import java.util.Scanner;

public class JetonTobie extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;

	public JetonTobie() {
	}

	public JetonTobie(String nom) {
		this.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[][] board, String joueurActuel) {
		System.out.println("Tobie peut se déplacer d'une ou deux cases. Entrez 1 ou 2 pour le nombre de pas.");
		int choix = scanner.nextInt();
		listeDetectives[2].setPlace(choix);
		System.out.println("Tobie a avancé de " + choix + " pas.");
	}

	@Override
	public String getNom() {
		return nom;
	}

}
