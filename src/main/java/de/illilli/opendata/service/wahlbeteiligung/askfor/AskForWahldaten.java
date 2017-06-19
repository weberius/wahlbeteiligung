package de.illilli.opendata.service.wahlbeteiligung.askfor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.wahlbeteiligung.model.Wahldaten;

public class AskForWahldaten implements AskFor<Wahldaten> {

	private Wahldaten data;

	/**
	 * Der Standartkonstruktor ruft die entfernte Schnittstelle Wahlergebnis auf
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public AskForWahldaten() throws MalformedURLException, IOException {
		this(new URL(Config.getProperty("wahlergebnis.stimmbezirke.koeln")).openStream());
	}

	AskForWahldaten(InputStream input) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		this.data = gson.fromJson(IOUtils.toString(input), Wahldaten.class);
	}

	@Override
	public Wahldaten getData() {
		return data;
	}
}
