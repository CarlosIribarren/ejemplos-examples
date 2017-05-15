#!/bin/bash

# Para que la ventana se ejecute con un tamaño especifico
echo -ne "\e[8;50;150t"

cd e:
cd ZERGA

## Lista todos los repositorios que tengan commits por descargar del repositorio del servidor.
## Busca todos los repositorios en todas las sub-carpetas

# Imprime el nombre del proyecto con letra de color rojo y subrayado.
# El nombre del proyecto se pasa por parametro. 
# Ejemplo de llamada al metodo => "imprime_nombre_Proyecto Proyecto1" ,  "imprime_nombre_Proyecto ${dir}"
# 	param $1 Nombre del proyecto
function imprime_nombre_Proyecto {
	# Salto de linea
	echo -e "\n"
	# poner texto en modo subrayado
	echo -ne "\e[4m"
	# poner texto en modo rojo
	echo -ne "\e[31m"
	# Imprime el nombre del proyecto
	echo -ne $1
	# Poner texto en modo normal
	echo -e "\e[0m"
}

# Imprime el resumen
function imprime_Resumen {

	echo -e "\n"
	echo ----------------------------------------------
	echo --------------- Resumen ----------------------
	echo ----------------------------------------------

	# Poner la letra en modo normal
	echo -ne "\n\e[0m"
	
	# Repositorios con cambios
	echo -ne "Repositorios que necesitan ser actualizados: "
	# Poner texto parpadeando
	echo -ne "\e[1m"
	# Imprimir el numero de proyectos con cambios
	echo -ne "${contador_repositorios_con_cambios}\n"
	
	# Poner la letra en modo normal
	echo -e "\n \e[0m"
	
	# Repositorios totales
	echo -e "Repositorios totales: ${contador_todos_los_repositorios}"
	# Repositorios sin cambios
	echo -e "Repositorios que estan al dia: ${contador_repositorios_sin_cambios}\n"
}

echo -e "\n"
echo ----------------------------------------------------------------------------------------------------------------------
echo -------------------------- Proyectos con commits por descargar del servidor ------------------------------------------
echo ----------------------------------------------------------------------------------------------------------------------


# Inicializar contadores:
let contador_todos_los_repositorios=0
let contador_repositorios_con_cambios=0
let contador_repositorios_sin_cambios=0

# Set to 1 for more verbose output:
let verbose=0

# Find git repos and loop over them:
for repo in `find . -type d -name ".git"`
do
    let contador_todos_los_repositorios=${contador_todos_los_repositorios}+1
    
    # cd to the dir that contains .git/:
    dir=`echo ${repo} | sed -e 's/\/.git/\//'`
    cd ${dir}
	
	if git status | grep -q "Your branch is behind"
	then
	
		# Imprime el nombre del proyecto
		imprime_nombre_Proyecto ${dir}
		
		# Imprime los comits que faltan por descargar 
		git status | grep "Your branch is behind"
		
		let contador_repositorios_con_cambios=${contador_repositorios_con_cambios}+1
	else
		let contador_repositorios_sin_cambios=${contador_repositorios_sin_cambios}+1
	fi
	
    # cd back:
    cd - &> /dev/null
done

#imprimir resumen
imprime_Resumen

read -n1 -r -p "Pulsa una tecla para terminar" key
