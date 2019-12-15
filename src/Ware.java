public class Ware implements ChristkindlesmarktKram {
    private final String beschreibung;
    private final int preis;

    protected Ware (String beschreibung, int preis) {
        this.preis = preis;
        this.beschreibung = beschreibung;
    }

    @Override
    public String beschreibung () {
        return beschreibung;
    }

    @Override
    public int preis () {
        return preis;
    }
}
