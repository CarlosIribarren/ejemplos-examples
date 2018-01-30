window.onload = function(){

    // Ejecuta hasta que la condicion es false
    var contador_uno = 0;
    console.log("Primer Ciclo while: imprime los numeros del 1 al 10")
    while(contador_uno < 10 ){
        contador_uno++;
        console.log(contador_uno);
    }

    
    // continue: cuando se encuentra con esta linea de codigo,
    //           se salta a la siguiente iteracion
    var contador_dos = 0;
    console.log("Segundo Ciclo while: imprime los numeros impares del 1 al 10")
    while(contador_dos < 10 ){
        contador_dos++;
        if(contador_dos % 2 == 0)
        {
            //Salta a la siguinete iteracion
            continue;
        }
        //Para los numeros pares esta linea no se ejecuta
        console.log(contador_dos);
    }


    // break: para el ciclo while
    var contador_tres = 0;
    console.log("Tercer Ciclo while: imprime los numeros del 1 al 10")
    while(true){
        contador_tres++;
        console.log(contador_tres);
        //Si el numero es mayor que 10, entonces para el ciclo while
        if(contador_tres >= 10)
        {
            //Para el ciclo while
            break;
        }
    }


    // Do While: El ciclo se ejecuta al menos una vez, 
    //           aunque la primera condicion no se cumpla
    var contador_cuatro = 0;
    console.log("Ciclo Do While: imprime los numeros del 1 al 10")
    do {
        contador_cuatro++;
        console.log(contador_cuatro);
        //Si el numero es mayor que 10, entonces para el ciclo while
        if(contador_cuatro >= 10)
        {
            //Para el ciclo while
            break;
        }
    } while (true);

}