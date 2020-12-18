package Autres;

public class TableauTuiles {

	static Detectives sherlock = new Detectives("Sherlock", 12);
	static Detectives watson = new Detectives("Watson", 4);
	static Detectives tobie = new Detectives("Tobi", 8);

	static Detectives[] listeDetectives = listeDetectives();

	static District williamGull = new District("Suspect", (int) (Math.random() * 3), "William Gull");
	static District sergentGoodley = new District("Suspect", (int) (Math.random() * 3), "Sgt Goodley");
	static District missStealthy = new District("Suspect", (int) (Math.random() * 3), "Miss Stealthy");
	static District madame = new District("Suspect", (int) (Math.random() * 3), "Madame");
	static District josephLane = new District("Suspect", (int) (Math.random() * 3), "Joseph Lane");
	static District johnSmith = new District("Suspect", (int) (Math.random() * 3), "John Smith");
	static District johnPizer = new District("Suspect", (int) (Math.random() * 3), "John Pizer");
	static District jeremyBert = new District("Suspect", (int) (Math.random() * 3), "Jeremy Bert");
	static District inspectorLestrade = new District("Suspect", (int) (Math.random() * 3), "Insp Lestrade");

	static private District[] initialBoard = { williamGull, sergentGoodley, missStealthy, madame, josephLane, johnSmith,
			johnPizer, jeremyBert, inspectorLestrade };
	public static District[][] board = new District[3][3];

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

	public static District[][] shuffleArray() {
		for (int i = initialBoard.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			District temp = initialBoard[i];
			initialBoard[i] = initialBoard[j];
			initialBoard[j] = temp;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = initialBoard[i * 3 + j];
			}
		}
		return board;
	}

	public static Detectives[] listeDetectives() {
		Detectives[] listeDetectives = { sherlock, watson, tobie };
		return listeDetectives;
	}

	public static void printBoardConsole(District[][] board) {
		String out = "\n";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String nom = board[i][j].toString();
				if (board[i][j].getFaceSuspect() == "Innocent") {
					nom = "  ";
				}
				switch (board[i][j].getMur()) {
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
				}
				out += nom + " ";
			}
			out += "\n\n";
		}
		System.out.print(out);
		for (Detectives i : listeDetectives) {
			System.out.println(i.getNom() + " est positioné en " + i.getPlace());
		}
	}
}
