# Ejemplo
Muestra como definir propiedades generales para todos los proyectos
## Teoria
Si hay un "application.properties" presente en el repositorio Git, se servirá a todos los clientes además de los otros archivos.

## Resultado
Se solicita las propiedades del proyecto con nombre "hello-service-carpetas" con el perfil de "local", y se obtienen los siguientes ficheros:
```
- /application.properties
- /ejemplo-carpeta/hello-service-carpetas.properties
- /ejemplo-carpeta/hello-service-carpetas-local.properties
```
Las propiedades se sobreescriben del mas general al mas concreto, es decir, de arriba a abajo se sobreescriben.