#!/bin/bash

###########################################################
## Ejemplo: Se muestra el uso las variables
## Al usar la $var obtener el valor
###########################################################

## Se define una variable con el texto 4
numero=4


## Imprime el texto "numero+3", la variable numero NO se interpreta
echo numero+3

## Imprime el texto "4+3", la variable numero SI se interpreta
echo $numero+3

## Borra la pantalla
echo $(clear)
