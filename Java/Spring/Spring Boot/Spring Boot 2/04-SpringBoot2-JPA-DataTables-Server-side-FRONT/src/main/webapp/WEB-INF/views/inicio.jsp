<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>

<!-- CSS bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/estatico/terceros/Bootstrap-4.4.1/css/bootstrap.min.css" />
<!-- CSS datatables -->
<link rel="stylesheet" type="text/css"
	href="/estatico/terceros/DataTables-1.10.20/css/dataTables.bootstrap4.min.css">

<link
	href="/estatico/terceros/fontawesome-free-5.12.0-web/css/all.min.css"
	rel="stylesheet">

<!-- CSS tempusdominus -->
<link rel="stylesheet" type="text/css"
	href="/estatico/terceros/TempusDominusBootstrap4-Version5/css/tempusdominus-bootstrap-4.min.css">




<!-- JS jquery -->
<script type="text/javascript" charset="utf8"
	src="/estatico/terceros/Query-3.4.1/js/jquery-3.4.1.min.js"></script>
	
<!-- JS bootstrap -->
<script type="text/javascript" charset="utf8"
	src="/estatico/terceros/Bootstrap-4.4.1/js/bootstrap.min.js"></script>

<!-- JS datatables -->
<script type="text/javascript" charset="utf8"
	src="/estatico/terceros/DataTables-1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8"
	src="/estatico/terceros/DataTables-1.10.20/js/dataTables.bootstrap4.min.js"></script>
<!-- JS datatable configuracion -->
<script type="text/javascript" charset="utf8"
	src="/estatico/js/datatable-configuracion.js"></script>




<script type="text/javascript" charset="utf8"
	src="/estatico/terceros/Moment-2.24.0/js/moment-with-locales.min.js"></script>

<script type="text/javascript" charset="utf8"
	src="/estatico/terceros/TempusDominusBootstrap4-Version5/js/tempusdominus-bootstrap-4.min.js"></script>
	
	
	


<script type="text/javascript">
	$(document).ready(function() {
		$('#datetimepickerInicio').datetimepicker({
			format : 'L',
			locale: 'es',
	        format : 'YYYY-MM-DD'
		});
		$('#datetimepickerFin').datetimepicker({
			useCurrent : false,
			format : 'L',
			locale: 'es',
		    format : 'YYYY-MM-DD'				
		});
// 		$("#datetimepickerInicio").on("change.datetimepicker", function(e) {
// 			$('#datetimepickerFin').datetimepicker('minDate', e.date);
// 		});
// 		$("#datetimepickerFin").on("change.datetimepicker", function(e) {
// 			$('#datetimepickerInicio').datetimepicker('maxDate', e.date);
// 		});




		
	});
</script>

    <style>
    	.error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>

</head>
<body>


	<div class="container mt-5">
		<div class="row">
			<h1>Listado de personas</h1>
		</div>


		<!-- BOTONES FILTRO -->
		<button id="quitarFiltroBoton" type="button" class="btn btn-primary float-right d-none">
			<span class="fa fa-times"></span>
		</button>

		<button type="button" class="btn btn-primary float-right"
			data-toggle="modal" data-target="#exampleModal">
			<span class="fa fa-search"></span> Filtrar
		</button>


		<table id="tabla-personas" class="table display table-striped"></table>


	</div>

	<!-- FILTRO -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<form:form action="/personas" method="POST" modelAttribute="filtroPersonas" role="form" id="filtroPersonasForm" >

					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Filtar</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
	
	
						<div class="form-group">
							<label for="exampleDropdownFormEmail1">Fecha inicio</label>
	
							<!-- Datetimepicker Inicio -->
							<div class="input-group date" id="datetimepickerInicio" data-target-input="nearest">
								<form:input id="fechaInicio" path="fechaInicio" type="text" class="form-control datetimepicker-input filtro-input" data-target="#datetimepickerInicio" />
										
								
								<div class="input-group-append" data-target="#datetimepickerInicio" data-toggle="datetimepicker">
									<div class="input-group-text">
										<i class="fa fa-calendar"></i>
									</div>
								</div>
							</div>
							<span id="fechaInicio-error" class="filtro-input-error"></span>
	
	
						</div>
						<div class="form-group">
							<label for="exampleDropdownFormPassword1">Fecha fin</label>
	
							<!-- Datetimepicker Fin -->
							<div class="input-group date" id="datetimepickerFin" data-target-input="nearest">
								<form:input id="fechaFin"  path="fechaFin" class="form-control datetimepicker-input filtro-input" data-target="#datetimepickerFin" />
								<div class="input-group-append" data-target="#datetimepickerFin" data-toggle="datetimepicker">
									<div class="input-group-text">
										<i class="fa fa-calendar"></i>
									</div>
								</div>
							</div>
						</div>
						<span id="fechaFin-error" class="filtro-input-error text-danger"></span>
	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
						<button id="aplicarFiltro" type="submit" class="btn btn-primary" >Aplicar</button>
					</div>


				</form:form>
			</div>
		</div>
	</div>


</body>
</html>
