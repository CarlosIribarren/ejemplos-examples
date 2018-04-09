(function(){


/* Ejemplo 1:
    Metodos get y set

*/
console.log("Ejemplo 1");

  // Definir un json
  var curso_1 = { 
    titulo : "Curso de JavaScript",
    videos : 19, 
    tutor : "Uriel",
    getTutor: function(){
      return this.tutor.toUpperCase();
    },
    setTutor: function(tutor){
      this.tutor = tutor;
    }

  };
curso_1.setTutor("Jose");
console.log(curso_1.getTutor());


/* Ejemplo 2:
    Verifica si en el set no tiene dato.

*/
console.log("Ejemplo 2");

  // Definir un json
  var curso_2 = { 
    titulo : "Curso de JavaScript",
    videos : 19, 
    tutor : "Uriel",
    getTutor: function(){
      return this.tutor.toUpperCase();
    },
    setTutor: function(tutor){
      if(tutor === "" || typeof tutor === "undefined"){return;}
      this.tutor = tutor;
    }

  };
curso_2.setTutor();
console.log(curso_2.getTutor());



/* Ejemplo 3:
    Get y Set con EcmaScript 5

    tutor_value : "Uriel",
    get Tutor(){
      return this.tutor_value.toUpperCase();
    },
    set Tutor(tutor_value){
      this.tutor_value = tutor_value;
    }

    La propiedad y el metodo no se pueden llamar igual, por eso se cambia el nombre del atributo.
    A los metodos get y set se le llama como una propiedad normal.

*/
console.log("Ejemplo 3");

  // Definir un json
  var curso_3 = { 
    titulo : "Curso de JavaScript",
    videos : 19, 
    tutor_value : "Uriel",
    get Tutor(){
      return this.tutor_value.toUpperCase();
    },
    set Tutor(tutor){
      if(tutor === "" || typeof tutor === "undefined"){return;}
      this.tutor_value = tutor;
    }

  };
curso_3.tutor = "";
console.log(curso_3.tutor);


})();
