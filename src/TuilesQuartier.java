package src;

public class TuilesQuartier {

	private String faceSuspect;
	private int mur;
	private String nomSuspect;

	public TuilesQuartier() {
	}

	public TuilesQuartier(String faceSuspect, int mur, String nomSuspect) {
		this.faceSuspect = faceSuspect;
		this.mur = mur;
		this.nomSuspect = nomSuspect;
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
