package src.Autres;

import java.util.ArrayDeque;

public class Alibi {

	ArrayDeque<String> pileAlibi = new ArrayDeque<>();
	static String[] debutPile = { "William Gull (1)", "Sgt Goodley (0)", "Madame (2)", "Joseph Lane (1)",
			"John Smith (1)", "John Pizer (1)", "Inspecteur Lestrade (0)", "Jeremy Bert (1)", "Miss Stealthy (1)" };

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

	public String retirerCarte() {
		if (!this.pileAlibi.isEmpty()) {
			String carte = this.pileAlibi.pollFirst();
			return carte;
		}
		return "La pileAlibi est vide";
	}

	public int getSize() {
		return this.pileAlibi.size();
	}
}
