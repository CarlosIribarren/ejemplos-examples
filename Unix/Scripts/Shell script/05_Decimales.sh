#!/bin/bash

###########################################################
## Ejemplo: Se muestra como usar los decimales
## para que tenga deciamles, hay que definir la variable
###########################################################

## Leer de teclado y guardar en variable NUMERO1
read -p 'Introduce el primer numero : ' NUMERO1

## Leer de teclado y guardar en variable NUMERO2
read -p 'Introduce el segundo numero : ' NUMERO2

## Realiza la suma de los dos numeros

suma=$[$NUMERO1+$NUMERO2]

## scale para indicar el numero de  decimales
media=$( echo " scale=2; $suma/3 " | bc -l )

echo "La media es : $media"
