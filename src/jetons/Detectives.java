
public class Detectives {

	private String nom;
	private Position place;

	//test git
	// Constructors
	public Detectives() {
	};

	public Detectives(String nom, Position place) {
		this.nom = nom;
		this.place = place;
	}

	public void setNom(String newVar) {
		nom = newVar;
	}

	public String getNom() {
		return nom;
	}

	public void setPlace(Position newVar) {
		place = newVar;
	}

	public Position getPlace() {
		return place;
	}

}
