package src.jetons;

import java.util.ArrayDeque;
import java.util.Scanner;

import src.Autres.Detectives;
import src.Autres.District;

public class JetonAlibi extends Jetons {
	Scanner scanner = new Scanner(System.in);
	String nom;
	ArrayDeque<String> pileAlibi = new ArrayDeque<>();
	static String[] debutPile = { "William Gull 1", "Sgt Goodley 0", "Madame 2", "Joseph Lane 1", "John Smith 1",
			"John Pizer 1", "Inspecteur Lestrade 0", "Jeremy Bert 1", "Miss Stealthy 1" };

	public JetonAlibi() {
	}

	public JetonAlibi(String nom) {
		shuffleArray(debutPile);
		this.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[][] board) {
		String[] carte = piocherCarte();
		String out = "Vous avez pioché la carte " + carte[0] + ", vous ";
		switch (Integer.parseInt(carte[1])) {
			case 0:
				out += "ne gagnez aucun sablier";
				break;
			case 1:
				out += "gagnez 1 sablier";
				break;
			case 2:
				out += "gagnez 2 sabliers";
				break;
		}
		System.out.println(out);
	}

	@Override
	public String getNom() {
		return nom;
	}

	public void shuffleArray(String[] initialBoard) {
		for (int i = initialBoard.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			String temp = initialBoard[i];
			initialBoard[i] = initialBoard[j];
			initialBoard[j] = temp;
		}
		for (String i : initialBoard) {
			this.pileAlibi.addLast(i);
		}
	}

	public String[] piocherCarte() {
		if (!this.pileAlibi.isEmpty()) {
			String carte = this.pileAlibi.pollFirst();
			String nomAlibi = carte.substring(0, carte.length() - 1);
			String sablier = carte.substring(carte.length() - 1, carte.length());
			String[] out = { nomAlibi, sablier };
			return out;
		}
		String[] out = { "La pile est vide", "-1" };
		return out;
	}

	public int getSize() {
		return this.pileAlibi.size();
	}

	public String sourceImage(String nomSuspect) {
		String sourceImage = "../../images/alibis/";
		String[] temp = nomSuspect.substring(0, nomSuspect.length() - 4).split(" ");
		for (String i : temp) {
			sourceImage += i;
		}
		sourceImage += "-alibi.png";
		return sourceImage;
	}

}
