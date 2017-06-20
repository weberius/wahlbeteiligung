package de.illilli.opendata.service.wahlbeteiligung;

import java.io.IOException;
import java.net.MalformedURLException;

import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.Integrator;
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahldaten;
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahlgebiet;
import de.illilli.opendata.service.wahlbeteiligung.model.Wahldaten;
import de.illilli.opendata.service.wahlbeteiligung.model.WahldatenIntegrator;

/**
 * Die Klasse StimmbezirkeGeoJsonFacade integriert die Informationen bzgl.
 * Wahlgebiet und
 */
public class StimmbezirkeGeoJsonFacade implements Facade {

	private FeatureCollection featureCollection = new FeatureCollection();

	public StimmbezirkeGeoJsonFacade()
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {

		AskFor<FeatureCollection> askForWahlgebiet = new AskForWahlgebiet();
		AskFor<Wahldaten> askForWahldaten = new AskForWahldaten();

		Integrator<FeatureCollection> integrator = new WahldatenIntegrator(askForWahlgebiet.getData(),
				askForWahldaten.getData());
		this.featureCollection = integrator.getData();
	}

	public StimmbezirkeGeoJsonFacade(FeatureCollection featureCollection, Wahldaten wahldaten)
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {

		Integrator<FeatureCollection> integrator = new WahldatenIntegrator(featureCollection, wahldaten);
		this.featureCollection = integrator.getData();
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this.featureCollection);
	}

}
