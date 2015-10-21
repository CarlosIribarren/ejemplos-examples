	function comprobar_Combo()
	{
	    var selected_Index = document.getElementById("c_provincia").selectedIndex;
	    var options = document.getElementById("c_provincia").options;
	    alert("Index: " + options[selected_Index].index + " is " + options[selected_Index].text);
		
		if(options[selected_Index].text == "Ceuta"  )
		{
				alert("Se ha seleccionado Ceuta");
		}
		
	}
