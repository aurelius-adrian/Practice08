/**
 * Merkt sich sehr schnell beliebig viele Zahlen wie auf einem Schmierblatt - daher auch in beliebiger Reihenfolge (also "kreuz und quer")!
 *
 * @author John Doe
 * @version 1.1, 11/19/19
 */
public final class ZahlenMerker {
	private final java.util.HashSet<Long> schmierblatt = new java.util.HashSet<>();

	/**
	 * Notiert die uebergebene Zahl irgendwo auf diesem Schmierblatt.
	 *
	 * @param zahl die Zahl, die auf dem Schmierblatt vermerkt werden soll
	 * @return {@code true} wenn die Zahl noch nicht auf dem Schmierblatt stand und deshalb erstmals hinzugefuegt wurde
	 */
	public boolean merkeDir(long zahl) {
		return schmierblatt.add(zahl);
	}

	/**
	 * Schaut nach, ob die uebergebene Zahl schon irgendwo auf diesem Schmierblatt steht.
	 *
	 * @param zahl die Zahl, die auf dem Schmierblatt nachgeschlagen werden soll
	 * @return {@code true} wenn die Zahl schon auf dem Schmierblatt steht
	 */
	public boolean sagMirKennstDuDieSchon(long zahl) {
		return schmierblatt.contains(zahl);
	}
}