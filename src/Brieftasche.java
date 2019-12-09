/**
 * Verwaltet beliebige viele unabhaengige Rechnungen in einer Brieftasche.
 */
public class Brieftasche {
	private Brieftasche brieftasche = null;
	private Rechnung rechnung = null;

	/**
	 * Nimmt die uebergebene Rechnung in die Brieftasche auf.
	 *
	 * @param rechnung die in diese Brieftasche zu ergaenzende Rechnung
	 */
	public void ergaenze(Rechnung rechnung) {
		Brieftasche brieftasche = new Brieftasche();
		brieftasche.brieftasche = this.brieftasche;
		brieftasche.rechnung = this.rechnung;
		this.brieftasche = brieftasche;
		this.rechnung = rechnung;
	}

	/**
	 * Gibt alle Rechnungen aus dieser Brieftasche als Array zurueck.
	 *
	 * @return alle Rechnungen aus dieser Brieftasche als Array
	 */
	public Rechnung[] alsArray() {
		java.util.LinkedList<Rechnung> liste = new java.util.LinkedList<>();
		Brieftasche brieftasche = this;
		while (brieftasche.brieftasche != null) {
			liste.addFirst(brieftasche.rechnung);
			brieftasche = brieftasche.brieftasche;
		}
		return liste.toArray(new Rechnung[0]);
	}
}