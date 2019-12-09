/**
 * Merkt sich beliebig viele Kombinationen aus eindeutigem LightsOut-Zustand und Schaltfolge!
 * <p>Beispiel: In der Kombination (z, s) koennte s diejenige Schaltfolge sein, die zum zugehoerigen Zustand z gefuehrt hat.</p>
 *
 * @author John Doe
 * @version 1.1, 11/19/19
 */
public class MerkerFuerLightsOutLoesungsVersuche {
	private final java.util.HashMap<Long, ZahlenFolgenMerker> merker = new java.util.HashMap<>();

	/**
	 * Merkt sich die Kombination aus eindeutigem LightsOut-Zustand und Schaltfolge!
	 * <p><b>ACHTUNG</b>: Falls der Zustand schon mal vorgekommen ist, dann wird die <b>neue</b> Schaltfolge stattdessen gemerkt!</p>
	 *
	 * @param zustand     ein Zustand des LightsOut-Spiels
	 * @param schaltfolge eine Schaltfolge im LightsOut-Spiel
	 */
	public void merkeDir(long zustand, ZahlenFolgenMerker schaltfolge) {
		merker.put(zustand, schaltfolge);
	}

	/**
	 * Gibt die zum Zustand {@code zustand} gemerkte Schaltfolge zurueck, sofern eine bekannt ist - andernfalls {@code null}.
	 *
	 * @param zustand ein Zustand des LightsOut-Spiels
	 * @return die zum Zustand gemerkte Schaltfolge - oder {@code null}, falls der {@code zustand} bislang unbekannt ist
	 */
	public ZahlenFolgenMerker verrateMirDieSchaltfolgeZum(long zustand) {
		return merker.get(zustand);
	}

	/**
	 * Gibt eine Liste aller gemerkten Zustaende zurueck.
	 *
	 * @return die Liste aller germerkten Zustaende
	 */
	public long[] gibMirAlleZustaende() {
		long[] zustaende = new long[merker.keySet().size()];
		int index = 0;
		for (Long l : merker.keySet()) {
			zustaende[index++] = l;
		}
		return zustaende;
	}

	/**
	 * Vergisst <b>ALLE</b> bislang gemerkten Kombinationen!
	 */
	public void vergissAlles() {
		merker.clear();
	}
}