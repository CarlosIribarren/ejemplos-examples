window.onload = function(){

    /* 
        Tipo boolean
        - true
        - false
    */

    // Solo se ejecuta cuando la condicion es verdadera
    if(true){
        console.log("La condicion es verdadera, esto se imprime");
    }
    //
    if(false){
        console.log("La condicion es falsa, esto no se imprime");
    }


    /*
        Operadores Logicos
        - > (Mayor que)
        - < (Menor que)
        - || (o)
        - && (y)
        - == (igual)
        - === (igual)
        - != (diferente)
        - !== (diferente)
        - ! (no)
    */

    // Operadore logico: no
    if(!false)
    {
        console.log("La negacion de un false es un true, esto se imprime");
    }

    // Operador logico: Mayor y Menor que
    var numero_Uno = 23;
    var numero_Dos = 30;
    if(numero_Uno > numero_Dos)
    {
        console.log("Numero uno es mayor que numero dos");
    }
    if(numero_Uno < numero_Dos)
    {
        console.log("Numero uno es menor que numero dos");
    }

    // Operador logico: y
    if(numero_Uno && true){
        console.log("Operador logico: y. El numero uno existe y true");
    }
    if(numero_Uno && false){
        console.log("Operador logico: y. El numero uno existe y false");
    }

    // Operador logico: o
    if(numero_Uno || true){
        console.log("Operador logico: o. El numero uno existe o true");
    }
    if(numero_Uno || false){
        console.log("Operador logico: o. El numero uno existe o false");
    }
    if(false || false){
        console.log("Operador logico: o. False o false");
    }

    // Operador logico: Igual
    var numero_tres = 30;
    var numero_tres_Cadena = "30";
    // El operador ==, antes de comparar los valores los convierte a lo mismo
    // Es decir, antes de comparar, convierte la cadena es un numero
    if(numero_tres == numero_tres_Cadena)
    {
        console.log("Operador logico: Igual. 30 == '30' ");
    }
    // El operador ===, NO convierte el dato antes de comparar
    // Se recomienda esta comparacion:
    //      - Es para tener consistencia
    //      - Es mas rapido que ==
    if(numero_tres === numero_tres_Cadena)
    {
        console.log("Operador logico: Igual. 30 === '30' ");
    }

    // Operador logico: Diferente
    // El operador !=, antes de comparar los valores los convierte a lo mismo
    // Es decir, antes de comparar, convierte la cadena es un numero
    // En este caso los numeros no son diferentes
    if(numero_tres != numero_tres_Cadena)
    {
        console.log("Operador logico: Diferente. 30 != '30'");
    }
    // El operador !==, NO convierte el dato antes de comparar
    // En este caso los numeros si son diferentes
    if(numero_tres !== numero_tres_Cadena)
    {
        console.log("Operador logico: Diferente. 30 !== '30' ");
    }


    // If-else y else
    if(false)
    {

    }else if(false){

    }else{
        console.log("Solo se imprime si las condiciones de arriba son false");
    }

}