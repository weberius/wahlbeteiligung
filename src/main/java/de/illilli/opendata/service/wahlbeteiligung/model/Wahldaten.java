package de.illilli.opendata.service.wahlbeteiligung.model;

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
  "gemeinde":"05315000"
 }
 * </pre>
 */
public class Wahldaten {

	public String art;
	public String wahl;
	public String bundesland;
	public String gemeinde;
	public String datum;

}
