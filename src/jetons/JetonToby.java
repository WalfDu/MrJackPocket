package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;

public class JetonToby extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;

	public JetonToby() {
	}

	public JetonToby(String nom) {
		this.nom = nom;
	}

	public void action(Detectives[] listeDetectives, District[] board, String joueurActuel) {
		System.out.println("Toby peut se deplacer d'une ou deux cases. Entrez 1 ou 2 pour le nombre de pas.");
		int choix = scanner.nextInt();
		listeDetectives[2].setPlace(choix);
		System.out.println("Toby a avance de " + choix + " pas.");
	}

	public String getNom() {
		return nom;
	}
}
