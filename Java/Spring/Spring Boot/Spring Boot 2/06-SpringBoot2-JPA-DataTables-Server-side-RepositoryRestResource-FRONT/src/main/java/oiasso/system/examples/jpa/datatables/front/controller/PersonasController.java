package oiasso.system.examples.jpa.datatables.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import oiasso.system.examples.jpa.datatables.back.beans.Persona;
import oiasso.system.examples.jpa.datatables.front.helpers.DataTablesOutput;
import oiasso.system.examples.jpa.datatables.front.helpers.FiltroPersonas;
import oiasso.system.examples.jpa.datatables.front.services.PersonaService;
import oiasso.system.examples.jpa.datatables.front.utils.DataTableUtils;

@Controller
public class PersonasController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonasController.class);

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("filtroPersonas", new FiltroPersonas());
		return "inicio";
	}

	/**
	 * Para el binding de la clse los datos llegan con el siguiente formato:
	 * {"fechaInicio":"2000-10-31","fechaFin":"2000-10-31" } Si se consigue que se
	 * rellene solo el objeto de FiltroPersonas.
	 */
	@PostMapping(value = "/cargar-datos-de-personas", headers = "x-requested-with=XMLHttpRequest")
	public ResponseEntity<DataTablesOutput<Persona>> findAll(HttpServletRequest request,
			@RequestParam(value = "draw", required = true, defaultValue = "1") Integer draw,
			@RequestParam(value = "start", required = true, defaultValue = "1") Integer primerElementoDeLaPagina,
			@RequestParam(value = "length", required = true, defaultValue = "1") Integer elementosPorPagina,
			@RequestParam(value = "search[value]", required = true, defaultValue = "1") String searchValue,
			@RequestParam(value = "order[0][column]", required = true, defaultValue = "1") String sortColumnIndex,
			@RequestParam(value = "order[0][dir]", required = true, defaultValue = "1") String sortDirection,
			@Valid @ModelAttribute FiltroPersonas filtroPersonas, BindingResult bindingResult) {

		try {

			// Datos para el paginado
			String sortColumnName = request.getParameter("columns[" + sortColumnIndex + "][data]");
			Integer numeroDePagina = DataTableUtils.calcularNumeroDePagina(primerElementoDeLaPagina,
					elementosPorPagina);

			// Obtener personas
			ResponseEntity<PagedModel<Persona>> response = personaService.getPersonasFiltered(elementosPorPagina,
					sortDirection, sortColumnName, numeroDePagina, filtroPersonas);

			// Crear DataTablesOutput
			DataTablesOutput<Persona> dataTablesOutput = new DataTablesOutput<>(response.getBody(), draw);

			return new ResponseEntity<>(dataTablesOutput, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Error en la llamda [/cargar-datos-de-personas] ", e);
			DataTablesOutput<Persona> dataTablesOutput = new DataTablesOutput<>("error", draw);
			return new ResponseEntity<>(dataTablesOutput, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/validarFiltro", headers = "x-requested-with=XMLHttpRequest")
	@ResponseBody
	public List<ObjectError> validarFilrto(@Valid @ModelAttribute FiltroPersonas filtroPersonas,
			BindingResult bindingResult) {
		return bindingResult.getAllErrors();
	}

}
