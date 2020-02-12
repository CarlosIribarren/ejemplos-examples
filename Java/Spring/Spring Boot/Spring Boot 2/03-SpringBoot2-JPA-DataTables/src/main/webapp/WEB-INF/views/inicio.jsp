<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- CSS bootstrap -->
<link rel="stylesheet" type="text/css" href="/estatico/terceros/Bootstrap-4.4.1/css/bootstrap.min.css"/>

<!-- CSS datatables -->
<link rel="stylesheet" type="text/css" href="/estatico/terceros/DataTables-1.10.20/css/dataTables.bootstrap4.min.css">


<!-- JS jquery -->
<script type="text/javascript" charset="utf8" src="/estatico/terceros/Query-3.4.1/js/jquery-3.4.1.min.js"></script>
<!-- JS bootstrap -->
<script type="text/javascript" charset="utf8" src="/estatico/terceros/Bootstrap-4.4.1/js/bootstrap.min.js"></script>
<!-- JS datatables -->
<script type="text/javascript" charset="utf8" src="/estatico/terceros/DataTables-1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="/estatico/terceros/DataTables-1.10.20/js/dataTables.bootstrap4.min.js"></script>






<script type="text/javascript">
$(document).ready( function () {
    $('#tabla-personas').DataTable({
    	
    	//Ajax sourced data is much like Javascript sourced data, but DataTables will make an Ajax call to get the data for you
    	ajax: {
        	url: '/api/personas',
        	dataSrc: '' //As a function dataSrc provides the ability to manipulate the data returned from the server from one form into another. For example, if your data is split over multiple arrays you might combine it into a single array to return for processing and display by DataTables.
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
        ]

    });
} );
</script>

</head>
<body>

	<table id="tabla-personas" class="table display"></table>



</body>

</html>
