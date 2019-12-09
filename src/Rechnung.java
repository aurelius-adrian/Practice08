/**
 * Verwaltet eine Rechnung ("Kassenbon") bestehend aus beliebig vielen Bestellungen.
 */
public class Rechnung {
	private Rechnung rechnung = null;
	private Bestellung bestellung = null;

	/**
	 * Setzt die uebergebene Bestellung auf die Rechnung.
	 *
	 * @param bestellung die auf dieser Rechnung zu ergaenzende Bestellung
	 */
	public void ergaenze(Bestellung bestellung) {
		Rechnung rechnung = new Rechnung();
		rechnung.rechnung = this.rechnung;
		rechnung.bestellung = this.bestellung;
		this.rechnung = rechnung;
		this.bestellung = bestellung;
	}

	/**
	 * Gibt die Bestellungen dieser Rechnung als Array zurueck.
	 *
	 * @return die Bestellungen dieser Rechnung als Array
	 */
	public Bestellung[] alsArray() {
		java.util.LinkedList<Bestellung> liste = new java.util.LinkedList<>();
		Rechnung rechnung = this;
		while (rechnung.rechnung != null) {
			liste.addFirst(rechnung.bestellung);
			rechnung = rechnung.rechnung;
		}
		return liste.toArray(new Bestellung[0]);
	}
}