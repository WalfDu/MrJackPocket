package src.tour;

import src.jetons.JetonAlibi;
import src.jetons.JetonDetective;
import src.jetons.JetonEchanger;
import src.jetons.JetonSherlock;
import src.jetons.JetonTobie;
import src.jetons.JetonTourner;
import src.jetons.JetonWatson;
import src.jetons.Jetons;

public class TourImpairs {
	static Jetons echanger = new JetonEchanger("Échanger les places de deux tuiles");
	static Jetons tourner = new JetonTourner("Faire tourner une tuile");
	static Jetons tourner2 = new JetonTourner("Faire tourner une tuile");
	static Jetons tobie = new JetonTobie("Avancer Tobie");
	static Jetons watson = new JetonWatson("Avancer Watson");
	static Jetons sherlock = new JetonSherlock("Avancer Sherlock");
	static Jetons alibi = new JetonAlibi("Piocher une carte alibi");
	static Jetons detective = new JetonDetective("Avancer l'un des trois détectives");
	static Jetons[][] jetonsAction = jetonsAction();

	// Constructors
	public TourImpairs() {
	};

	public static Jetons[][] jetonsAction() {
		Jetons[][] jetonsAction = { { echanger, tourner2 }, { tobie, watson }, { sherlock, alibi },
				{ tourner, detective } };
		return jetonsAction;
	}

	public static Jetons[] debut() {
		Jetons[] actionsDuTour = new Jetons[4];
		for (int i = 0; i < actionsDuTour.length; i++) {
			actionsDuTour[i] = jetonsAction[i][(int) Math.round(Math.random())];
		}
		return actionsDuTour;
	}

}
