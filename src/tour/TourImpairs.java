package tour;

import jetons.JetonAlibi;
import jetons.JetonDetective;
import jetons.JetonEchanger;
import jetons.JetonSherlock;
import jetons.JetonTobie;
import jetons.JetonTourner;
import jetons.JetonWatson;
import jetons.Jetons;

public class TourImpairs {
	static Jetons echanger = new JetonEchanger("Échanger les places de deux tuiles");
	static Jetons tourner = new JetonTourner("Faire tourner une tuile");
	static Jetons tourner2 = new JetonTourner("Faire tourner une tuile");
	static Jetons toby = new JetonTobie("Avancer Toby");
	static Jetons watson = new JetonWatson("Avancer Watson");
	static Jetons sherlock = new JetonSherlock("Avancer Sherlock");
	static Jetons alibi = new JetonAlibi("Piocher une carte alibi");
	static Jetons detective = new JetonDetective("Avancer l'un des trois détectives");
	static Jetons[][] jetonsAction = jetonsAction();

	// Constructors
	public TourImpairs() {
	};

	public static Jetons[][] jetonsAction() {
		Jetons[][] jetonsAction = { { echanger, tourner2 }, { toby, watson }, { sherlock, alibi },
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
