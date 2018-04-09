/**
 * 
 */
package es.eurohelp.cursos.springmvc.argumentresolvers;

import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

/**
 * Argument resolver para obtener el objeto IdDeclaracion a partir del id y el ejercicio que viene en la url. 
 * Lo usarán todos los controllers de los modelos ZergaBidea, declarado a través de la clase de 
 * configuración {@link ModeloWebMvc}
 * 
 * De esta forma, mediante una url del tipo "/180/{modelo}/{idDeclaracion}/arrendador" el método del controller con un atributo 
 * del tipo IdDeclaracion y este se cargará automáticamente. 
 * 
 * 	@RequestMapping(value = "/new", method = RequestMethod.POST)
 * 	public String newArrendador(	IdDeclaracion idDeclaracion,
 * 									@Validated @ModelAttribute Arrendador arrendador,....){ 
 * 									
 * 	
 *
 */
public class IdEstudianteArgumentResolver implements HandlerMethodArgumentResolver {

	/* (non-Javadoc)
	 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#resolveArgument(org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest, org.springframework.web.bind.support.WebDataBinderFactory)
	 */
	@Override
	public Object resolveArgument(	MethodParameter methodParameter,
						            ModelAndViewContainer modelAndViewContainer,
						            NativeWebRequest nativeWebRequest,
						            WebDataBinderFactory webDataBinderFactory) throws Exception {
        
		//Se obtienen las variables de la url
		@SuppressWarnings("unchecked")
		Map<String, String> uriTemplateVars = (Map<String, String>) nativeWebRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);

		
		//Se recuperan las variables idDeclaracion y ejercicio de la url
		String idDeclaracion = uriTemplateVars.get("idDeclaracion");
		String ejercicio = uriTemplateVars.get("ejercicio");

        
		//Se crea y se devuelve el objeto idDeclaracion
		return new IdEstudiante(Integer.parseInt(ejercicio), Integer.parseInt(idDeclaracion));
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#supportsParameter(org.springframework.core.MethodParameter)
	 */
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(IdEstudiante.class);
	}

}
