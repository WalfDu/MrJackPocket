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

	public void setFaceSuspect(String faceSuspect) {
		this.faceSuspect = faceSuspect;
	}

	public String getNomSuspect() {
		return nomSuspect;
	}

	public void setNomSuspect(String nomSuspect) {
		this.nomSuspect = nomSuspect;
	}

	public void innocenter() {
		faceSuspect = "Innocent";
		if (nomSuspect == "Sgt Goodley") {
		}
	}

	public String getFaceSuspect() {
		return faceSuspect;
	}

	public void setMur(int newVar) {
		mur = newVar;
	}

	public int getMur() {
		return mur;
	}
}
