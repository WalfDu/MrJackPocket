package src.jetons;

import java.util.Scanner;

import src.Autres.Detectives;
import src.Autres.District;

public class JetonDetective extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;

	public JetonDetective() {
	}

	public JetonDetective(String nom) {
		this.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[][] board) {
		System.out
				.println("Quel détective souhaitez-vous faire avancer d'une case ?\n1: Sherlock\n2: Watson\n3: Tobie");
		int choix = scanner.nextInt() - 1;
		listeDetectives[choix].setPlace(1);
	}

	@Override
	public String getNom() {
		return nom;
	}
}
