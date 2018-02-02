window.onload = function(){

    /* Ejemplo 1:
        Obtener una div a traves de su id y añadirle un class
    */

    //Obtener el div
    var div_1 = document.getElementById("mi_div_1");
    // Utilizar html5 para agregar la clase
    div_1.classList.add("mi_class_1");


    /* Ejemplo 2:
        Obtener varios div traves de su class
    */
    //Obtener todos los div que tengan el class mi_class_2
    var array_de_div_1 = document.getElementsByClassName("mi_class_2");
    // La variable array_de_div_1 tiene dentro un array que contiene dos divs
    console.log(array_de_div_1);


    /* Ejemplo 3:
        Obtener varios div traves del nombre del tag de html
    */
    //Obtener todos los div
    var array_de_div_2 = document.getElementsByTagName("div");
    // La variable array_de_div_2 tiene dentro un array que contiene los tres divs
    console.log(array_de_div_2);
    console.log(array_de_div_2[0]);


    /* Ejemplo 4:
        Obtener el primer elemento a traves de un selector de css
        querySelector() retorna solo el primer elemento.
    */
    //Obtener solo el primer elemento a traves de un selector de css
    var div_2 = document.querySelector(".mi_class_2")
    // La variable div_2 tiene dentro un div
    console.log(div_2);
    

    /* Ejemplo 5:
        Obtener todos los elementos a traves de un selector de css
        querySelectorAll() retorna todos los elementos.
        Siempre retorna un array.
    */
    //Obtener todos los elementos a traves de un selector de css
    var array_de_div_3 = document.querySelectorAll(".mi_class_2")
    // La variable array_de_div_3 tiene dentro un array que contiene dos divs
    console.log(array_de_div_3);


    /* Ejemplo 6:
        Definir una funcion como el selector de JQuery
    */
    // Definir la funcion
    function $(selector){
        return document.querySelectorAll(selector);
    }
    // Utilizar la funcion
    var array_de_div_4 = $(".mi_class_2");
    // La variable array_de_div_4 tiene dentro un array que contiene dos divs
    console.log(array_de_div_4);


    /* Ejemplo 7:
        Mostrar todo el arbol DOM
    */
    console.log(document);
}