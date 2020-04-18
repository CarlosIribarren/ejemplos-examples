# Ejenplo 
En este ejemplo se muestra como obtener una Entity relacionado con otro Entity con una relacion ManyToMany.

Se define el nombre del Entity para luego utilizarlo en las consultas para referenciar las tablas. (Tambien se podria utilizar el nombre de la clase en vez de utilizar el nombre del Entity.)

        @Entity(name = "usuario")
        @Table(name = "usuario")
        public class UsuarioEntity {

Si un entity tiene una Collection de otro Entity, como por ejemplo en el Entity Usuario hay una lista del Entity Roles, por defecto Spring Data no obtiene esa Collection.

        @Entity(name = "usuario")
        @Table(name = "usuario")
        public class UsuarioEntity {

                ...

                @ManyToMany
                @JoinTable( 
                        name = "usuarios_roles", 
                        joinColumns = @JoinColumn( name = "usuarios_roles_usuario_id"), 
                        inverseJoinColumns = @JoinColumn( name = "usuarios_roles_rol_id")) 
                private Collection<RolEntity> roles;


Para cargar la lista de Roles que tiene un usuario, se ha creado una consulta que hace la INNER JOIN entre las dos entitys:

                @Query("SELECT u FROM usuario u INNER JOIN rol r ON u.id = r.id")
                List<UsuarioEntity> findAllWithRoles();


# Datos
Los usuarios se insertan la primera vez que se ejecuta. Se insertan por codigo. (Lo normal seria insertarlos utilizando el script de flyway)