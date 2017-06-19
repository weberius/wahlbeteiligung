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
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahlgebiet;

public class StimmbezirkeGeoJsonFacade implements Facade {
	
	private FeatureCollection featureCollection = new FeatureCollection();
	
	public StimmbezirkeGeoJsonFacade() throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
		AskFor<FeatureCollection> askForWahlgebiet = new AskForWahlgebiet();
		featureCollection = askForWahlgebiet.getData();
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
