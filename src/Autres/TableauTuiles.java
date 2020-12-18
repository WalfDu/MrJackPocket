package Autres;

public class TableauTuiles {

	static Detectives sherlock = new Detectives("Sherlock", 12);
	static Detectives watson = new Detectives("Watson", 4);
	static Detectives toby = new Detectives("Toby", 8);

	static Detectives[] listeDetectives = listeDetectives();

	static District williamGull = new District("Suspect", (int) (Math.random() * 3), "William Gull");
	static District sergentGoodley = new District("Suspect", (int) (Math.random() * 3), "Sgt Goodley");
	static District missStealthy = new District("Suspect", (int) (Math.random() * 3), "Miss Stealthy");
	static District madame = new District("Suspect", (int) (Math.random() * 3), "Madame");
	static District josephLane = new District("Suspect", (int) (Math.random() * 3), "Joseph Lane");
	static District johnSmith = new District("Suspect", (int) (Math.random() * 3), "John Smith");
	static District johnPizer = new District("Suspect", (int) (Math.random() * 3), "John Pizer");
	static District jeremyBert = new District("Suspect", (int) (Math.random() * 3), "Jeremy Bert");
	static District inspectorLestrade = new District("Suspect", (int) (Math.random() * 3), "Inspecteur Lestrade");

	static private District[] initialBoard = { williamGull, sergentGoodley, missStealthy, madame, josephLane, johnSmith,
			johnPizer, jeremyBert, inspectorLestrade };
	public static District[] board = new District[9];

	public TableauTuiles() {
	}

	public void lancement() {
		//tuilesRetournees(initialBoard);
		printBoardConsole(shuffleArray());
	};

	public static void tuilesRetournees(District[] board) {
		for (District i : board) {
			if (Math.random() > .5) {
				i.innocenter();
			}
		}
	}

	public static District[] shuffleArray() {
		for (int i = initialBoard.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			District temp = initialBoard[i];
			initialBoard[i] = initialBoard[j];
			initialBoard[j] = temp;
		}
		while (board[0].getMur() != 3) {
			board[0].setMur();
		}
		while (board[2].getMur() != 1) {
			board[2].setMur();
		}
		while (board[8].getMur() != 2) {
			board[8].setMur();
		}
		return board;
	}

	public static Detectives[] listeDetectives() {
		Detectives[] listeDetectives = { sherlock, watson, toby };
		return listeDetectives;
	}

	public static void printBoardConsole(District[] board) {
		String out = "\n";
		for (int i = 0; i < board.length; i++) {
			String nom = board[i].toString();
			if (board[i].getFaceSuspect() == "Innocent") {
				nom = "  ";
			}
			switch (board[i].getMur()) {
				case 0:
					nom = " " + String.join("\u0305", nom.toString().split("", -1)) + " ";
					break;
				case 1:
					nom = " " + nom + "|";
					break;
				case 2:
					nom = " " + String.join("\u035f", nom.toString().split("", -1)) + " ";
					break;
				case 3:
					nom = "|" + nom + " ";
					break;
				case -1:
					nom = "  " + nom + " ";
					break;
			}
			out += nom + " ";
			out += "\n\n";
		}
		System.out.print(out);
		for (Detectives i : listeDetectives) {
			System.out.print(i.getNom() + ": " + i.getPlace() + ",     ");
		}
		System.out.println();
	}
}
