window.onload = function(){

    // Numero maximo
    var max = 100;
    // Numero minimo
    var min = 1;

    // Numero aleatorio del 0 al 1
    var numero_secreto = Math.random();
    // Trasladar el numero entre el maximo y el minimo
    numero_secreto = numero_secreto * (max - min) + min ;

    // Convertir en entero
    numero_secreto = parseInt(numero_secreto);

    var mensaje = "Ingresa un numero para adivinar el numero magico";

    while (true) {

        // The prompt() method displays a dialog box that prompts the visitor for input.
        // prompt(mensaje, default value si no se ingresa nada)
        // Retorna un String
        var numero_del_usuario = window.prompt(mensaje, "0");

        // Convertir en entero
        numero_del_usuario = parseInt(numero_del_usuario);

        if(numero_del_usuario === numero_secreto){
            alert("Ganaste!!!! Adivinaste el numero secreto");
            break;
        }
        else if(numero_del_usuario === 0){
            break;
        }
        else if(numero_del_usuario > numero_secreto){
            mensaje = "El numero que ingresaste es mayor al numero magico";
        }
        else if(numero_del_usuario < numero_secreto){
            mensaje = "El numero que ingresaste es menor al numero magico";
        }
    }


}