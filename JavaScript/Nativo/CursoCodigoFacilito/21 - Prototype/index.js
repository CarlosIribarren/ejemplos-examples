(function(){

  // Definir un prototipo
  function Tutor(nombre, apellido){
    this.nombre = nombre;
    this.saludar = function(){
      console.log("Hola a todos soy " + this.nombre);
    }
  }
  /* Definir variable de un prototipo
      El prototipo de uriel es Tutor.
      El prototipo de Tutor es Object.
  */
  var uriel = new Tutor("Uriel");
  var jose = new Tutor("Jose");


  /* Ejemplo 1: 
        Despues de definir y declarar el objeto, añadir atributo/metodo al objeto.
        Los atributos/metodos que se añaden despues al objeto, solo estan acesibles
        en el objeto que se han añadido.
   */
  console.log("********** Ejemplo 1: ***********");
  console.log("Despues de definir y declarar el objeto, añadir atributo/metodo al objeto");

  // Despues de definir y declarar el objeto, añadir un atributo al objeto
  uriel.edad = 18;
  console.log(uriel.edad);

  // Despues de definir y declarar el objeto, añadir un metodo al objeto
  uriel.iniciar_tutorial = function(){
    console.log("Bienvenidos al nuevo tutorial");
  }
  uriel.iniciar_tutorial();
    
  // Jose no tiene defini el atributo ni el metodo
  console.log("Jose no tiene definido el atributo ni el metodo");
  console.log(jose.edad);
  // Esta linea esta comentada para que siga la ejecucion.
  // Si se descomenta, en la consola da el siguiente error:
  // TypeError: jose.iniciar_tutorial is not a function
  //jose.iniciar_tutorial();


  /* Ejemplo 2: 
        Despues de definir y declarar el objeto, añadir atributo/metodo al prototipo.
        Los atributos/metodos que se añaden despues al prototipo, son acesibles para 
        todos los objetos.
   */
  console.log("********** Ejemplo 2: ***********");
  console.log("Despues de definir y declarar el objeto, añadir atributo/metodo al prototipo.");
    
  // Añadir un atributo al prototipo.
  // Este atributo se añade a todos los objetos que hay definidos.
  Tutor.prototype.altura = 180;
  console.log("Altura de uriel: " + uriel.altura);
  console.log("Altura de jose: " + jose.altura);

  // Añadir un metodo al prototipo
  Tutor.prototype.acabar_Tutorial = function(){
    console.log(this.nombre + ": El tutorial de prototipos se esta acabando");
  }
  uriel.acabar_Tutorial();
  jose.acabar_Tutorial();


})();
