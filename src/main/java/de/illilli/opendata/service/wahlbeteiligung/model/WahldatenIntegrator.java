package de.illilli.opendata.service.wahlbeteiligung.model;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;

import org.geojson.Feature;
import org.geojson.FeatureCollection;

import de.illilli.opendata.service.Integrator;

public class WahldatenIntegrator implements Integrator<FeatureCollection> {

	private FeatureCollection featureCollection = new FeatureCollection();

	public WahldatenIntegrator(FeatureCollection fc, Wahldaten wahldaten) {

		Map<Integer, Double> wahlbeteiligungMap = new Hashtable<>();
		for (Stimmbezirk stimmbezirk : wahldaten.stimmbezirke) {
			int key = stimmbezirk.nr;
			double value = new BigDecimal(stimmbezirk.gueltig)
					.divide(new BigDecimal(stimmbezirk.wahlberechtigt), 2, BigDecimal.ROUND_CEILING).doubleValue();
			wahlbeteiligungMap.put(key, value);
		}

		for (Feature f : fc.getFeatures()) {
			Feature feature = new Feature();
			Object nummer = f.getProperties().get("nummer");
			Object nichtwaehler = wahlbeteiligungMap.get(nummer);
			feature.setId(nummer + "");
			feature.setProperty("nichtwaehler", nichtwaehler);
			feature.setGeometry(f.getGeometry());
			this.featureCollection.add(feature);
		}
	}

	@Override
	public FeatureCollection getData() {
		return featureCollection;
	}

}
