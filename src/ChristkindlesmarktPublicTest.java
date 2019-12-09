import static org.junit.Assert.*;
import java.lang.reflect.*;
import org.junit.*;
import java.util.*;

public class ChristkindlesmarktPublicTest {
	// ========== SYSTEM ==========
	static final String EX_NAME_UML2Java = "UML2Java";
	static final String EX_NAME_Christkindlesmarkt = "Christkindlesmarkt";
	// --------------------

	// ========== TEST DATA ==========
	private static final java.util.Random RND = new java.util.Random(4711_0815_666L);

	// ========== EXAMPLE RUN ==========
	public static void main(String[] args) {
		ChristkindlesmarktKram[] angebot = {
				new Getraenk("Gluehwein", 450, 0.2d),
				new Getraenk("Zwetschgenmaennle", 620, 0.1d),
				new Essen("Elisen-Lebkuchen", 695, 250),
				new Essen("Drei im Weggla", 350, 200),
				new WeihnachtsDeko("Krippenfigur Jesus", 799),
				new WeihnachtsDeko("Nostalgische Schneekugel", 599)
		};
		int geld = 5000;
		Brieftasche brieftasche = Christkindlesmarkt.alle(geld, angebot);
		for (Rechnung rechnung : brieftasche.alsArray()) {
			System.out.println("======================================================================");
			int kostenGesamt = 0;
			int kostenProBestellung;
			for (Bestellung bestellung : rechnung.alsArray()) {
				kostenProBestellung = bestellung.kram().preis() * bestellung.menge();
				System.out.printf("%1$5dx %2$-40s %3$5.2f : %4$7.2f\n", bestellung.menge(), bestellung.kram().beschreibung(), (double) bestellung.kram().preis() / 100, (double) kostenProBestellung / 100);
				kostenGesamt += kostenProBestellung;
			}
			System.out.printf("%1$52s   %2$8s\n", "", "----------");
			System.out.printf("%1$53s : %2$7.2f\n", "TOTAL (EUR)", ((double) kostenGesamt / 100));
			System.out.printf("%1$53s : %2$7.2f\n", "REST (EUR)", ((double) (geld - kostenGesamt) / 100));
		}
	}

	// ========== PUBLIC TEST ==========
	@Test(timeout = 666)
	public void pubTest__Christkindlesmarkt__shallowSmokeTest_fieldsOnly() {
		for (Class clazz : new Class[]{ChristkindlesmarktKram.class, Ware.class, Getraenk.class, Essen.class, WeihnachtsDeko.class, Bestellung.class, Christkindlesmarkt.class}) {
			Field[] fields = getDeclaredFields(clazz);
			for (Field field : fields) {
				assertTrue(field + " hat falsche Sichtbarkeit.", Modifier.isPrivate(field.getModifiers()));
				assertTrue(field + " ist faelschlicherweise keine Konstante.", Modifier.isFinal(field.getModifiers()));
				assertFalse(field + " ist faelschlicherweise kein Instanzattribut.", Modifier.isStatic(field.getModifiers()));
			}
		}
	}

	@Test(timeout = 666)
	public void pubTest__Christkindlesmarkt__instances() {
		assertSame(Ware.class, Getraenk.class.getSuperclass());
		assertSame(Ware.class, Essen.class.getSuperclass());
		assertSame(Ware.class, WeihnachtsDeko.class.getSuperclass());
		assertEquals(1, Ware.class.getInterfaces().length);
		assertSame(ChristkindlesmarktKram.class, Ware.class.getInterfaces()[0]);
		for (int pass = 0; pass < 10; pass++) {
			String beschreibung = generateRandomString();
			int preis = 42 + RND.nextInt(4711);
			double volumen = 42.666d * RND.nextDouble();
			int gewicht = 42 + RND.nextInt(4711);
			int menge = 42 + RND.nextInt(4711);
			Getraenk getraenk = new Getraenk(beschreibung, preis, volumen);
			assertEquals("Getraenk: Die Beschreibung spottet jeder selbigen.", beschreibung + " (" + volumen + "l)", getraenk.beschreibung());
			assertEquals("Getraenk: Der Preis ist heiss.", preis, getraenk.preis());
			assertEquals("Getraenk: Das Volumen macht nicht gerade freudetrunken.", volumen, getraenk.volumen(), volumen * Double.MIN_VALUE);
			Essen essen = new Essen(beschreibung, preis, gewicht);
			assertEquals("Essen: Die Beschreibung spottet jeder selbigen.", beschreibung + " (" + gewicht + "g)", essen.beschreibung());
			assertEquals("Essen: Der Preis ist heiss.", preis, essen.preis());
			assertEquals("Essen: Das Gewicht macht nicht gerade fett.", gewicht, essen.gewicht());
			WeihnachtsDeko weihnachtsDeko = new WeihnachtsDeko(beschreibung, preis);
			assertEquals("WeihnachtsDeko: Die Beschreibung spottet jeder selbigen.", beschreibung, weihnachtsDeko.beschreibung());
			assertEquals("WeihnachtsDeko: Der Preis ist heiss.", preis, weihnachtsDeko.preis());
			ChristkindlesmarktKram kram = new WeihnachtsDeko(beschreibung, preis);
			assertEquals("ChristkindlesmarktKram: Die Beschreibung spottet jeder selbigen.", beschreibung, kram.beschreibung());
			assertEquals("ChristkindlesmarktKram: Der Preis ist heiss.", preis, kram.preis());
			Bestellung bestellung = new Bestellung(kram, menge);
			assertSame("Bestellung: Unsinniger Kram.", kram, bestellung.kram());
			assertEquals("Bestellung: Sinnlose Mengen.", menge, bestellung.menge());
		}
	}

