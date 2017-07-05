#!/bin/bash

###########################################################
## Ejemplo: Se muestra como sumar, restar,... con las variables
## Existen dos formas para realizaar operaciones matematicas:
##
## Forma 1:
## --------
##
##  $[ val expr val ]
##
## No se pueden dejar espacios tipo:
##    suma= $[$NUMERO1+$NUMERO2] ==>> ERROR
##
## Forma 2:
## --------
##
##  let suma=NUMERO1+NUMERO2
##
## No se pueden dejar espacios tipo:
##    let suma= NUMERO1+NUMERO2 ==>> ERROR
###########################################################

## Leer de teclado y guardar en variable NUMERO1
read -p 'Introduce el primer numero : ' NUMERO1

## Leer de teclado y guardar en variable NUMERO2
read -p 'Introduce el segundo numero : ' NUMERO2

## Realiza la suma de los dos numeros

suma=$[$NUMERO1+$NUMERO2]

## let para indicar que vamos a realizar una operacion aritmetica
let media=suma/2

echo "La media es : $media"
