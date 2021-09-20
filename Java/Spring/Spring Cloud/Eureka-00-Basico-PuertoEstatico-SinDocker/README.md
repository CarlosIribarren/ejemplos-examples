# Eureka 00 Basico con puerto estatico sin docker

Es un ejemplo muy basico de Spring Cloud Eureka. 

# Teoria

La función de Eureka es registrar las diferentes instancias de microservicios existentes, su localización, estado, metadatos...

## ¿Cómo funciona?

Cada microservicio, durante su arranque, se comunicará con el servidor Eureka para notificar que está disponible, dónde está situado, sus metadatos… De esta forma Eureka mantendrá en su registro la información de todos los microservicios del ecosistema.

El nuevo microservicio continuará notificando a Eureka su estado cada 30 segundos, lo que denominan ‘heartbeats’. Si después de tres periodos Eureka no recibe notificación de dicho microservicio, lo eliminará del registro. De la misma forma una vez vueltos a recibir tres notificaciones considerará el servicio disponible de nuevo.

Cada cliente de Eureka podrá también recuperar el registro para localizar otros microservicios con los que necesite comunicarse. Dicha información de registro se cachea en el cliente.

Eureka se puede configurar para funcionar en modo cluster donde varias instancias “peer” intercambiarán su información. Esto, junto al cacheo de la información de registro en los clientes da a Eureka una alta tolerancia a fallos.

## ¿Qué aporta?

- Abstracción de la localización física de los microservicios: cualquier microservicio que sea un cliente Eureka solo necesita conocer el identificador del microservicio al que desea invocar y Eureka resolverá su localización, puerto…
- Conocer el estado de nuestro ecosistema de microservicios: Eureka proporciona un dashboard que permite ver los microservicios existentes actualmente en el registro.

# Ejemplo

El ejemplo consta de dos servicios:
- eureka-service: Servidor de eureka. Es donde 
- hello-service: Cliente de eureka. Se conecta al servidor de eureka y registra su servicio.

## Ejecutar
Este ejemplo esta preparado para ejecutar los proyectos desde un IDE o desde una consola con "java -jar ..."















# Api de Eureka

El servidor de eureka expone una API:

Para consultar los servicios registrados, realizar una peticion a la siguiente url:
```
GET http://localhost:8761/eureka/apps
```

Retorna un JSON de este tipo: (En este json solo hay un servicio)
```xml
<applications>
    <versions__delta>1</versions__delta>
    <apps__hashcode>UP_1_</apps__hashcode>
    <application>
        <name>HELLO-SERVICE</name>
        <instance>
            <instanceId>hello-service:870bb15766ba672a6f3ec63e90b2798c</instanceId>
            <hostName>hello-service</hostName>
            <app>HELLO-SERVICE</app>
            <ipAddr>172.31.0.3</ipAddr>
            <status>UP</status>
            <overriddenstatus>UNKNOWN</overriddenstatus>
            <port enabled="true">8080</port>
            <securePort enabled="false">443</securePort>
            <countryId>1</countryId>
            <dataCenterInfo class="com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo">
                <name>MyOwn</name>
            </dataCenterInfo>
            <leaseInfo>
                <renewalIntervalInSecs>30</renewalIntervalInSecs>
                <durationInSecs>90</durationInSecs>
                <registrationTimestamp>1595440825779</registrationTimestamp>
                <lastRenewalTimestamp>1595440825779</lastRenewalTimestamp>
                <evictionTimestamp>0</evictionTimestamp>
                <serviceUpTimestamp>1595440825141</serviceUpTimestamp>
            </leaseInfo>
            <metadata>
                <management.port>8080</management.port>
            </metadata>
            <homePageUrl>http://hello-service:8080/</homePageUrl>
            <statusPageUrl>http://hello-service:8080/actuator/info</statusPageUrl>
            <healthCheckUrl>http://hello-service:8080/actuator/health</healthCheckUrl>
            <vipAddress>hello-service</vipAddress>
            <secureVipAddress>hello-service</secureVipAddress>
            <isCoordinatingDiscoveryServer>false</isCoordinatingDiscoveryServer>
            <lastUpdatedTimestamp>1595440825779</lastUpdatedTimestamp>
            <lastDirtyTimestamp>1595440824951</lastDirtyTimestamp>
            <actionType>ADDED</actionType>
        </instance>
    </application>
</applications>
```