package oiasso.systems.elastic.client.facade;

import java.io.IOException;

public interface SpotFacade {
	void buscarDispositivosDeUnAnuncio(String paramString) throws IOException;

	void buscarPorDispositivo(String paramString) throws IOException;

	void obtenerTodoLosDocumentos() throws IOException;

	void obtenerTodosLosAnuncios() throws IOException;
}
