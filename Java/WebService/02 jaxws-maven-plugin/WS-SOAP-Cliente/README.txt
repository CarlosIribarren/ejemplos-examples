*******************************
****** WS-SOAP-Client *********
*******************************


Configurar plugin
=================

  <build>
    <plugins>
      <plugin>
        <groupId>org.jvnet.jax-ws-commons</groupId>
        <artifactId>jaxws-maven-plugin</artifactId>
        <version>2.3</version>
        <configuration>
          <xdebug>true</xdebug>
          <sourceDestDir>src/main/java</sourceDestDir>
          <packageName>oiasso.systems.examples.calculator.soap</packageName>
          <wsdlUrls>http://www.dneonline.com/calculator.asmx?WSDL</wsdlUrls>
        </configuration>        
      </plugin>
    </plugins>
  </build>

 
Generar codigo fuente para consumir el WS
=========================================

En la consola, dentro de la carpeta del proyecto, ejecutar:

	$ mvn jaxws:wsimport
	
Una vez generadas las clases se puede borrar el plugin "jaxws-maven-plugin" del POM
