package src.Autres;

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
		this.sourceImage = "../../images/districts/";
		for (String i : temp) {
			this.sourceImage += i;
		}
		this.sourceImage += "-recto.png";
		this.sourceImageVerso = "../../images/districts/common-verso.png";
		if (nomSuspect == "Joseph Lane") {
			this.sourceImageVerso = "../../images/districts/JosephLane-verso.png";
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

	public String sourceImage() {
		return sourceImage;
	}

	public String sourceImageVerso() {
		return sourceImageVerso;
	}

	public String getNomSuspect() {
		return nomSuspect;
	}

	public void setNomSuspect(String nomSuspect) {
		this.nomSuspect = nomSuspect;
	}

	public void innocenter() {
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
