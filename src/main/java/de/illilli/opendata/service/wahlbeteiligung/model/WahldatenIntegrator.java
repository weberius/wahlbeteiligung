package de.illilli.opendata.service.wahlbeteiligung.model;

import org.geojson.FeatureCollection;

import de.illilli.opendata.service.Integrator;

public class WahldatenIntegrator implements Integrator<FeatureCollection> {

	private FeatureCollection featureCollection = new FeatureCollection();

	public WahldatenIntegrator(FeatureCollection featureCollection, Wahldaten wahldaten) {

	}

	@Override
	public FeatureCollection getData() {
		return featureCollection;
	}

}
