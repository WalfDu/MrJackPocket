//package src;

public class TableauTuiles {

	private src.District tab;
	static src.Detectives Sherlock = new src.Detectives("Sherlock", 12);
	static src.Detectives Watson = new src.Detectives("Watson", 4);
	static src.Detectives Tobi = new src.Detectives("Tobi", 8);

	static src.District williamGull = new src.District("Suspect", 1, "William Gull");
	static src.District sergentGoodley = new src.District("Suspect", 3, "Sergent Goodley");
	static src.District missStealthy = new src.District("Suspect", 4, "Miss Stealthy");
	static src.District madame = new src.District("Suspect", 2, "Madame I");
	static src.District josephLane = new src.District("Suspect", 1, "Joseph Lane");
	static src.District johnSmith = new src.District("Suspect", 3, "John Smith");
	static src.District johnPizer = new src.District("Suspect", 4, "John Pizer");
	static src.District jeremyBert = new src.District("Suspect", 2, "Jeremy Bert");
	static src.District inspectorLestrade = new src.District("Suspect", 1, "Inspector Lestrade");

	static private src.District[] initialBoard = { williamGull, sergentGoodley, missStealthy, madame, josephLane,
			johnSmith, johnPizer, jeremyBert, inspectorLestrade };
	public static src.District[][] board = { { williamGull, sergentGoodley, missStealthy },
			{ madame, josephLane, johnSmith }, { johnPizer, jeremyBert, inspectorLestrade } };;

	public TableauTuiles() {
	};

	public static void main(String[] arg) {
		tuilesRetournees(initialBoard);
		printBoard(initialiseBoard(shuffleArray(initialBoard)));
	}

	public static void tuilesRetournees(src.District[] board) {
		for (src.District i : board) {
			if (Math.random() > .5) {
				i.innocenter();
			}
		}
	}

	public static src.District[][] shuffleArray(src.District[] initialBoard) {
		for (int i = initialBoard.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			src.District temp = initialBoard[i];
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

	public static src.District[][] initialiseBoard(src.District[][] board) {
		return board;
	}

	public static void printBoard(src.District[][] board) {
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

	public void setTab(src.District newVar) {
		tab = newVar;
	}

	public src.District getTab() {
		return tab;
	}
}
