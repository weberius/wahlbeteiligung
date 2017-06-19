package de.illilli.opendata.service.wahlbeteiligung.askfor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.geojson.FeatureCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.AskFor;

public class AskForWahlgebietTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = this.getClass().getResourceAsStream("/wahlgebiet.stimmbezirke.koeln.geojson");
		AskFor<FeatureCollection> askfor = new AskForWahlgebiet(input);
		FeatureCollection featureCollection = askfor.getData();
		int expected = 800;
		int actual = featureCollection.getFeatures().size();
		Assert.assertEquals(expected, actual);
	}

}
