package jetons;

public class TableauTuiles {

	private jetons.TuilesQuartier tab;
	static jetons.Detectives Sherlock = new jetons.Detectives("Sherlock", 12);
	static jetons.Detectives Watson = new jetons.Detectives("Watson", 4);
	static jetons.Detectives Tobi = new jetons.Detectives("Tobi", 8);

	static TuilesQuartier williamGull = new TuilesQuartier("Suspect", 1, "William Gull");
	static TuilesQuartier sergentGoodley = new TuilesQuartier("Suspect", 3, "Sergent Goodley");
	static TuilesQuartier missStealthy = new TuilesQuartier("Suspect", 4, "Miss Stealthy");
	static TuilesQuartier madame = new TuilesQuartier("Suspect", 2, "Madame I");
	static TuilesQuartier josephLane = new TuilesQuartier("Suspect", 1, "Joseph Lane");
	static TuilesQuartier johnSmith = new TuilesQuartier("Suspect", 3, "John Smith");
	static TuilesQuartier johnPizer = new TuilesQuartier("Suspect", 4, "John Pizer");
	static TuilesQuartier jeremyBert = new TuilesQuartier("Suspect", 2, "Jeremy Bert");
	static TuilesQuartier inspectorLestrade = new TuilesQuartier("Suspect", 1, "Inspector Lestrade");

	static private TuilesQuartier[] initialBoard = { williamGull, sergentGoodley, missStealthy, madame, josephLane,
			johnSmith, johnPizer, jeremyBert, inspectorLestrade };
	public static TuilesQuartier[][] board = { { williamGull, sergentGoodley, missStealthy },
			{ madame, josephLane, johnSmith }, { johnPizer, jeremyBert, inspectorLestrade } };;

	public TableauTuiles() {
	};

	public static void main(String[] arg) {
		tuilesRetournees(initialBoard);
		printBoard(initialiseBoard(shuffleArray(initialBoard)));
	}

	public static void tuilesRetournees(TuilesQuartier[] board) {
		for (TuilesQuartier i : board) {
			if (Math.random() > .5) {
				i.innocenter();
			}
		}
	}

	public static TuilesQuartier[][] shuffleArray(TuilesQuartier[] initialBoard) {
		for (int i = initialBoard.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			TuilesQuartier temp = initialBoard[i];
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

	public static TuilesQuartier[][] initialiseBoard(TuilesQuartier[][] board) {
		return board;
	}

	public static void printBoard(TuilesQuartier[][] board) {
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
						//nom = " " + nom + " ";
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
					default:
						nom = " " + String.join("\u0336", nom.toString().split("", -1)) + " ";
				}
				out += nom + " ";
			}
			out += "\n\n";
		}
		System.out.print(out);
	}

	public void setTab(TuilesQuartier newVar) {
		tab = newVar;
	}

	public TuilesQuartier getTab() {
		return tab;
	}
}
