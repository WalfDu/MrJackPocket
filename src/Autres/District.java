package Autres;

<<<<<<< HEAD
=======
import InterfaceGraphique.HelloApp;
>>>>>>> Mathieu
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
<<<<<<< HEAD
		this.sourceImage = ""; //"../../images/districts/";
=======
		this.sourceImage = "" ;// "../../images/districts/";
>>>>>>> Mathieu
		for (String i : temp) {
			this.sourceImage += i;
		}
		this.sourceImage += "-recto.png";
<<<<<<< HEAD
		this.sourceImageVerso = /*"../../images/districts/*/"common-verso.png";
		if (nomSuspect == "Joseph Lane") {
			this.sourceImageVerso = /*"../../images/districts/*/"JosephLane-verso.png";
=======
		this.sourceImageVerso ="common-verso.png"; //"../../images/districts/common-verso.png";
		if (nomSuspect == "Joseph Lane") {
			this.sourceImageVerso = "JosephLane-verso.png" ;//"../../images/districts/JosephLane-verso.png";
>>>>>>> Mathieu
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
		ImageView out = new ImageView(getClass().getResource(sourceImage).toString());
		out.setFitHeight(100);
		out.setFitWidth(100);
		return out;
	}

	public ImageView sourceImageVerso() {
		ImageView out = new ImageView(getClass().getResource(sourceImageVerso).toString());
		out.setFitHeight(100);
		out.setFitWidth(100);
		return out;
	}

	public String getNomSuspect() {
		return nomSuspect;
	}

	public void setNomSuspect(String nomSuspect) {
		this.nomSuspect = nomSuspect;
	}

	public void innocenter() {
<<<<<<< HEAD
		//InterfaceGraphique.HelloApp.innocenter(nomSuspect);
=======
		HelloApp.innocenter(nomSuspect);
>>>>>>> Mathieu
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
