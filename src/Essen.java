public class Essen extends Ware {
    private final int gewicht;

    public Essen (String beschreibung, int preis, int gewicht) {
        super(beschreibung, preis);
        this.gewicht = gewicht;
    }

    public String beschreibung () {
        return super.beschreibung() + "(" + gewicht + ")";
    }

    public int gewicht () {
        return gewicht;
    }
}
