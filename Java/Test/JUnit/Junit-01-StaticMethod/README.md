# Metodos estaticos

Como es una clase con metodos estaticos. Si miramos la covertura no se obtiene el 100%.

En una clase normal en la que se crea una instancia para el test, si se obtiene el 100%.

Las clases con metodos estaticos, normalmente, no se inctancian por lo que no podemos probar el constructor,...
No pasa nada por no tener el 100% de cobertura.
 
Si queremos que nadie pueda instanciar la clase y testear la creacion de la clase tambien, 
para que asi nos de una cobertura del 100%. Entonces creamos el metodo privado en la clase,
que arroja una excepcion y luego testeamos ese metodo, asi conseguimos el objetivo de asegurarnos 
que nadie puede instanciar la clase y que obtenemos el 100% de la cobertura.

# Notas
No es buena practica utilizar clases con metodos esticos por la siguientes razones:

## Acoplamiento
Se produce un mayor acoplamiento.

El acopablimento perjudica lo siguiente:

- Acoplamiento del codigo: La clase que utiliza el metodo estatico, tiene escrito a fuego el nombre de la clase. En vez de hacer esto, es mucho mejor, utilizar clases abstractas, como interfaces, que luego pueden tener una u otra implementacion.
- Cambiabilidad: El acoplamiento perjudica la cambiabilidad. No podemos cambiar la implementacion.
- Dificultan los test: Cuando tenemos que testear un metodo que utiliza un metodo estatico, no lo podemos falsear (mock) de una manera sencilla. Mientras que si es una clase utiliza una injeccion de dependecia, en el test, se puede injectar y falsear nuestra clase/metodo mucho mas facil. Es decir si utilizamos metodos esticos supone que hay que hacer un esfuerzo extra para testear las clases que utilizan estos metodos.

## Esconde dependecias
no muestra la dependencia en un primer vistazo de la clase, hay que fijarse en todo el cuerpo del metodo para verla, ya que la dependecia no se encuentra ni como atributo ni en el constructor.
Si tenemos la dependecia como atributo, la dependecia se ve a primera vista, en esquemas,...
Es mejor que las depedencias esten lo mas visibles posibles.

## Orientacion a objetos
Rompe el concepto de orientacion a objetos. 

- En los atributos:
Si una clase tiene un atributo estatico y tenemos muchas instacias de esas clases. Si una de las clases cambia el valor del atributo estatico, entonces esto se refleja en todas las instancias, ya que un atributo estatico solo tiene una instancia en todo el sistema.

- En los metodos:
Ese tipo de programacion tiene mas que ver con manera procedural que no con un modo de POO.