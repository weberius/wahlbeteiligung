package de.illilli.opendata.service.wahlbeteiligung;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.geojson.FeatureCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahldaten;
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahlgebiet;
import de.illilli.opendata.service.wahlbeteiligung.model.Wahldaten;

public class StimmbezirkeGeoJsonFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws JsonSyntaxException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/wahldaten.stimmbezirke.koeln.json");
		AskFor<Wahldaten> askFor = new AskForWahldaten(inputStream);
		Wahldaten wahldaten = askFor.getData();

		InputStream input = this.getClass().getResourceAsStream("/wahlgebiet.stimmbezirke.koeln.geojson");
		AskFor<FeatureCollection> askfor = new AskForWahlgebiet(input);
		FeatureCollection featureCollection = askfor.getData();

		Facade facade = new StimmbezirkeGeoJsonFacade(featureCollection, wahldaten);
		// check first feature only
		String actual = facade.getJson().substring(0, 13228);
		String expected = IOUtils
				.toString(this.getClass().getResourceAsStream("/wahlgebiet.wahlbeteiligung.koeln.json"));

		Assert.assertEquals(expected, actual);
	}

}