	@Test(timeout = 666)
	public void pubTest__Christkindlesmarkt__example() {
		ChristkindlesmarktKram[] angebot = {
				new Getraenk("Gluehwein", 450, 0.2d),
				new Getraenk("Zwetschgenmaennle", 620, 0.1d),
				new Essen("Elisen-Lebkuchen", 695, 250),
				new Essen("Drei im Weggla", 350, 200),
				new WeihnachtsDeko("Krippenfigur Jesus", 799),
				new WeihnachtsDeko("Nostalgische Schneekugel", 599)
		};
		ChristkindlesmarktPublicTest.check__alleMoeglichkeiten("X", 5000, angebot, 631, true);
	}

	// ========== HELPER ==========
	static String generateRandomString() {
		StringBuilder sb = new StringBuilder();
		for (int len = 10 + RND.nextInt(10); len > 0; len--) {
			char c = (char) (RND.nextBoolean() ? 'a' + RND.nextInt('z' - 'a' + 1) : 'A' + RND.nextInt('Z' - 'A' + 1));
			sb.append(c);
		}
		return sb.toString();
	}

	static void check__alleMoeglichkeiten(String msg, int geld, ChristkindlesmarktKram[] angebot, int erwarteteAnzahlLoesungen, boolean budgetVollNutzbar) {
		ChristkindlesmarktKram[] angebotKopie = Arrays.copyOf(angebot, angebot.length);
		Brieftasche brieftasche = Christkindlesmarkt.alle(geld, angebotKopie);
		assertArrayEquals(msg + ": MODIFIZIERE NIEMALS DIE EINGABE!", angebot, angebotKopie);
		assertNotNull(msg + ": Brieftasche darf NIE null sein!", brieftasche);
		List<ChristkindlesmarktKram> angebotListe = Arrays.asList(angebot);
		int billigsterPreis = Integer.MAX_VALUE;
		for (ChristkindlesmarktKram kram : angebot) {
			if (0 < kram.preis() && kram.preis() < billigsterPreis) {
				billigsterPreis = kram.preis();
			}
		}
		Rechnung[] rechnungen = brieftasche.alsArray();
		if (erwarteteAnzahlLoesungen >= 0) {
			assertTrue(msg + ": Anzahl der gemeldeten Loesungen (" + rechnungen.length + ") ist kleiner als erwartet (mind. " + erwarteteAnzahlLoesungen + ").", rechnungen.length >= erwarteteAnzahlLoesungen);
		}
		HashSet<HashMap<ChristkindlesmarktKram, Integer>> alleRechnungen = new HashSet<>();
		for (Rechnung rechnung : rechnungen) {
			assertNotNull(msg + ": Rechnung darf NIE null sein!", rechnung);
			int restGeld = geld;
			HashMap<ChristkindlesmarktKram, Integer> eineRechnung = new HashMap<>();
			for (Bestellung bestellung : rechnung.alsArray()) {
				assertNotNull(msg + ": Bestellung darf NIE null sein!", bestellung);
				assertTrue(msg + ": Bestellung darf NUR Ware aus dem Angebot bestellen!", angebotListe.contains(bestellung.kram()));
				assertTrue(msg + ": Bestellung muss die Ware MINDESTENS EINMAL bestellen!", bestellung.menge() > 0);
				if (bestellung.kram().preis() == 0) {
					assertEquals(msg + ": Kostenlose Ware darf HOECHSTENS EINMAL bestellt werden!", 1, bestellung.menge());
				}
				assertNull(msg + ": Pro Ware darf hoechstens eine Bestellung (dafuer mit fast beliebiger Menge) vorliegen!", eineRechnung.put(bestellung.kram(), bestellung.menge()));
				restGeld -= bestellung.menge() * bestellung.kram().preis();
				assertTrue(msg + ": Bestellung darf das Budget nicht sprengen!", restGeld >= 0);
			}
			assertTrue(msg + ": Rechnung darf nicht wiederholt in der Brieftasche auftreten!", alleRechnungen.add(eineRechnung));
			if (budgetVollNutzbar) {
				assertTrue(msg + ": Rechnung kann und MUSS das Budget voll ausnutzen!", restGeld < billigsterPreis);
			} else {
				assertEquals(msg + ": Rechnung kann das Budget gar nicht voll ausnutzen, daher bleibt es komplett erhalten!", geld, restGeld);
			}
		}
	}

	// ========== HELPER: Intestines ==========
	// @AuD-STUDENT: DO NOT USE REFLECTION IN YOUR OWN SUBMISSION! BITTE KEINE REFLECTION IN DER EIGENEN ABGABE VERWENDEN! => "0 Punkte"!
	private static Field[] getDeclaredFields(Class<?> clazz) {
		java.util.List<Field> declaredFields = new java.util.ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			if (!f.isSynthetic()) {
				declaredFields.add(f);
			}
		}
		return declaredFields.toArray(new Field[0]);
	}
}