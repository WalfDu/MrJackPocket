

public class JetonsTemps {

	private Integer numero;
	private Boolean sablier;

	//Constuctor
	public JetonsTemps() {
	};

	public JetonsTemps(Integer numero, Boolean sablier) {
		this.numero = numero;
		this.sablier = sablier;
	}

	public void setNumero(Integer newVar) {
		numero = newVar;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setSablier(Boolean newVar) {
		sablier = newVar;
	}

	public Boolean getSablier() {
		return sablier;
	}

}