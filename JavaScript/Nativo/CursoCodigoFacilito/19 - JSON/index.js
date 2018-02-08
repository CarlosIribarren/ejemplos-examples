(function(){

  
    /*
      JSON: JavaScript Object Notation
            Clave : Valor
    */

  /* Ejemplo 1: 
        Aceder a las propiedades
  */
  console.log("****** Ejemplo 1: *******");

  // Definir un json
  var curso_json_1 = { 
    titulo : "Curso de JavaScript",
    videos : 19, 
    tutor : "Uriel"
  };

  // Aceder a una elemento utilizando los corchetes
  console.log(curso_json_1["titulo"]);
  // Aceder a una elemento utilizando el punto
  console.log(curso_json_1.titulo);


  /* Ejemplo 2: 
        Definir una funcion como una variable dentro de un json.
        Las funciones son variables.
  */
  console.log("****** Ejemplo 2: *******");

  // Definir un json
  var curso_json_2 = { 
    titulo : "Curso de JavaScript",
    videos : 19, 
    tutor : "Uriel",
    introducion : function(){
      console.log("Bienvenido al curso :" + this.titulo );
    }
  };

  // Aceder al elemento
  console.log(curso_json_2.introducion());


    /* Ejemplo 3: 
        Utilizar la palabrea 'this' para aceder a los demas atributos del mismo JSON.
        Se puede aceder tanto a atributos como a metodos.
  */
  console.log("****** Ejemplo 3: *******");

  // Definir un json
  var curso_json_3 = { 
    titulo : "Curso de JavaScript",
    videos : 19, 
    tutor : "Uriel",
    introducion : function(){
      console.log("Bienvenido al curso :" + this.titulo );
      this.otra_funcion();
    },
    otra_funcion(){
      console.log("Se esta ejecutando la otra funcion");
    }
  };

  // Aceder al elemento
  console.log(curso_json_3.introducion());

})();
