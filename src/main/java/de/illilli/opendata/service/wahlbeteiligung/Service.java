package de.illilli.opendata.service.wahlbeteiligung;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.DefaultFacade;
import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);
	public static final String ENCODING = Config.getProperty("encoding");

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Diese Schnittstelle erlaubt es zu prüfen, ob der Service generell
	 * erreichbar ist. die zu erwartende Antwort lautet
	 * </p>
	 * 
	 * <pre>
	 * {"level":"info","msg":"alive"}
	 * </pre>
	 *
	 * <p>
	 * Beispiel: <a href="http://localhost:8080/wahlbeteiligung/service/ping">
	 * /wahlbeteiligung/service/ping</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/ping")
	public String ping() throws JsonProcessingException {
		Facade facade = new DefaultFacade(DefaultFacade.INFO, "alive");
		return facade.getJson();
	}

	/**
	 * Beispiel:
	 * <ul>
	 * <li><a href="http://localhost:8080/wahlbeteiligung/service/stimmbezirke">
	 * /wahlbeteiligung/service/stimmbezirke</a></li>
	 * <li><a href=
	 * "http://localhost:8080/wahlbeteiligung/service/stimmbezirke?format=geojson">
	 * /wahlbeteiligung/service/stimmbezirke?format=geojson</a></li>
	 * </ul>
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stimmbezirke")
	public String getStimmbezirke() throws MalformedURLException, IOException {
		String format = request.getParameter("format");
		Facade facade = null;
		if ("geojson".equals(format)) {
			logger.info("calling '/wahlbeteiligung/service/stimmbezirke?format=geojson'");
			facade = new StimmbezirkeGeoJsonFacade();
		} else {
			logger.info("calling '/wahlbeteiligung/service/stimmbezirke'");
			facade = new DefaultFacade(DefaultFacade.INFO, "please use format geojson");
		}
		return facade.getJson();
	}

}
