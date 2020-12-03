package src.Autres;

public class Joueur {
	private String nom;

	// Constructors
	public Joueur() {
	};

	public Joueur(String nom) {
		this.nom = nom;
	};

	public void setNom(String newVar) {
		nom = newVar;
	}

	public String getNom() {
		return nom;
	}
}
