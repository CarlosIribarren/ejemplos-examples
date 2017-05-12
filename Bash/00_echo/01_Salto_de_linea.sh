#!/bin/bash

# ***************************************************
# ************* echo normal *************************
# ***************************************************
# Un echo normal realiza un salto de linea al final de la instruccion y no interpreta los caracteres tipo \n
echo "Un echo \n normal provoca un salto de linea al final de la instruccion y los caracteres tipo \n no se interpretan."

# ******************************************************************************
# ************* echo sin salto de linea al final de la instruccion *************
# ******************************************************************************

# cada echo no hace un salto de linea
echo -n "texto "
echo -n "sin "
echo -n "salto "
echo -n "de "
echo -n "linea."

# ******************************************************************
# ************* echo que interpreta caracteres tipo \n *************
# ******************************************************************

echo -e "\n\tInterpreta caracteres.\n"


# *********************************************************************************************************************
# ************* echo sin salto de linea al final de la instruccion y interpretando los caracteres tipo \n *************
# *********************************************************************************************************************

echo -ne "\t echo sin salto de linea y interpretando los caracteres."





echo -e "\n\n\n"
read -n1 -r -p "Pulsa una tecla para terminar" key
