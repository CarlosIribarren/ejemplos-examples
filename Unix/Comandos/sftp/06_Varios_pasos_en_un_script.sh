#!/bin/bash

# Ejemplo de ejecutar varios comandos de sftp.

BASE="/tmp"
CARPETA="/carpeta"
VAR_PATH=$BASE$CARPETA


(echo cd $BASE echo mkdir $CARPETA && echo cd $CARPETA && echo put /root/Captura.PNG && echo exit) | sftp -i /root/.ssh/id_rsa root@192.168.240.167

