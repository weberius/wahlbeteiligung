package de.illilli.opendata.service.wahlbeteiligung.model;

/**
 * <pre>
 * "stimmbezirke":{
    "nr":10101,
    "wahlberechtigt":1000,
    "abgegeben":500,
    "gueltig":450,
    "ungueltig":50
  }
 * </pre>
 * 
 */
public class Stimmbezirk {

	public int nr;
	public int wahlberechtigt;
	public int abgegeben;
	public int gueltig;
	public int ungueltig;

	@Override
	public String toString() {
		return "Stimmbezirk [nr=" + nr + ", wahlberechtigt=" + wahlberechtigt + ", abgegeben=" + abgegeben
				+ ", gueltig=" + gueltig + ", ungueltig=" + ungueltig + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abgegeben;
		result = prime * result + gueltig;
		result = prime * result + nr;
		result = prime * result + ungueltig;
		result = prime * result + wahlberechtigt;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stimmbezirk other = (Stimmbezirk) obj;
		if (abgegeben != other.abgegeben)
			return false;
		if (gueltig != other.gueltig)
			return false;
		if (nr != other.nr)
			return false;
		if (ungueltig != other.ungueltig)
			return false;
		if (wahlberechtigt != other.wahlberechtigt)
			return false;
		return true;
	}

}
