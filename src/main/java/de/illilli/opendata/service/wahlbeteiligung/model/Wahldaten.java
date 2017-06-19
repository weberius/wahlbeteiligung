package de.illilli.opendata.service.wahlbeteiligung.model;

import java.util.Arrays;

/**
 * Beispiel für eine (komplette) Datenstruktur, die mit Hilfe dieser Klasse
 * abgebildet wird.
 * 
 * <pre>
 * { 
  "art":"erststimmen",
  "wahl":"landtagswahl",
  "datum":"11.11.2016",
  "bundesland":"05",
  "gemeinde":"05315000",
  "stimmbezirke":[{
    "nr":10101,
    "wahlberechtigt":1000,
    "abgegeben":500,
    "gueltig":450,
    "ungueltig":50,
    "ergebnisse":[{
      "partei":"Partei1",
      "stimmen":123
     }]
  }]
}
 * </pre>
 */
public class Wahldaten {

	public String art;
	public String wahl;
	public String bundesland;
	public String gemeinde;
	public String datum;
	public Stimmbezirk[] stimmbezirke;

	@Override
	public String toString() {
		return "Wahldaten [art=" + art + ", wahl=" + wahl + ", bundesland=" + bundesland + ", gemeinde=" + gemeinde
				+ ", datum=" + datum + ", stimmbezirke=" + Arrays.toString(stimmbezirke) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((art == null) ? 0 : art.hashCode());
		result = prime * result + ((bundesland == null) ? 0 : bundesland.hashCode());
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((gemeinde == null) ? 0 : gemeinde.hashCode());
		result = prime * result + Arrays.hashCode(stimmbezirke);
		result = prime * result + ((wahl == null) ? 0 : wahl.hashCode());
		return result;
	}

}
