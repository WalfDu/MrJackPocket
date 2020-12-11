package tour;

import jetons.Jetons;

public class TourPairs {
	static Jetons[][] jetonsAction = TourImpairs.jetonsAction();

	//Constructor
	public TourPairs() {
	};

	public static Jetons[] debut(Jetons[] actionTourPrécédent) {
		Jetons[] actionsDuTour = new Jetons[4];
		for (int i = 0; i < actionsDuTour.length; i++) {
			actionsDuTour[i] = jetonsAction[i][0];
		}
		for (int i = 0; i < actionsDuTour.length; i++) {
			for (int j = 0; j < actionsDuTour.length; j++) {
				if (actionsDuTour[i].equals(actionTourPrécédent[j])) {
					actionsDuTour[i] = jetonsAction[i][1];
				}
			}
		}
		return actionsDuTour;
	}
}
