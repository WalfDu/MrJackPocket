package Autres;

import java.util.ArrayDeque;

public class Alibi {

	ArrayDeque<String> pileAlibi = new ArrayDeque<>();
	static String[] debutPile = { "William Gull 1", "Sgt Goodley 0", "Madame 2", "Joseph Lane 1", "John Smith 1",
			"John Pizer 1", "Inspecteur Lestrade 0", "Jeremy Bert 1", "Miss Stealthy 1" };

	// Constructor
	public Alibi() {
		shuffleArray(debutPile);
	};

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
