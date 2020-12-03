package src;

public class Alibi {
	//test test 	

	private String nom;
	private Integer nombreSablier;

	// Constructor
	public Alibi() {
	};

	public Alibi(String nom, Integer nombreSablier) {
		this.nom = nom;
		this.nombreSablier = nombreSablier;
	}

	public void setNom(String newVar) {
		nom = newVar;
	}

	public String getNom() {
		return nom;
	}

	public void setNombreSablier(Integer newVar) {
		nombreSablier = newVar;
	}

	public Integer getNombreSablier() {
		return nombreSablier;
	}
}
