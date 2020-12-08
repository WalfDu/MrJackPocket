package src.tour;

import src.jetons.Jetons;

public class TourPairs {
	static Jetons[][] jetonsAction = TourImpairs.jetonsAction();

	//Constructor
	public TourPairs() {
	};

	public static Jetons[] debut(Jetons[] actionTourPrécédent) {
		Jetons[] actionsDuTour = new Jetons[4];
		for (int i = 0; i < actionsDuTour.length; i++) {
			actionsDuTour[i] = jetonsAction[i][1];
		}
		for (int i = 0; i < actionsDuTour.length; i++) {
			if (actionsDuTour[i].equals(actionTourPrécédent[i])) {
				actionsDuTour[i] = jetonsAction[i][2];
			}
		}
		return actionsDuTour;
	}
}
