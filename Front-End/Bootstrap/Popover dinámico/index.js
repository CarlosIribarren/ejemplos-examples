$(document).ready(function () {

	/*
		To get the popover element:
		
			- To work in Bootstrap 2.x ==>> $('#my_awesome_element').data('popover');
			- To work in Bootstrap 3   ==>> $('#my_awesome_element').data('bs.popover');
	*/
	
	/*

		// Inicializar para que cuando se pase el mouse por encima salga en mensaje
		$('#panelBotonFiltrado').popover({
			trigger : "hover"
		});
	
		// Inicializar para que en el content se pueda poner HTML
		$('#panelBotonFiltrado').popover({
			html : 'true',
			trigger : "hover"
		});
		
	*/
	
	//Inicializar el popover
	$('#example').popover({
		title: 'Test',
		content: 'Hello Popover',
		placement: 'bottom',
		trigger: "hover"
	});
	
	
	$( "#cambiarPopOver1" ).click(function() {
		
		var popover = $('#example').data('popover');
		popover.options.title = "Titulo1";
        popover.options.content = "Texto1";
	  
	});

	$( "#cambiarPopOver2" ).click(function() {
		
		var popover = $('#example').data('popover');
        popover.options.title = "Titulo2";
        popover.options.content = "Texto2";

	  
	});
	
	
});