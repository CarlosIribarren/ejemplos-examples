package oiasso.system.listadocoches.datatables.front.controller;

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

import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.datatables.front.beans.FiltroCoche;
import oiasso.system.listadocoches.datatables.front.exception.ListadoCochesRestApiException;
import oiasso.system.listadocoches.datatables.front.generics.DataTablesOutput;
import oiasso.system.listadocoches.datatables.front.services.CocheService;
import oiasso.system.listadocoches.datatables.front.utils.DataTableUtils;

@Controller
public class CocheController {

	// *********************
	// ***** Constantes ****
	// *********************

	private static final Logger LOG = LoggerFactory.getLogger(CocheController.class);

	// *********************
	// ***** Atributos *****
	// *********************

	@Autowired
	private CocheService cocheService;

	// *********************
	// ***** Metodos *******
	// *********************

	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("filtroCoches", new FiltroCoche());
		return "inicio";
	}

	@PostMapping(value = "/cargar-datos-de-coches", headers = "x-requested-with=XMLHttpRequest")
	public ResponseEntity<DataTablesOutput<Coche>> getCochesFiltered(HttpServletRequest request,
			@RequestParam(value = "draw", required = true, defaultValue = "1") Integer draw,
			@RequestParam(value = "start", required = true, defaultValue = "1") Integer primerElementoDeLaPagina,
			@RequestParam(value = "length", required = true, defaultValue = "1") Integer elementosPorPagina,
			@RequestParam(value = "search[value]", required = true, defaultValue = "1") String searchValue,
			@RequestParam(value = "order[0][column]", required = true, defaultValue = "1") String sortColumnIndex,
			@RequestParam(value = "order[0][dir]", required = true, defaultValue = "1") String sortDirection,
			@Valid @ModelAttribute FiltroCoche filtroCoche, BindingResult bindingResult) 
	{

		if(bindingResult.hasErrors()) {
			DataTablesOutput<Coche> dataTablesOutput = new DataTablesOutput<>("Error, la fecha de fin tiene que ser superior a la de inicio.", draw);
			return new ResponseEntity<>(dataTablesOutput, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
			// Datos para el paginado
			String sortColumnName = request.getParameter("columns[" + sortColumnIndex + "][data]");
			Integer numeroDePagina = DataTableUtils.calcularNumeroDePagina(primerElementoDeLaPagina, elementosPorPagina);

			ResponseEntity<PagedModel<Coche>> response;
			
			try {
				// Obtener coches
				response = cocheService.getCochesFiltered(elementosPorPagina, sortDirection, sortColumnName, numeroDePagina, filtroCoche);
			} catch (ListadoCochesRestApiException e) {
				LOG.error("Error al obtener el listado de coches. Error on request: {} .Message: {} ", request.getRequestURL(), e.getMessage() );
				DataTablesOutput<Coche> dataTablesOutput = new DataTablesOutput<>("Error al obtener el listado de coches", draw);
				return new ResponseEntity<>(dataTablesOutput, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			// Crear DataTablesOutput
			DataTablesOutput<Coche> dataTablesOutput = new DataTablesOutput<>(response.getBody(), draw);
			return new ResponseEntity<>(dataTablesOutput, HttpStatus.OK);
	}

	@PostMapping(value = "/validarFiltro", headers = "x-requested-with=XMLHttpRequest")
	@ResponseBody
	public List<ObjectError> validarFilrto(@Valid @ModelAttribute FiltroCoche filtroCoche,
			BindingResult bindingResult) {
		return bindingResult.getAllErrors();
	}

}
