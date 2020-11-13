
public class Alibi {

	private String nom;
	private Integer nombreSablier;

	// Constructor
	public Alibi() {
	};

	public void setNom(String newVar) {
		nom = newVar;
	}

	public static void main(String[] arg) {
		System.out.println("test");
	};

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
