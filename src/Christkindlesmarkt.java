public class Christkindlesmarkt extends Brieftasche {
    private Rechnung tmp = new Rechnung();

    public static Brieftasche alle (int geld, ChristkindlesmarktKram[] angebot) {
        Brieftasche outputB = new Brieftasche();
        Rechnung outputR = new Rechnung();
        outputB.ergaenze(outputR);

        return null;
    }

    private Rechnung Backtrack (int geld,  ChristkindlesmarktKram[] angebot) {
        for (int i = 0; i < angebot.length; i++) {
            if (geld - angebot[i].preis() < 0) {
                //some sort of return statement!!
                break;
            } else {
                return tmp;
            }
        }
    }
}
