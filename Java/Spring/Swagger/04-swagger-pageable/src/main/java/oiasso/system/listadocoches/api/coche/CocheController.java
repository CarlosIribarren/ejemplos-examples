package oiasso.system.listadocoches.api.coche;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/api/coche")
public class CocheController {

	private CocheService cocheService = new CocheService(); 
	
    /**
     * No hace falta recibir los parametros de size, page,... como @RequestParam(value = "page") Integer page...
     * Si vienen en la URL, Spring MVC hace el binding de esos parametros por nosotros en la clase Pageable.
     */
	@GetMapping("")
	@ApiOperation(value = "Obtener un listado paginado de coches", notes = "Retorna un listado paginado de coches" )
	public Page<Coche> findAll(Pageable pageable) {
		return cocheService.findAll(pageable);
	}
	
	
}
