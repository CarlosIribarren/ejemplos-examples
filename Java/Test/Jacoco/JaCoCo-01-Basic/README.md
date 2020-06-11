# Ejemplo
En este ejemplo se muestra como configurar JaCoCo y ejecutar utilizando el plugin de JaCoCo.

Muchas veces se ven ejemplos de configuraciones para que se genere el informe en la fase de test de maven, pero en este ejemplo no esta enlazado con ninguna fase de maven.

## Ejecutar los test de covertura y generar un reporte
Para ejecutar los test de covertura y generar un reporte, escribir en la linea de comandos:

```
mvn jacoco:report
```

## Resultados

Por defecto se genera un fichero en "target\jacoco.exec".

Este fichero es el que luego necesitan sistemas como Sonar,...

Tambien se generar informes en html en la carpeta "target/site/jacoco/index.html"

