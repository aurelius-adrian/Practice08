public class Bestellung implements ChristkindlesmarktKram {
    @Override
    public final String beschreibung() {
        return null;
    }

    @Override
    public final int preis() {
        return 0;
    }

    private final int menge;

    public Bestellung (ChristkindlesmarktKram kram, int menge) {
        this.menge = menge;
    }

    public ChristkindlesmarktKram kram () {
        return null;
    }

    public int menge () {
        return 0;
    }
}
