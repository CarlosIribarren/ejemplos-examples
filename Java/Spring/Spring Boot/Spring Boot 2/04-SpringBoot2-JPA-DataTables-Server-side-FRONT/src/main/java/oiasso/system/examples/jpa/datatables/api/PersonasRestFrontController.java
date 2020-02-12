package oiasso.system.examples.jpa.datatables.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import oiasso.system.examples.jpa.datatables.helpers.DataTablesPersonaOutput;
import oiasso.system.examples.jpa.datatables.helpers.FiltroPersonas;
import oiasso.system.examples.jpa.datatables.helpers.RestResponsePersonaPage;
import oiasso.system.examples.jpa.datatables.utils.DataTableUtils;

@RestController
public class PersonasRestFrontController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonasRestFrontController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/validarFiltro", method = RequestMethod.POST, headers = "x-requested-with=XMLHttpRequest")
	@ResponseBody
	public List<ObjectError> validarFilrto(@Valid @ModelAttribute FiltroPersonas filtroPersonas,
			BindingResult bindingResult) {
		return bindingResult.getAllErrors();
	}

	/**
	 * Para el binding de la clse los datos llegan con el siguiente formato:
	 * {"fechaInicio":"2000-10-31","fechaFin":"2000-10-31" } Si se consigue que se
	 * rellene solo el objeto de FiltroPersonas.
	 */
	@RequestMapping(value = "/cargar-datos-de-personas", method = RequestMethod.POST, headers = "x-requested-with=XMLHttpRequest")
	public ResponseEntity<DataTablesPersonaOutput> findAll(HttpServletRequest request,
			@RequestParam(value = "draw", required = true, defaultValue = "1") Integer draw,
			@RequestParam(value = "start", required = true, defaultValue = "1") Integer primerElementoDeLaPagina,
			@RequestParam(value = "length", required = true, defaultValue = "1") Integer elementosPorPagina,
			@RequestParam(value = "search[value]", required = true, defaultValue = "1") String searchValue,
			@RequestParam(value = "order[0][column]", required = true, defaultValue = "1") String sortColumnIndex,
			@RequestParam(value = "order[0][dir]", required = true, defaultValue = "1") String sortDirection,
			@Valid @ModelAttribute FiltroPersonas filtroPersonas, BindingResult bindingResult) {

		try {

			String sortColumnName = (String) request.getParameter("columns[" + sortColumnIndex + "][data]");

			Integer numeroDePagina = DataTableUtils.calcularNumeroDePagina(primerElementoDeLaPagina,
					elementosPorPagina);

			// Llamar un servicio REST y devolver el resultado
			// Execute the request specified in the given RequestEntity and returnthe
			// response as ResponseEntity. The given ParameterizedTypeReference is used to
			// pass generic type information

			ResponseEntity<RestResponsePersonaPage> response = obtenerPersonasPaginado(elementosPorPagina,
					sortDirection, sortColumnName, numeroDePagina, filtroPersonas);

			// Respuesta
			RestResponsePersonaPage responsePersonaPage = response.getBody();
			DataTablesPersonaOutput dataTablesOutput = new DataTablesPersonaOutput(responsePersonaPage, draw);

			return new ResponseEntity<DataTablesPersonaOutput>(dataTablesOutput, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error en la llamda [/cargar-datos-de-personas] ", e);
			return new ResponseEntity<DataTablesPersonaOutput>(new DataTablesPersonaOutput(draw),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ResponseEntity<RestResponsePersonaPage> obtenerPersonasPaginado(Integer elementosPorPagina,
			String sortDirection, String sortColumnName, Integer numeroDePagina, FiltroPersonas filtroPersonas)
			throws URISyntaxException {
		URI url = new URI("http://localhost:8081/api/personas");
		HttpHeaders headers = new HttpHeaders();
		headers.set("page", numeroDePagina.toString());
		headers.set("size", elementosPorPagina.toString());
		headers.set("sortColumnName", sortColumnName);
		headers.set("sortDirection", sortDirection);

		LocalDate fFechaInicio = filtroPersonas.getFechaInicio();
		if (fFechaInicio != null) {
			headers.set("fechaInicio", fFechaInicio.toString());
		}
		LocalDate fFechaFin = filtroPersonas.getFechaFin();
		if (fFechaFin != null) {
			headers.set("fechaFin", fFechaFin.toString());
		}

		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		final ParameterizedTypeReference<RestResponsePersonaPage> responseType = new ParameterizedTypeReference<RestResponsePersonaPage>() {
		};
		ResponseEntity<RestResponsePersonaPage> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				responseType);
		return response;
	}

}
