public class Getraenk extends  Ware {
    private final double volumen;

    public Getraenk (String beschreibung, int preis, double volumen) {
        super(beschreibung, preis);
        this.volumen = volumen;
    }

    public String beschreibung () {
        return super.beschreibung() + "(" + volumen + ")";
    }

    public double volumen() {
        return volumen;
    }
}
