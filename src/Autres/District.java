package Autres;

import InterfaceGraphique.HelloApp;
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
		this.sourceImageVerso = /* "../../images/districts/ */"common-verso.png";
		if (nomSuspect == "Joseph Lane") {
			this.sourceImageVerso = /* "../../images/districts/ */"JosephLane-verso.png";
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

	public void innocenter() {
		// InterfaceGraphique.HelloApp.innocenter(nomSuspect);
		faceSuspect = "Innocent";
		Jeu.innocents.addLast(nomSuspect);
	}

	public String getFaceSuspect() {
		return faceSuspect;
	}

	public void setMur() {
		mur++;
		if (mur > 3) {
			mur -= 4;
		}
	}

	public int getMur() {
		if (nomSuspect.equals("Joseph Lane") && faceSuspect.equals("Innocent")) {
			return -1;
		}
		return mur;
	}
}
