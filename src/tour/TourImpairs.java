package tour;

import jetons.JetonAlibi;
import jetons.JetonDetective;
import jetons.JetonEchanger;
import jetons.JetonSherlock;
import jetons.JetonToby;
import jetons.JetonTourner;
import jetons.JetonTourner2;
import jetons.JetonWatson;
import jetons.Jetons;

public class TourImpairs {
	static Jetons echanger = new JetonEchanger("Échanger les places de deux tuiles");
	static Jetons tourner = new JetonTourner("Faire tourner une tuile");
	static Jetons tourner2 = new JetonTourner2("Faire tourner une tuile");
	static Jetons deplacementToby = new JetonToby("Avancer Toby");
	static Jetons deplacementWatson = new JetonWatson("Avancer Watson");
	static Jetons deplacementSherlock = new JetonSherlock("Avancer Sherlock");
	public static Jetons actionAlibi = new JetonAlibi("Piocher une carte alibi");
	static Jetons troisDetectives = new JetonDetective("Avancer l'un des trois détectives");
	static Jetons[][] jetonsAction = jetonsAction();
	static Jetons[] actionsDuTour;

	// Constructors
	public TourImpairs() {
	};

	public static Jetons[][] jetonsAction() {
		Jetons[][] jetonsAction = { { echanger, tourner2 }, { deplacementToby, deplacementWatson }, { deplacementSherlock, actionAlibi },
				{ tourner, troisDetectives } };
		return jetonsAction;
	}

	public static Jetons[] debut() {
		actionsDuTour = new Jetons[4];
		for (int i = 0; i < actionsDuTour.length; i++) {
			actionsDuTour[i] = jetonsAction[i][(int) Math.round(Math.random())];
		}
		return actionsDuTour;
	}

}
