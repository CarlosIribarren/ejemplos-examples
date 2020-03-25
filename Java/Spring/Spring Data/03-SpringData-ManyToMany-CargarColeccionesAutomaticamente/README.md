# Teoria
Por defecto, de los cuatro tipos de relación entre entidades permitidos en JPA (@OneToOne, @OneToMany, @ManyToOne y @ManyToMany) sólo dos son de tipo Lazy: @OneToMany y @ManyToMany. 

Esto tiene mucho sentido, pues son estos dos tipos los que a más objetos conectan en el otro lado de la relación. Al ser el comportamiento por defecto, no debemos hacer nada para declarar estas relaciones como Lazy (es su comportamiento implícito).

El resto de relaciones no-Lazy (@ManyToOne y @OneToOne) deben ser marcadas explícitamente como Lazy si queremos que se comporten de dicha manera:

Una vez una entidad contenedora ha sido desconectada (dettached) del gestor de persistencia (por ejemplo al enviarla de vuelta al código cliente que la solicitó), esta se enviará tal como esté en ese momento sin importar en que estado estén sus relaciones que hayan sido marcadas como Lazy. Si una relación ha sido inicializada antes de desconectar la entidad del gestor de persistencia, podremos acceder a sus valores de forma normal; en caso contrario, la relación no apuntará a ningún objeto, y por tanto obtendremos un error al intentar manejarla:

Una solución para evitar enviar a un cliente relaciones no inicializadas es definirlas explícitamente como no-lazy (o dicho de forma más correcta, Eager):

El comportamiento opuesto a Lazy Fetch, como vimos en un ejemplo anterior, es Eager Fetch (el término puede traducirse literalmente como obtención impaciente, pero yo, de nuevo, prefiero entenderlo como inicialización temprana). Cuando una relación es de tipo Eager, o es marcada con este comportamiento de forma explícita, ésta es inicializada en el mismo instante en que lo es su entidad contenedora. Esto conlleva cero problemas para el código cliente, pues a efectos prácticos estamos en la misma situación que cuando trabajamos con POJOs en un entorno de no-persistencia (se aplican las reglas de construcción típicas del class loader). Tan simple como eso.

Lazy Fetch tiene un cometido concreto, y esto por si sólo ya es motivo para su existencia. El coste de crear objetos puede ser inmenso si todas las relaciones dentro de una entidad (relaciones que a su vez pueden contener sus propias relaciones, y así indefinidamente) fueran iniciadas en cascada desde el momento de creación de la entidad contenedora original. Otra situación en la cual Lazy Fetch es sumamente útil es cuando definimos una relación con objetos de gran tamaño (como BLOBs y CLOBs). Esta clase de relaciones suelen definirse como Lazy y, en caso de ser necesario el/los objeto/s referenciados, accedidos mediante lógica adicional. Todo esto representa el buen uso de Lazy Fetch.

Por supuesto podemos inicializar explícitamente todas las relaciones como Eager y olvidarnos de todo lo demás, y esto representa el mal uso de la arquitectura. Tarde o temprano terminaremos incurriendo en costes extra, ya que entre todos los objetos que estaremos inicializando, multitud de ellos serán accedidos en muy raras ocasiones (o incluso ninguna).

En este punto, y a pesar del gran problema que tuvimos unas secciones más atrás, podríamos pensar que "Lazy Fetch es un mecanismo mejor que Eager Fetch"; nada más lejos de la realidad, pues podemos terminar cometiendo un pecado distinto pero igual de grave, el de marcar toda relación viviente como Lazy: puesto que ninguna relación estará inicializada dentro de la entidad contenedora, todos y cada una de los accesos que realicemos sobre ellas conllevará el coste extra de una nueva petición a base de datos, situándonos de nuevo frente a posibles futuros problemas de agotamiento de recursos.

La solución, como casi siempre, se encuentra en encontrar el equilibrio (en nuestro caso determinar que componentes deben ser Lazy y cuales Eager). Si bien esto es algo que no puede ser definido con exactitud en el momento de iniciar el desarrollo de una aplicación, lo será en mayor o menor medida durante su periodo de vida (en parte gracias a herramientas externas y en parte gracias al propio comportamiento y/o respuesta de la aplicación ante situaciones de estress).

# Ejenplo de FetchType.EAGER
En este ejemplo se muestra como obtener una Entity relacionado con otro Entity con una relacion ManyToMany.
Si un entity tiene una Collection de otro Entity, como por ejemplo en el Entity Usuario hay una lista del Entity Roles, por defecto Spring Data no obtiene esa Collection.
Para que Spring Data carge una relacion automaticamente, se pone, FetchType.EAGER en el atributo.

    @ManyToMany(fetch = FetchType.EAGER) // Por defecto Spring Data no carga las colecciones, con la propiedad EAGER si
    @JoinTable( 
        name = "usuarios_roles", 
        joinColumns = @JoinColumn( name = "usuarios_roles_usuario_id"), 
        inverseJoinColumns = @JoinColumn( name = "usuarios_roles_rol_id")) 
    private Collection<RolEntity> roles;


Para cargar la lista de Roles que tiene un usuario, se utiliza la consulta pre-definida:

        findAll()

# Datos
Los usuarios se insertan la primera vez que se ejecuta. Se insertan por codigo. (Lo normal seria insertarlos utilizando el script de flyway)

# URL de inicio:

        http://localhost:8080/usuarios