package jetons;

public class TableauTuiles {

	private TuilesQuartier tab;
	static Detectives Sherlock = new Detectives("Sherlock", 12);
	static Detectives Watson = new Detectives("Watson", 4);
	static Detectives Tobi = new Detectives("Tobi", 8);

	static TuilesQuartier williamGull = new TuilesQuartier(false, 1, "William Gull");
	static TuilesQuartier sergentGoodley = new TuilesQuartier(false, 3, "Sergent Goodley");
	static TuilesQuartier missStealthy = new TuilesQuartier(false, 4, "Miss Stealthy");
	static TuilesQuartier madame = new TuilesQuartier(false, 2, "Madame I");
	static TuilesQuartier josephLane = new TuilesQuartier(false, 1, "Joseph Lane");
	static TuilesQuartier johnSmith = new TuilesQuartier(false, 3, "John Smith");
	static TuilesQuartier johnPizer = new TuilesQuartier(false, 4, "John Pizer");
	static TuilesQuartier jeremyBert = new TuilesQuartier(false, 2, "Jeremy Bert");
	static TuilesQuartier inspectorLestrade = new TuilesQuartier(false, 1, "Inspector Lestrade");

	static private TuilesQuartier[] initialBoard = { williamGull, sergentGoodley, missStealthy, madame, josephLane,
			johnSmith, johnPizer, jeremyBert, inspectorLestrade };
	public static TuilesQuartier[][] board = { { williamGull, sergentGoodley, missStealthy },
			{ madame, josephLane, johnSmith }, { johnPizer, jeremyBert, inspectorLestrade } };;

	public TableauTuiles() {
	};

	public static void main(String[] arg) {
		printBoard(initialiseBoard(shuffleArray(initialBoard)));
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
				switch (board[i][j].getMur()) {
					case 1:
						nom = " " + nom + " ";
						break;
					case 2:
						nom = " " + nom + "|";
						break;
					case 3:
						nom = " " + String.join("\u0332", board[i][j].toString().split("", -1)) + " ";
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

	public void setTab(TuilesQuartier newVar) {
		tab = newVar;
	}

	public TuilesQuartier getTab() {
		return tab;
	}
}
