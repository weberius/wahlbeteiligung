package de.illilli.opendata.service.wahlbeteiligung.model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.geojson.FeatureCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Integrator;
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahldaten;
import de.illilli.opendata.service.wahlbeteiligung.askfor.AskForWahlgebiet;

public class WahldatenIntegratorTest {

	private static final Logger logger = Logger.getLogger(WahldatenIntegratorTest.class);

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

		Integrator<FeatureCollection> integrator = new WahldatenIntegrator(featureCollection, wahldaten);
		FeatureCollection data = integrator.getData();

		logger.info(data.toString());
	}

}
