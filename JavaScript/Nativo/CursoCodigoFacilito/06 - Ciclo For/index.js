window.onload = function(){

    // Ciclo For: Iterar numeros
    console.log("Primer For: Imprime los numeros del 0 al 10")
    for(var i = 0; i <= 10 ; i++ ){
        console.log(i);
    }

    // Ciclo For: Iterar un array
    console.log("Segundo For: Imprime las palabras del array")
    var arreglo = ["Hola", "mundo"];
    for(var i = 0; i < arreglo.length; i++ ){
        console.log(arreglo[i]);
    }

    // Ciclo For: Utilizando el break
    console.log("Tercer For: Imprime los 5 primeros numeros")
    for(var i = 0; i <= 10; i++ ){
        //Cuando i>5, se sale del ciclo for
        if(i>5)
        {
            break;
        }
        console.log(i);
    }

    // Ciclo For: Utilizando el continue
    console.log("Cuarto For: Imprime los numeros del 0 al 10, menos el 5")
    for(var i = 0; i <= 10; i++ ){
        //Cuando i=5, saltar a la siguiente iteracion
        if(i==5)
        {
            continue;
        }
        console.log(i);
    }

}