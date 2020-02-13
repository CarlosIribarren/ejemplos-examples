$(document).ready( function () {
	
	// Inicializar Datetimepicker
	$('#datetimepickerInicio').datetimepicker({
		locale: 'es',
		format : 'YYYY-MM-DD'
	});
	$('#datetimepickerFin').datetimepicker({
		useCurrent : false,
		locale: 'es',
		format : 'YYYY-MM-DD'				
	});
	// Registrir fechas en funcion de lo elegido en el otro Datetimepicker
	$("#datetimepickerInicio").on("change.datetimepicker", function(e) {
		$('#datetimepickerFin').datetimepicker('minDate', e.date);
	});
	$("#datetimepickerFin").on("change.datetimepicker", function(e) {
		$('#datetimepickerInicio').datetimepicker('maxDate', e.date);
	});	
	
	// Quitar filtro
	$( "#quitarFiltroBoton").click(function() {

		// Borrar datos del filtro
		$('#fechaInicio').val('');
		$('#fechaFin').val('');

		// Volver cargar los datos llamando al metodo AJAX  
		var table = $('#tabla-coches').DataTable();
		table.ajax.reload();

		// Ocultar boton de quitar filtros
		$('#quitarFiltroBoton').addClass("d-none");

	});


	// Filtrado
	$("#filtroCochesForm").submit(function() {

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
					var table = $('#tabla-coches').DataTable();
					table.ajax.reload();

					// Quitar estilos de los errores
					$('.filtro-input').removeClass("is-invalid");
					$('.filtro-input-error').hide();
					$('.filtro-input-error').text("");
					$('.filtro-input').removeClass("text-danger");


					if($('#fechaInicio').val() != '' && $('#fechaFin').val() != '' ){
						// Mostrar boton de quitar filtros
						$('#quitarFiltroBoton').removeClass("d-none");
					} else {
						// Ocultar boton de quitar filtros
						$('#quitarFiltroBoton').addClass("d-none");
					}



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
							$('#' + errorField + "-error").text( textoErrorActual + errorMessage + ". ");
						}

						$('#' + errorField + "-error").show();
						$('#' + errorField + "-error").addClass("text-danger");

					}
				}

			} 

		});



		return false;
	});

	// Iniciar el DataTables
	$('#tabla-coches').DataTable({
		responsive: true,
		serverSide: true,
		processing: true, 	
		searching: false,
		//Cuando hacemos un post, se envia datos como la pagina, el numero de elementos por pagina, la busqueda,...
		ajax: {
			url: '/cargar-datos-de-coches',
			type: "POST",
			data:  function ( d ) { // Se añaden datos al los datos que se envian por defecto
				return $.extend( {}, d, {
					"fechaInicio": $('#fechaInicio').val(),
					"fechaFin": $('#fechaFin').val(),
				} );
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert("Se ha producido un error :" + jqXHR.responseJSON.error);
				$('#tabla-coches_processing').hide();
		    },
			datatype: "json",
			dataSrc: "data", // Se indica donde esta el array de los datos, en este caso en la etiqueta data
		},
		columns: [
			{
				title: 'Matricula',
				data: "matricula"
			},
			{
				title: 'Marca',
				data: "marca"
			},
			{
				title: 'Modelo',
				data: "modelo"
			},   
			{
				title: 'Fecha de matriculacion',
				data: "fechaMatriculacion"
			},
			{
				title: 'Motor',
				data: "motor"
			} 			
			],
			language: {
				sProcessing:     "Procesando...",
				sLengthMenu:     "Mostrar _MENU_ registros",
				sZeroRecords:    "No se encontraron resultados",
				sEmptyTable:     "Ningún dato disponible en esta tabla =(",
				sInfo:           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				sInfoEmpty:      "Mostrando registros del 0 al 0 de un total de 0 registros",
				sInfoFiltered:   "",
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