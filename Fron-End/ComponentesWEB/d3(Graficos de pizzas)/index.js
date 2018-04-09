window.onload = function() {
	if ($("#chart2").length && '${action.pieChartData}') {
		PieChart().loadChart(JSON.parse('${action.pieChartData}'),"#chart2");
	}
	if ($("#chart1").length && '${action.pieChartGender}') {
		PieChart().loadChart(JSON.parse('${action.pieChartGender}'),"#chart1");
	}
	if ($("#chartEdad").length && '${action.pieChartEdad}') {
		PieChart().loadChart(JSON.parse('${action.pieChartEdad}'),"#chartEdad");
	}
	
	if ($("#chartBarrio").length && '${action.pieChartBarrio}') {
		PieChart().loadChart(JSON.parse('${action.pieChartBarrio}'),"#chartBarrio");
	}
	
	  $(window).keydown(function(event){
	    if(event.keyCode == 13) {
	      event.preventDefault();
	      return false;
	    }
	  });
}