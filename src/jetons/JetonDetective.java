package jetons;

import java.util.Scanner;

import Autres.Detectives;
import Autres.District;

public class JetonDetective extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;
	int choix;

	public JetonDetective() {
	}

	public JetonDetective(String nom) {
		this.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[] board, String joueurActuel) {
		switch (joueurActuel) {
			case "M. le détective":
				System.out.println(
						"Quel détective souhaitez-vous faire avancer d'une case ?\n1: Sherlock\n2: Watson\n3: Toby");
				choix = scanner.nextInt() - 1;
				listeDetectives[choix].setPlace(1);
				break;
			case "Mr. Jack":
				System.out.println(
						"Quel détective souhaitez-vous faire avancer d'une case ?\n0: Aucun détective\n1: Sherlock\n2: Watson\n3: Toby");
				choix = scanner.nextInt() - 1;
				if (choix > -1) {
					listeDetectives[choix].setPlace(1);
				}
				break;
		}
	}

	@Override
	public String getNom() {
		return nom;
	}
}
