
public class Position {

    private Integer abscisse;
    private Integer ordonne;

    // Constructor
    public Position() {
    };

    public Position(Integer abscisse, Integer ordonne) {
        this.abscisse = abscisse;
        this.ordonne = ordonne;
    }

    public void setAbscisse(Integer newVar) {
        abscisse = newVar;
    }

    public Integer getAbscisse() {
        return abscisse;
    }

    public void setOrdonne(Integer newVar) {
        ordonne = newVar;
    }

    public int getOrdonne() {
        return ordonne;
    }

}
