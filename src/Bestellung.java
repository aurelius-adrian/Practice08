public class Bestellung implements ChristkindelsmarktKram {
    @Override
    public final String beschreibung() {
        return null;
    }

    @Override
    public final int preis() {
        return 0;
    }

    private final int menge;

    public Bestellung (ChristkindelsmarktKram kram, int menge) {
        this.menge = menge;
    }

    public ChristkindelsmarktKram Kram () {
        return null;
    }

    public int menge () {
        return 0;
    }
}
