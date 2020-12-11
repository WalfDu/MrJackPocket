package src.Autres;

public class Position {

    private int abscisse;
    private int ordonne;

    public Position(int abscisse, int ordonne) {
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
