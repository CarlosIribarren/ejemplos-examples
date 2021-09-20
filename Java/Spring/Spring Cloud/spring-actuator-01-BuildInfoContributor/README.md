# Spring Actuator Info con BuildInfoContributor

En este ejemplo se muestra como mostrar la informacion de /info utilizando BuildInfoContributor.

Añadir el siguiente plugin en el POM:

```xml
			<plugin>
			    <groupId>org.springframework.boot</groupId>
			    <artifactId>spring-boot-maven-plugin</artifactId>
			    <executions>
			        <execution>
			            <goals>
			                <goal>build-info</goal>
			            </goals>
			        </execution>
			    </executions>
			</plugin>
```

Ahora al llamar al metodo de /info, se utilizara la BuildInfoContributor, que añade informacion de la compilacion y se obtiene el siguiente JSON:
```json
{
	"build": {
		"artifact": "spring-actuator-01-BuildInfoContributor",
		"name": "spring-actuator-01-BuildInfoContributor",
		"time": "2020-07-21T11:09:39.249Z",
		"version": "0.0.1-SNAPSHOT",
		"group": "oiasso.systems.spring.actuator"
	}
}
```

Tambien se pueden añadir mas campos, configurando el plugin:

```xml
<configuration>
    <additionalProperties>
        <encoding.source>UTF-8</encoding.source>
        <encoding.reporting>UTF-8</encoding.reporting>
        <java.source>${maven.compiler.source}</java.source>
        <java.target>${maven.compiler.target}</java.target>
    </additionalProperties>
</configuration>
```




