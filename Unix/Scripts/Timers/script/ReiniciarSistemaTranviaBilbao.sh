#!/bin/bash

PATH_LOG_TOMCAT="/opt/tomcat/logs/"
LOG_TOMCAT=$PATH_LOG_TOMCAT"catalina.out"
LOG_CONEXION_SGT=$PATH_LOG_TOMCAT"Log_Error_Conexion_SGT.txt"

if [ -f "$LOG_TOMCAT" ]; then

   contador=$(grep -c "JMSException was captured . A new connection is attempted to brokerjavax.jms.JMSException: javax.xml.bind.UnmarshalException" $LOG_TOMCAT)
	
    if [ $contador -gt 0 ]; then

        # Registrar inicidencia
        echo "Se ha perdido la conexion con el sistema SGT. Se ha reinicado el Tomcat. "$(date) >> $LOG_CONEXION_SGT

        # Parar sistemas
        systemctl stop tomcat 
        
        # Renombrar catalina.out
        mv $LOG_TOMCAT $LOG_TOMCAT-$(date +%Y%m%d%H%M)
        
        # Comprimir el catalina.out-fecha
        gzip $LOG_TOMCAT-$(date +%Y%m%d%H%M)
		
        # Iniciar sistemas
        systemctl start tomcat

    fi

else
   echo "El fichero $LOG_TOMCAT no existe." >> $LOG_CONEXION_SGT
fi

	

