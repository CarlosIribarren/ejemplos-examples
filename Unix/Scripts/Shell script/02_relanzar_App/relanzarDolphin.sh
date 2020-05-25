#!/bin/bash


##############################################################################
###### Parar ActiveMQ y Tomcat ###############################################
##############################################################################

sudo systemctl stop activemq
echo "ActiveMQ stoped"
sudo systemctl stop tomcat
echo "Tomcat stoped"


##############################################################################
###### Borrar Logs ###########################################################
##############################################################################

# Borrar logs ActiveMQ
rm -rf /opt/apache-activemq-5.9.1/logs/*.*
# Borrar logs Tomcat
rm -rf /opt/apache-tomcat-7.0.52/logs/*.*

# Borrar logs aplicaciones
rm -rf /opt/dolphin/logs/*.*
#rm -rf /opt/dolphin-supervisor/logs/*.*
#rm -rf /opt/device-boot/logs/*.*
#rm -rf /opt/ikfids/logs/*.*
#rm -rf /opt/ikfids-ui/logs/*.*
#rm -rf /opt/ikfids-web/logs/*.*
#rm -rf /opt/ik-weather-gateway/logs/*.*
#rm -rf /opt/vkik/logs/*.*
#rm -rf /opt/ikusi/ik-spi/logs/*.*

##############################################################################
###### Borrar directorio work del tomcat #####################################
##############################################################################

# Borrar directorio work del Tomcat
rm -rf /opt/apache-tomcat-7.0.52/work/Catalina/localhost/dolphin
#rm -rf /opt/apache-tomcat-7.0.52/work/Catalina/localhost/*


##################
###### ik-spi ####
##################

# Ik-spi
#rm -rf /opt/apache-tomcat-7.0.52/webapps/ik-spi

##############################################################################
###### Mover wars nuevos, renombrar y guardar el anterior en *.old ###########
##############################################################################

## Dolphin
mv /root/DOLPHIN_AIS_WARS/dolphin*.war /opt/dolphin/webapps/
yes | cp -p /opt/dolphin/webapps/dolphin.war /opt/dolphin/webapps/dolphin.war.old
yes | cp -p /opt/dolphin/webapps/dolphin_ais_*.war /opt/dolphin/webapps/dolphin.war
yes | rm /opt/dolphin/webapps/dolphin_ais_*.war

rmdir /root/DOLPHIN_AIS_WARS

##############################################################################
###### Arrancar ActiveMQ y Tomcat ############################################
##############################################################################

sudo systemctl start activemq
echo "ActiveMQ started"
sudo systemctl start tomcat
echo "Tomcat started"








#sudo /opt/apache-activemq-5.9.1/bin/activemq-admin stop
#sudo /opt/apache-tomcat-7.0.52/bin/./shutdown.sh
#mv /root/DOLPHIN_AIS_WARS/dolphin*.war /opt/dolphin/webapps/
#yes | cp -p /opt/dolphin/webapps/dolphin.war /opt/dolphin/webapps/dolphin.war.old
#yes | cp -p /opt/dolphin/webapps/dolphin_ais_*.war /opt/dolphin/webapps/dolphin.war
#yes | rm /opt/dolphin/webapps/dolphin_ais_*.war
#sudo /opt/apache-activemq-5.9.1/bin/activemq-admin start
#sudo /opt/apache-tomcat-7.0.52/bin/./startup.sh