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

	public static int move(int place) {
		if (place < 12) {
			return place++;
		} else
			return 1;
	}

	public String getNom() {
		return nom;
	}

	public void setPlace(int newVar) {
		place += newVar;
		if (place > 12) {
			place -= 12;
		}
	}

	public int getPlace() {
		return place;
	}

}
