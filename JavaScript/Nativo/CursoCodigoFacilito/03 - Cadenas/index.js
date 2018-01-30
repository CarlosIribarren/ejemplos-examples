window.onload = function(){

    // Las cadena se pueden definir con comillas simples y dobles
    var cadena1 = "Hola mundo"; 
    var cadena2 = 'Hola mundo';
    console.log(cadena1);

    // Concatenar cadenas con el operador +
    var nombre = 'Uriel';
    var hola = "Hola " + nombre; 
    console.log(hola);

    //Obtener la longitud de caracteres que tiene, incluido los espacios en blanco
    console.log(hola.length);

    //Buscar si un texto esta contenido dentro de otro texto
    // Si encuentra la cadena, retorna la posicion de inicio.
    // Si no encuentra la cadena, retorna -1
    var resultado_Encuentra = hola.indexOf("Uriel");
    console.log(resultado_Encuentra);
    var resultado_No_Encuentra = hola.indexOf("Jaime");
    console.log(resultado_No_Encuentra);

    var texto = "Esto es una cadena de prueba con la palabra Uriel";
    if(texto.indexOf("Uriel") == -1)
    {
        console.log("La frase no tiene la palabra Uriel");
    }
    else{
        console.log("La frase tiene la palabra Uriel");
    }


    // Acceder a una posicion concreta de la cadena
    console.log(texto[2]);
    console.log(texto[texto.length-1]);
    console.log(texto.charAt(0));

    // Remplazar palabras
    var texto_Remplazado = texto.replace("Uriel","Jaime");
    console.log(texto_Remplazado);

    // Obtener pedazos de las cadenas
    var texto_Cortado = texto.slice(12,19);
    console.log(texto_Cortado);

    // Convertir a Mayusculas y Minusculas
    var texto_Mayusculas = texto.toUpperCase();
    var texto_Minusculas = texto.toLowerCase();
    console.log(texto_Mayusculas);
    console.log(texto_Minusculas);

}

