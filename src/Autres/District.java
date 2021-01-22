package Autres;

import InterfaceGraphique.InterfaceGraphique;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class District {

	private String faceSuspect;
	private int mur;
	private String nomSuspect;
	private String sourceImage;
	private String sourceImageVerso;

	public District() {
	}

	public District(String faceSuspect, int mur, String nomSuspect) {
		this.faceSuspect = faceSuspect;
		this.mur = mur;
		this.nomSuspect = nomSuspect;
		String[] temp = nomSuspect.split(" ");
		this.sourceImage = "file:images/districts/";
		for (String i : temp) {
			this.sourceImage += i;
		}
		this.sourceImage += "-recto.png";
		this.sourceImageVerso = "file:images/districts/common-verso.png";
		if (nomSuspect == "Joseph Lane") {
			this.sourceImageVerso = "file:images/districts/JosephLane-verso.png";
		}
	}

	@Override
	public String toString() {
		String[] nom = nomSuspect.split(" ");
		String out = "";
		for (String i : nom) {
			out += i.substring(0, 1);
		}
		return out;
	}

	public ImageView sourceImage() {
		Image out = new Image(sourceImage, 100, 100, false, false);
		ImageView outView = new ImageView(out);
		return outView;
	}

	public ImageView sourceImageVerso() {
		Image out = new Image(sourceImageVerso, 100, 100, false, false);
		ImageView outView = new ImageView(out);
		return outView;
	}

	public String getNomSuspect() {
		return nomSuspect;
	}

	public void setNomSuspect(String nomSuspect) {
		this.nomSuspect = nomSuspect;
	}

	public void innocenter(int i) {
		InterfaceGraphique.tuile[i].setGraphic(sourceImageVerso());
		InterfaceGraphique.root.getChildren().remove(InterfaceGraphique.tuile[i]);
		InterfaceGraphique.root.add(InterfaceGraphique.tuile[i], 2 + i % 3, 3 + i / 3);
		faceSuspect = "Innocent";
		if (!Jeu.innocents.contains(nomSuspect)) {
			Jeu.innocents.addLast(nomSuspect);
		}
	}

	public String getFaceSuspect() {
		return faceSuspect;
	}

	public void setMur() {
		if (mur <4) { //Pour Joseph Lane verso, on defini un mur > 4
			mur = (mur+1)%4;
		} else {
			mur++;
		}
	}

	public int getMur() {
		if (nomSuspect.equals("Joseph Lane") && faceSuspect.equals("Innocent")) {
			return 5;
		}
		return mur;
	}
}
