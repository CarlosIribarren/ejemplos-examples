package oiasso.systems.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/")
public class RespuestaController {

	
	@GetMapping("respuesta")
	public Respuesta<Void> getRespuesta() throws Exception {

		Respuesta<Void> r = new Respuesta<Void>();
		r.setStatusCode(1000);
		r.setStatusMessage("message");
		r.setTimestamp(LocalDateTime.now());

		return r;
	}
	
}
