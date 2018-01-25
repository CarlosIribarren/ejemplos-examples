#!/bin/bash

# Para que la ventana se ejecute con un tamaño especifico
echo -ne "\e[8;50;170t"

cd e:
cd ZERGA


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
	echo -ne "- " $1
	# Poner texto en modo normal
	echo -e "\e[0m"
}

echo -e "\n"
echo ----------------------------------------------------------------------------------------------------------------------
echo ------------------ Descargar commits de la rama develop de todos los proyectos del servidor --------------------------
echo ----------------------------------------------------------------------------------------------------------------------

# Recorrer ficheros de primer nivel
for repo in *
do

	# Si la carpeta es un directorio
    if [ -d "$repo" ] 
    then
	
        # Entrar dentro del directorio
        cd "$repo"
		
		# Recorrer ficheros de segundo nivel
        for subRepo in *
        do
			
			# Si la carpeta es un directorio
            if [ -d "$subRepo" ] 
            then
			
				# Entrar dentro del directorio
				cd "$subRepo"
				
				# Imprime el nombre del proyecto
                imprime_nombre_Proyecto $subRepo
                
				# Mover a la rama develop
                git checkout develop
				
				# Descargar los commit de la rama develop
                git pull IZFE_HTTPS develop
            fi

            cd ..
        done
            
    fi

    cd ..

done

echo ""
read -n1 -r -p "Pulsa una tecla para terminar" key

