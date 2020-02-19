$(document).ready( function () {

	$( "#quitarFiltroBoton").click(function() {
		$('#fechaInicio').val('');
		$('#fechaFin').val('');
		// Volver cargar los datos llamando al metodo AJAX  
		var table = $('#tabla-personas').DataTable();
		table.ajax.reload();

		// Ocultar boton de quitar filtros
		$('#quitarFiltroBoton').addClass("d-none");
	});


	// Para que EN el submit del filtro se ejecute en un div
	$("#filtroPersonasForm").submit(function() {

		// Si ha introducido las fecha de inicio y fin
		if($('#fechaInicio').val() != '' && $('#fechaFin').val() != '' ){

			$.ajax({
				type : "POST",
				url : "/validarFiltro",
				data : $(this).serialize(),
				complete : function(response) {

					var errorsText = response.responseText;
					var errorsJson = response.responseJSON;

					if(errorsText == "[]"){

						// No hay errores

						// Cerrar el modal del filtro
						$("#exampleModal").modal("hide");

						// Volver cargar los datos llamando al metodo AJAX  
						var table = $('#tabla-personas').DataTable();
						table.ajax.reload();

						// Quitar estilos de los errores
						$('.filtro-input').removeClass("is-invalid");
						$('.filtro-input-error').hide();
						$('.filtro-input-error').text("");
						$('.filtro-input').removeClass("text-danger");

						// Mostrar boton de quitar filtros
						$('#quitarFiltroBoton').removeClass("d-none");




					} else {

						// Mostrar los errores encontrados
						for (var i = 0; i < errorsJson.length; i++){
							var obj = errorsJson[i];
							var errorField = obj.field;
							var errorMessage = obj.code;
							// Aplicar estilo a los errores
							$('#' + errorField).addClass("is-invalid");

							// Se concatenan los errores por si hay mas de un error para un input
							var textoErrorActual = $('#' + errorField + "-error").text();
							if (textoErrorActual.indexOf(errorMessage) == -1){
								$('#' + errorField + "-error").text( textoErrorActual + ". " + errorMessage);
							}

							$('#' + errorField + "-error").show();
							$('#' + errorField + "-error").addClass("text-danger");

						}
					}

				} 

			});

		} else {

			// Si no ha introducido las las fechas de inicio y fin, se cierra el modal

			// Cerrar el modal del filtro
			$("#exampleModal").modal("hide");
		}

		return false;
	});

	// El JSON que se envia tiene que tener el siguiente formato (nombre de variables y los datos entre comillas)
	// {"fechaInicio":"2000-10-31","fechaFin":"2000-10-31" }
	// 
	// Modo 1 (mal)
	// ------------
	// Si para enviar los datos se utiliza $('#filtroPersonasForm').serializeArray() el resultado es el siguiente:
	// 0: {name: "fechaInicio", value: "2020-01-16"}
	// 1: {name: "fechaFin", value: ""}
	// 
	// Modo 2 (mal)
	// ------------
	// Si para enviar los datos se utiliza $('#filtroPersonasForm').serialize() el resultado es el siguiente:
	// fechaInicio=2020-01-16&fechaFin=
	// 
	// Modo 3: (bien)
	// --------------
	// Se añaden datos al los datos que se envian por defecto. De esta manera se consigue enviar los datos correctamente y rellenados.
	//
	// $('#example').dataTable( {
	// "ajax": {
	//	    "url": "data.json",
	//	    "data": function ( d ) {
	//	      return $.extend( {}, d, {
	//	        "extra_search": $('#extra').val()
	//	      } );
	//	    }
	//	  }
	//	} );



	// Iniciar el DataTables
	$('#tabla-personas').DataTable({
		responsive: true,
		serverSide: true,
		processing: true, 	
		searching: false,
		//Cuando hacemos un post, se envia datos como la pagina, el numero de elementos por pagina, la busqueda,...
		ajax: {
			url: '/cargar-datos-de-personas',
			type: "POST",
			data:  function ( d ) { // Se añaden datos al los datos que se envian por defecto
				return $.extend( {}, d, {
					"fechaInicio": $('#fechaInicio').val(),
					"fechaFin": $('#fechaFin').val(),
				} );
			},
			datatype: "json",
			dataSrc: 'data' // Definir el nombre de donde se obtienen los datos
		},
		columns: [
			{
				title: 'id',
				data: "id"
			},
			{
				title: 'Nombre',
				data: "nombre"
			},
			{
				title: 'Fecha',
				data: "fecha"
			}    
			],
			language: {
				sProcessing:     "Procesando...",
				sLengthMenu:     "Mostrar _MENU_ registros",
				sZeroRecords:    "No se encontraron resultados",
				sEmptyTable:     "Ningún dato disponible en esta tabla =(",
				sInfo:           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				sInfoEmpty:      "Mostrando registros del 0 al 0 de un total de 0 registros",
				sInfoFiltered:   "(filtrado de un total de _MAX_ registros)",
				sInfoPostFix:    "",
				sSearch:         "Buscar:",
				sUrl:            "",
				sInfoThousands:  ",",
				sLoadingRecords: "Cargando...",
				oPaginate: {
					sFirst:    "Primero",
					sLast:     "Último",
					sNext:     "Siguiente",
					sPrevious: "Anterior"
				},
				oAria: {
					sSortAscending:  ": Activar para ordenar la columna de manera ascendente",
					sSortDescending: ": Activar para ordenar la columna de manera descendente"
				},
				buttons: {
					copy: "Copiar",
					colvis: "Visibilidad"
				}
			}

	} );


} );