package jetons;

import InterfaceGraphique.InterfaceGraphique;
import java.util.ArrayDeque;
import java.util.Scanner;

import Autres.Detectives;
import Autres.District;
import Autres.Jeu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JetonAlibi extends Jetons {
	Scanner scanner = new Scanner(System.in);
	public static String nom;
	public static Image im = new Image("file:images/actions/Jeton3-Face2.png", 50, 50, false, false);
	public static ImageView imView = new ImageView(im);
	public static ArrayDeque<String> pileAlibi = new ArrayDeque<>(); // Definition de la pile de carte
	static String[] debutPile = { "William Gull 1", "Sgt Goodley 0", "Madame 2", "Joseph Lane 1", "John Smith 1",
			"John Pizer 1", "Inspector Lestrade 0", "Jeremy Bert 1", "Miss Stealthy 1" };// ajout de toutes les cartes
																							// dans la pile avec leur
																							// nombre de sablier
	public JetonAlibi() {
	}

	public JetonAlibi(String nom) {
		shuffleArray(debutPile);
		JetonAlibi.nom = nom;
	}

	@Override
	public void action(Detectives[] listeDetectives, District[] board, int jActuel) {
		String[] carte = piocherCarte();
		switch (jActuel) {
		case 0: // Si le joueur est le detective
			InterfaceGraphique.alibi2 = new Image(sourceImage(carte[0]), 60, 100, false, false);
			InterfaceGraphique.alibi2View = new ImageView(InterfaceGraphique.alibi2);
			InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.alibi2View);
			InterfaceGraphique.root.add(InterfaceGraphique.alibi2View, 1, 7);
			for (int i = 0; i < 9; i++) {
				if (board[i].getNomSuspect().equals(carte[0])) { // On innocente la tuile du plateau
					board[i].innocenter(i); // on retourne la tuile
				}
			}
			break;
		case 1: // Si le joueur est Mr Jack
			Jeu.sabliersCaches += Integer.valueOf(carte[1]);// ajout du nombre de sablier de la carte au nombre de
															// sablier total
			InterfaceGraphique.nbSabliers.setText("Mr. Jack a:\n" + (int) (Jeu.sabliers + Jeu.sabliersCaches));
			InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.nbSabliers);
			InterfaceGraphique.root.add(InterfaceGraphique.nbSabliers, 5, 6);
			break;
		}
		InterfaceGraphique.finAction();
	}

	@Override
	public String getNom() {
		return nom;
	}

	public void shuffleArray(String[] initialAlibi) { // Melange la pile d'alibi
		for (int i = initialAlibi.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			String temp = initialAlibi[i];
			initialAlibi[i] = initialAlibi[j];
			initialAlibi[j] = temp;
		}
		for (String i : initialAlibi) {
			this.pileAlibi.addLast(i);
		}
	}

	// Revele la premiere carte du paquet
	public String[] piocherCarte() {
		if (!this.pileAlibi.isEmpty()) {
			String carte = this.pileAlibi.pollFirst();
			String nomAlibi = carte.substring(0, carte.length() - 2);
			String sablier = carte.substring(carte.length() - 1, carte.length());
			String[] out = { nomAlibi, sablier };
			return out;
		}
		String[] out = { "La pile est vide", "-1" };
		return out;
	}

	public int getSize() {
		return this.pileAlibi.size();
	}
	// On renvoie le chemin menant a l'image dans le dossier image
	public static String sourceImage(String nomSuspect) {
		String sourceImage = "file:images/alibis/";
		String[] temp = nomSuspect.substring(0, nomSuspect.length()).split(" ");
		for (String i : temp) {
			sourceImage += i;
		}
		sourceImage += "-alibi.png";
		return sourceImage;
	}

	@Override
	public ImageView getImView() {
		return imView;
	}
}
