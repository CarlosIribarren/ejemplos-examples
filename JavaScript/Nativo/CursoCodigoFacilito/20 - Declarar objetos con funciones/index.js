(function(){

  /* Funciones:
        Todo lo que se encuentra dentro de la ejecucion de la funcion, 
        no solo nos permite definir atributos y metodos, sino tambien nos
        permite  ejecutar una especie de constructor.
  
        La palabra 'new' permite crear una variable pasandole un prototipo.
  */

  // Definir funcion que tienen atributos y funciones
  function Tutor(nombre, apellido){

    // Definir un atributo
    this.nombre = nombre;

    // Definir un metodo
    this.saludar = function(){
      console.log("Hola a todos soy " + this.nombre);
    }

    // Definir un atributo opcional
    if(typeof apellido != "undefined"){
      this.nombre_completo = nombre + " " + apellido;
    }

  }

  var uriel = new Tutor("Uriel", "Hernandez");
  // Ejecutar metodo de la funcion
  uriel.saludar();
  // Aceder al atributo
  console.log(uriel.nombre_completo);


  var jose = new Tutor("Jose");
  // Ejecutar metodo de la funcion
  jose.saludar();
  // Aceder al atributo
  // Jose no tiene definida la variable nombre_completo
  console.log(jose.nombre_completo);

})();
