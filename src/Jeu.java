import InterfaceGraphique.HelloApp;
import src.Alibi;

import src.Joueur;

public class Jeu {
	private src.Joueur joueur1;
	private src.Joueur joueur2;
	//private HelloApp fenetre;
	private JetonsTemps jeton1;
	private JetonsTemps jeton2;
	private JetonsTemps jeton3;
	private JetonsTemps jeton4;
	private JetonsTemps jeton5;
	private JetonsTemps jeton6;
	private JetonsTemps jeton7;
	private JetonsTemps jeton8;
	private TableauTuiles plateau;
	private src.Alibi josephLane;
	private src.Alibi johnPizer;
	private src.Alibi johnSmith;
	private src.Alibi madame;
	private src.Alibi jeremyBert;
	private src.Alibi missStealthy;
	private src.Alibi inspLestrade;
	private src.Alibi williamGull;
	private src.Alibi sgtGoodley;

	public Jeu(Joueur joueur1, Joueur joueur2, JetonsTemps jeton1, JetonsTemps jeton2, JetonsTemps jeton3, JetonsTemps jeton4, JetonsTemps jeton5, JetonsTemps jeton6, JetonsTemps jeton7, JetonsTemps jeton8, TableauTuiles plateau, Alibi josephLane, Alibi johnPizer, Alibi johnSmith, Alibi madame, Alibi jeremyBert, Alibi missStealthy, Alibi inspLestrade, Alibi williamGull, Alibi sgtGoodley) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.jeton1 = jeton1;
		this.jeton2 = jeton2;
		this.jeton3 = jeton3;
		this.jeton4 = jeton4;
		this.jeton5 = jeton5;
		this.jeton6 = jeton6;
		this.jeton7 = jeton7;
		this.jeton8 = jeton8;
		this.plateau = plateau;
		this.josephLane = josephLane;
		this.johnPizer = johnPizer;
		this.johnSmith = johnSmith;
		this.madame = madame;
		this.jeremyBert = jeremyBert;
		this.missStealthy = missStealthy;
		this.inspLestrade = inspLestrade;
		this.williamGull = williamGull;
		this.sgtGoodley = sgtGoodley;
	}

	// Constructors
	public Jeu() {
	};

	public static void main(){
		Alibi josephLane = new Alibi("josephLane", 1);
		Alibi williamGull = new Alibi("williamGull", 1);
		Alibi jeremyBert = new Alibi("jeremyBert", 1);
		Alibi johnPizer = new Alibi("johnPizer", 1);
		Alibi inspecteurLestrade = new Alibi("inspecteurLestrade", 0);
		Alibi missStealthy = new Alibi("missStealthy", 1);
		Alibi madame = new Alibi("madame", 2);
		Alibi sgtGoodley = new Alibi("sgtGoodley", 0);
		JetonsTemps jetons1 = new JetonsTemps();
		JetonsTemps jetons2 = new JetonsTemps();
		JetonsTemps jetons3 = new JetonsTemps();
		JetonsTemps jetons4 = new JetonsTemps();
		JetonsTemps jetons5 = new JetonsTemps();
		JetonsTemps jetons6 = new JetonsTemps();
		JetonsTemps jetons7 = new JetonsTemps();
		JetonsTemps jetons8 = new JetonsTemps();
	}

	public void setJoueur1(src.Joueur newVar) {
		joueur1 = newVar;
	}

	public src.Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur2(src.Joueur newVar) {
		joueur2 = newVar;
	}

	public src.Joueur getJoueur2() {
		return joueur2;
	}

	public void setJeton1(JetonsTemps newVar) {
		jeton1 = newVar;
	}
	
	public JetonsTemps getJeton1() {
		return jeton1;
	}
	
	public void setJeton2(JetonsTemps newVar) {
		jeton2 = newVar;
	}
	
	public JetonsTemps getJeton2() {
		return jeton2;
	}
	
	public void setJeton3(JetonsTemps newVar) {
		jeton3 = newVar;
	}
	
	public JetonsTemps getJeton3() {
		return jeton3;
	}
	
	public void setJeton4(JetonsTemps newVar) {
		jeton4 = newVar;
	}
	
	public JetonsTemps getJeton4() {
		return jeton4;
	}
	
	public void setJeton5(JetonsTemps newVar) {
		jeton5 = newVar;
	}
	
	public JetonsTemps getJeton5() {
		return jeton5;
	}
	
	public void setJeton6(JetonsTemps newVar) {
		jeton6 = newVar;
	}
	
	public JetonsTemps getJeton6() {
		return jeton6;
	}
	
	public void setJeton7(JetonsTemps newVar) {
		jeton7 = newVar;
	}
	
	public JetonsTemps getJeton7() {
		return jeton7;
	}
	
	public void setJeton8(JetonsTemps newVar) {
		jeton8 = newVar;
	}
	
	public JetonsTemps getJeton8() {
		return jeton8;
	}

}
