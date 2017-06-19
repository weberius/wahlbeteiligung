package de.illilli.opendata.service.wahlbeteiligung.askfor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

public class AskForWahlgebiet implements AskFor<FeatureCollection> {

	private FeatureCollection featureCollection = new FeatureCollection();
	
	public AskForWahlgebiet() throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		this(new URL(Config.getProperty("wahlgebiet.stimmbezirke.koeln.geojson")).openStream());
	}
	
	public AskForWahlgebiet(InputStream inputStream) throws JsonParseException, JsonMappingException, IOException {
		featureCollection = new ObjectMapper().readValue(inputStream, FeatureCollection.class);
	}

	@Override
	public FeatureCollection getData() {
		return this.featureCollection;
	}

}
