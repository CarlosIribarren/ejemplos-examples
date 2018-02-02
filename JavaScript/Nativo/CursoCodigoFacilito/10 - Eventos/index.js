window.onload = function(){

    /* Ejemplo 1:
        Utilizando listeners 
    */
    // Obtener el boton
    var btn_1 = document.getElementById("mi_btn_1");
    // Asignar el evento
    // addEventListener(evento, funcion a ejecutar) 
    btn_1.addEventListener("click", evento_click);


    
    /* Ejemplo 2 y 3:
        Utilizando listeners y utilizando capture o bubble
        capture: Desde fuera hacia adentro (div->button)
        bubble: Desde adentro hacia fuera (button->div)
        
        document.addEventListener(event, function, useCapture)
        ======================================================
        useCapture: Optional. A Boolean value that specifies whether the event should be executed
                     in the capturing or in the bubbling phase. 

                    Possible values:
                        true - The event handler is executed in the capturing phase
                        false- Default. The event handler is executed in the bubbling phase


        Si no se pasa el parametro useCapture a la funcion, por defecto es false, es decir, que JS
        siempre ejecuta de adentro hacia afuera. 
        Entonces este parametro sirve para cuando se quiere que el evento de un elemento 
        se ejecute de dentro para afuera. Es decir, este parametro sirve
        para cuando se quiere que el evento de un elemento se ejecute en la fase de capture. 
        Para que suceda esto hay que activar el parametro con el valor de true. 
    */

    /* Ejemplo 2:
        En este ejemplo el boton esta dentro del div, es decir, que normalmente el evento del boton se
        ejecutaria primero y despues el evento del div, ya que no esta activado ningun evento el fase de
        capturing.
    */
    // Obtener los elementos
    var btn_2 = document.getElementById("mi_btn_2");
    var div_2 = document.getElementById("mi_div_2");
    // Asignar el evento el fase de bubbling
    btn_2.addEventListener("click", evento_button, false);
    // Asignar el evento el fase de bubbling
    div_2.addEventListener("click", evento_div, false);

    /* Ejemplo 3:
        En este ejemplo el boton esta dentro del div, es decir, que normalmente el evento del boton se
        ejecutaria primero y despues el evento del div. Pero en este caso, se ha activado para el elemento
        div el evento en la fase de capturing. Entonces se ejecutara primero el evento del div.
    */
    // Obtener los elementos
    var btn_3 = document.getElementById("mi_btn_3");
    var div_3 = document.getElementById("mi_div_3");
    // Asignar el evento el fase de bubbling
    btn_3.addEventListener("click", evento_button, false);
    // Asignar el evento el fase de capturing
    div_3.addEventListener("click", evento_div, true);

}

function evento_click(){
    alert("Hola evento onClick!!!");
}

function evento_mouseOver(){
    alert("Hola evento onMouseOver!!!");
}

function evento_mouseOut(){
    alert("Hola evento mouseOut!!!");
}

function evento_div(){
    alert("Hola evento div!!!");
}

function evento_button(){
    alert("Hola evento button!!!");
}


