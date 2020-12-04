package src.Autres;

public class TableauTuiles {

	static Detectives Sherlock = new Detectives("Sherlock", 12);
	static Detectives Watson = new Detectives("Watson", 4);
	static Detectives Tobi = new Detectives("Tobi", 8);

	static District williamGull = new District("Suspect", (int) Math.random() * 4, "William Gull");
	static District sergentGoodley = new District("Suspect", (int) Math.random() * 4, "Sgt Goodley");
	static District missStealthy = new District("Suspect", (int) Math.random() * 4, "Miss Stealthy");
	static District madame = new District("Suspect", (int) Math.random() * 4, "Madame");
	static District josephLane = new District("Suspect", (int) Math.random() * 4, "Joseph Lane");
	static District johnSmith = new District("Suspect", (int) Math.random() * 4, "John Smith");
	static District johnPizer = new District("Suspect", (int) Math.random() * 4, "John Pizer");
	static District jeremyBert = new District("Suspect", (int) Math.random() * 4, "Jeremy Bert");
	static District inspectorLestrade = new District("Suspect", (int) Math.random() * 4, "Insp Lestrade");

	static private District[] initialBoard = { williamGull, sergentGoodley, missStealthy, madame, josephLane, johnSmith,
			johnPizer, jeremyBert, inspectorLestrade };
	public static District[][] board = { { williamGull, sergentGoodley, missStealthy },
			{ madame, josephLane, johnSmith }, { johnPizer, jeremyBert, inspectorLestrade } };;

	public TableauTuiles() {
	}

	public void lancement() {
		//tuilesRetournees(initialBoard);
		printBoard(initialiseBoard(shuffleArray(initialBoard)));
	};

	public static void tuilesRetournees(District[] board) {
		for (District i : board) {
			if (Math.random() > .5) {
				i.innocenter();
			}
		}
	}

	public static District[][] shuffleArray(District[] initialBoard) {
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

	public static District[][] initialiseBoard(District[][] board) {
		return board;
	}

	public static void printBoard(District[][] board) {
		String out = "\n";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String nom = board[i][j].toString();
				if (board[i][j].getFaceSuspect() == "Innocent") {
					nom = "  ";
				}
				switch (board[i][j].getMur()) {
					case 1:
						nom = " " + String.join("\u0305", nom.toString().split("", -1)) + " ";
						break;
					case 2:
						nom = " " + nom + "|";
						break;
					case 3:
						nom = " " + String.join("\u035f", nom.toString().split("", -1)) + " ";
						break;
					case 4:
						nom = "|" + nom + " ";
						break;
				}
				out += nom + " ";
			}
			out += "\n\n";
		}
		System.out.print(out);
	}
}
