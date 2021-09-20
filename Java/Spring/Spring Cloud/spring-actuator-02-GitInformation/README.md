# Spring Actuator Info con informacion de GIT

En este ejemplo se muestra como mostrar la informacion de /info mostrando el commit de GIT.

Añadir el siguiente plugin en el POM:

```xml
			<plugin>
			    <groupId>pl.project13.maven</groupId>
			    <artifactId>git-commit-id-plugin</artifactId>
			</plugin>	
```

Ahora al llamar al metodo de /info, se utilizara el plugin ye añade informacion del commit de GIT y se obtiene el siguiente JSON:
```json
{
	"git": {
		"branch": "master",
		"commit": {
			"id": "63d4e1d",
			"time": "2020-05-21T07:17:25Z"
		}
	}
}
```

NOTA: Para que el plugin funcione el proyecto tiene que tener un repositorio GIT, es decir, tiene que tener la carpeta oculta .git en la carpeta del proyecto.





