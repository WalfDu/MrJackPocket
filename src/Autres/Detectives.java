package Autres;

public class Detectives {

	private String nom;
	private int place;

	// Constructors
	public Detectives() {
	};

	public Detectives(String nom, int place) {
		this.nom = nom;
		this.place = place;
	}

	@Override
	public String toString() {
		return nom.substring(0, 1);
	}

	public String getNom() {
		return nom;
	}

	public void setPlace(int newVar) {
		place = newVar%24 + 1;
	}

	public int getPlace() {
		return place;
	}

}
