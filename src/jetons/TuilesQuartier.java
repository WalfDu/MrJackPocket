package jetons;

public class TuilesQuartier {

	private Boolean faceSuspect;
	private int mur;
	private Position place;
	private String nomSuspect;

	public TuilesQuartier() {
	}

	public TuilesQuartier(Boolean faceSuspect, int mur, String nomSuspect) {
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

	public void setFaceSuspect(Boolean newVar) {
		faceSuspect = newVar;
	}

	public Boolean getFaceSuspect() {
		return faceSuspect;
	}

	public void setMur(int newVar) {
		mur = newVar;
	}

	public int getMur() {
		return mur;
	}

	public void setPlace(Position newVar) {
		place = newVar;
	}

	public Position getPlace() {
		return place;
	}
}
