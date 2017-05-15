#!/bin/bash

# Para que la ventana se ejecute con un tamaño especifico
echo -ne "\e[8;50;170t"

cd e:
cd ZERGA

## Lista todos los repositorios que tengan cambios sin comitear.
## Se entienden cambios sin comitear como, proyectos que tengas ficheros modificados y ficheros sin seguimiento.
## Busca todos los repositorios en todas las sub-carpetas.

# **********************************************************************************************************
# ************************************** Funciones *********************************************************
# **********************************************************************************************************

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

# Imprime el texto Untraked en color berde
function imprime_Untracked {
	# poner texto en modo rojo
	echo -ne "\e[32m"
	# Imprime el texto Untraked
	echo -ne "Untracked: "
	# Poner texto en modo normal
	echo -e "\e[0m"
}

# Imprime el texto Modified en color amarillo
function imprime_Modified {
	# poner texto en modo amarillo
	echo -ne "\e[33m"
	# Imprime el texto Modified
	echo -ne "Modified: "
	# Poner texto con color normal
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
	echo -ne "Repositorios con cambios: "
	# Poner texto parpadeando
	echo -ne "\e[1m"
	# Imprimir el numero de proyectos con cambios
	echo -ne "${contador_repositorios_con_cambios}\n"
	
	# Poner la letra en modo normal
	echo -e "\n \e[0m"
	
	# Repositorios totales
	echo -e "Repositorios totales: ${contador_todos_los_repositorios}"
	# Repositorios sin cambios
	echo -e "Repositorios sin cambios: ${contador_repositorios_sin_cambios}\n"
}

echo -e "\n"
echo ----------------------------------------------------------------------------------------------------------------------
echo ------------------------------------- Proyectos con cambios sin comitear ---------------------------------------------
echo ----------------------------------------------------------------------------------------------------------------------

# Initialise counters:
let contador_todos_los_repositorios=0
let contador_repositorios_con_cambios=0
let contador_repositorios_sin_cambios=0
let contador_repositorio_tiene_cambios=0

# Find git repos and loop over them:
for repo in `find . -type d -name ".git"`
do

	# Se inicializa la variable para saber si el repositorio que se esta analizando tiene cambios
	let contador_repositorio_actual_tiene_cambios=0

	# Sumar todos los repositorios
    let contador_todos_los_repositorios=${contador_todos_los_repositorios}+1
    
    # cd to the dir that contains .git/:
    dir=`echo ${repo} | sed -e 's/\/.git/\//'`
    cd ${dir}
	
	if git status | grep -q "Untracked"
	then
		
		# Imprime el nombre del proyecto
		imprime_nombre_Proyecto ${dir}
		
		# Imprime el texto Untraked
		imprime_Untracked
		
		git ls-files . --exclude-standard --others
		
		# Se activan las variables ya que este repositorio tiene cambios
		let contador_repositorios_con_cambios=${contador_repositorios_con_cambios}+1
		let contador_repositorio_actual_tiene_cambios=${contador_repositorio_actual_tiene_cambios}+1
	fi
	
	if git status | grep -q "Changes not staged for commit"
	then
		# Se mira si la variable contador_repositorio_actual_tiene_cambios es igual que 0 para saber si ha entrado en el if de arriba,
		# Si ya ha entrado en el if de arriba, es decir, que el repositorio tiene cambios, entonces el nombre del proyecto ya se ha imprido
		# en la pantalla y el contador contador_repositorios_con_cambios ya ha sumado 1.
		if [ ${contador_repositorio_actual_tiene_cambios} -eq 0 ]; 
		then
			# Imprime el nombre del proyecto
			imprime_nombre_Proyecto ${dir}
			
			# Para que no se sume dos veces, se mira si ya se ha sumado antes, mirando el valor de contador_repositorio_actual_tiene_cambios
			let contador_repositorios_con_cambios=${contador_repositorios_con_cambios}+1
		fi

		# Imprime el texto Modified
		imprime_Modified

		# Visualizar los ficheros modificados
		echo | git status | grep "modified:"
		
		# Se activa la variable ya que este repositorio tiene cambios
		let contador_repositorio_actual_tiene_cambios=${contador_repositorio_actual_tiene_cambios}+1
	fi
	
	# Esto se hace para controlar los repos que no tienen cambios
	if [ ${contador_repositorio_actual_tiene_cambios} -eq 0 ]; 
	then 
		let contador_repositorios_sin_cambios=${contador_repositorios_sin_cambios}+1; 
	fi
	
    # cd back:
    cd - &> /dev/null
done

#imprimir resumen
imprime_Resumen

read -n1 -r -p "Pulsa una tecla para terminar" key


