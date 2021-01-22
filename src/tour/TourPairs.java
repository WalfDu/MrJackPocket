package tour;

import jetons.Jetons;

public class TourPairs {
	static Jetons[][] jetonsAction = TourImpairs.jetonsAction();

	public TourPairs() {
	};

	public static Jetons[] debut(Jetons[] actionTourPrecedent) {
		Jetons[] actionsDuTour = new Jetons[4];
		for (int i = 0; i < actionsDuTour.length; i++) {
			actionsDuTour[i] = jetonsAction[i][0];		//On met tous les jetons du cote pile
		}
		for (int i = 0; i < actionsDuTour.length; i++) {
			for (int j = 0; j < actionsDuTour.length; j++) {
				if (actionsDuTour[i].equals(actionTourPrecedent[j])) {		//Si le jeton cote pile a ete joue au tour precedent, on met le cote face
					actionsDuTour[i] = jetonsAction[i][1];
				}
			}
		}
		return actionsDuTour;
	}
}
