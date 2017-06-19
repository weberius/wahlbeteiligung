package de.illilli.opendata.service.wahlbeteiligung.askfor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlbeteiligung.model.Wahldaten;

public class AskForWahlergebnisTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws MalformedURLException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/wahldaten.stimmbezirke.koeln.json");
		AskFor<Wahldaten> askFor = new AskForWahlergebnis(inputStream);
		Wahldaten wahldaten = askFor.getData();
		System.out.println(wahldaten.toString());
	}

}
