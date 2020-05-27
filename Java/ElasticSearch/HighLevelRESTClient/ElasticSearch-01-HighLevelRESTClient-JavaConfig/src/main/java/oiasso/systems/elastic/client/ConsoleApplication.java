package oiasso.systems.elastic.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oiasso.systems.elastic.client.facade.SpotFacade;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

	@Autowired
	private SpotFacade spotFacade;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConsoleApplication.class);
		// disable spring banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.spotFacade.buscarDispositivosDeUnAnuncio("Coca Cola");
		this.spotFacade.buscarPorDispositivo("ctsdem01");
		this.spotFacade.obtenerTodoLosDocumentos();
	}

}
