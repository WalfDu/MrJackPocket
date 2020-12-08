package src.jetons;

import src.Autres.Detectives;
import src.Autres.District;

public abstract class Jetons {

	abstract public String getNom();

	abstract public void action(Detectives[] listeDetectives, District[][] board);
}
