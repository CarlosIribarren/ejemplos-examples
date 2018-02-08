/*
    Es recomendable no definir variables fuera de una funcion,
    ya que si definimos una variable fuera de una funcion, entonces esta 
    tendra un scope global. Para ello es recomendable definir una funcion.
*/
(function(){

  /* Ejemplo 1: Closure
        Definir una funcion dentro de otra funcion.        
   */
  document.getElementById('btn').addEventListener('click', function(){
    console.log("Hizo click en mi");
  });
  

  /* Ejemplo 2: Closure
        Los closures tienen aceso a las variables de la funcion padre. Es decir, 
          la variable nombre se utiliza dentro de la funcion closure.
        En la funcion padre se recibe una referencia de la variable, si se cambia
          el valor de la variable en la closure, tambien se cambia su valor en la 
          funcion padre.
   */
  
  // Definir una funcion con una closure dentro
  function hola_mundo_2(nombre){
    // Definir la closure, es decir, definir una funcion dentro de la funcion padre
    function construct(){
      return "Hola " + nombre;
    }
    //Retornar la funcion closure
    return construct();
  }

  // Utilizar la closure
  setTimeout(function(){
    console.log("******Ejempo 2:**********")
    console.log(hola_mundo_2("Uriel"));
  }, 2000);


  /* Ejemplo 3: Closure
        En la funcion padre se recibe una referencia de la variable, si se cambia
          el valor de la variable en la closure, tambien se cambia su valor en la 
          funcion padre.
   */

  function hola_mundo_3(nombre){
    
    // Funcion closure que cambia el valor de la variable de la funcion padre
    function construct(){
      nombre = "Juan";
      return "Hola " + nombre;
    }

    // Ejecutar la funcion que cambia el valor de la variable
    construct();

    // Imprimir en consola el valor de la variable
    console.log("Valor de la variable 'nombre' dentro de la funcion padre: " + nombre)

    //Retornar la funcion closure
    return construct();
  }

  // Utilizar la closure
  setTimeout(function(){
    console.log("******Ejempo 3:**********")
    console.log(hola_mundo_3("Uriel"));
  }, 3000);


})();