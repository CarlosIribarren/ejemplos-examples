package oiasso.system.listadocoches.api.coche.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class SwaggerPageable {
		
	    @ApiModelProperty(value = "Tamaño de la pagina que queremos obtener", example = "10")
	    private Integer size;
	    
	    @ApiModelProperty(value = "Pagina de registros que queremos obtener (0..N)", example = "0")
	    private Integer page;
	    		
	    @ApiModelProperty(value = "Criterios de ordenacion en el formato: propiedad(,asc|desc). El orden de clasificación predeterminado es ascendente. Se admiten varios criterios de ordenacion.", example = "idPuntoRecarga,asc")
	    private String sort;

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}
	    
}




