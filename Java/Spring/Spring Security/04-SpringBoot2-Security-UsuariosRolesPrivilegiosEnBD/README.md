# Ejemplo
En este ejemplo se muestra como hacer login con usuarios con sus roles y privilegios en la BD.

## Probar ejemplo
Entrar en la URL: http://localhost:8080/
- Usuario: admin
- Password: admin

# Configuracion 
Se ha configurado Spring Security para que protega todas las peticiones.

Se permite acceso a las URLs de tipo "/css/**". Para cargar los ficheros de css.

```java
.antMatchers("/css/**").permitAll() // Las URLs que empiezan por /css/ son accesibles por cualquiera. Esto se hace con los contenidos de css, js, y imagenes.
.anyRequest().authenticated() // Todas las URLs estan protegidas
```

## Login
Si se hace una peticion a una URL y el usuario no esta logeado, sale la pantalla de login. si el usuario se logea con exito, se redirigue a la URL que se ha configurado en la propiedades, en este caso "/".

Todos los usuarios pueden acceder a la url de "/login"

```java
.loginPage("/login")
        .permitAll() // allow any access to any URL (i.e. /login and /login?error) associated to formLogin()
        .defaultSuccessUrl("/")
```

## Logout
Se ha definido la URL para el logout, en este caso "/logout"

Todos los usuarios pueden acceder a la url de "/logout"

```java
.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Define URL to logout
        .logoutSuccessUrl("/login?logout")
        .permitAll() // allows any user to request logout and view logout success URL.
        .invalidateHttpSession(true)
        .clearAuthentication(true);
```

# Roles Vs Privilegios
Para Spring Security los roles y los privilegios son lo mismo, son Authoritys. La unica diferencia entre un rol y un privilegio es que los roles se tiene que llamar empezando con el prefijo ROLE_. Que los roles se tengan que empezar con el prefijo ROLE_ es una configuracion por defecto, se puede modificar.

En este ejemplo se trabaja con los roles y los privilegios en las plantillas de thymeleaf.

## Roles
Para validar si el usuario tiene un rol en concreto se utiliza la siguiente etiqueta:

```html
<div sec:authorize="hasRole('ROLE_USER')">
	<p>User has Role User</p>
</div>
```

## Privilegios
Para validar si el usuario tiene un privilegio en concreto se utiliza la siguiente etiqueta:

```html
	<!-- Solo los usuarios que tengan el privilegio de acceso-gestion-usuarios -->
	<li sec:authorize="hasAuthority('acceso-gestion-usuarios')">
		<a th:href="@{/usuarios}">Gestion de usuarios</a>
	</li>
```

# Usuarios
Los usuarios estan definidos en la BD.

El password se guarda en la BD encriptado. (Ejemplo de admin: $2a$10$SUSDaYLh8Z3O/aZxpe9fGO83sItnUvjqigqnV9YsvGlY1QByZ/ln6). El password se guarda encriptado, porque, se ha configurado que los passwords en la BD estan encriptados. 

Entonces cuando un usuario hace login, en el service UserDetailsServiceImpl se obtiene el usuario de la BD y se retorna como un User de Spring Security. Con ese usuario que se retorna de esa clase, Spring Security automaticamente desencriptara el password para compararlo con el password introducido por el usuario. Y asi de esta manera concuerdan los password.

Si hicieramos un CRUD, al insertar un usuario nuevo, tendriamos que encriptar el password de la misma manera. 

## Datos iniciales
La primera vez se inserta el usuario admin y user.

```java
if(usuarioDao.findAll().isEmpty()) {

	/********************************
	 ************* USER *************
	********************************/

	//Crear privilegio acceso-pantalla-principal
	Privilegio privilegioAccesoPantallaPrincipal = new Privilegio();
	privilegioAccesoPantallaPrincipal.setNombre("acceso-pantalla-principal");
	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
	privilegioAccesoPantallaPrincipal = privilegioDao.save(privilegioAccesoPantallaPrincipal);

	// Crear rol
	Rol rolUser = new Rol();
	rolUser.setNombre("ROLE_USER");
	Collection<Privilegio> privilegiosUser = new ArrayList<>();
	privilegiosUser.add(privilegioAccesoPantallaPrincipal);
	rolUser.setPrivilegios(privilegiosUser);
	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
	rolUser = roleDao.save(rolUser);

	// Crear usuario
	Usuario user = new Usuario();
	user.setNombre("user");
	user.setContraseña(bCryptPasswordEncoder.encode("user"));
	Collection<Rol> rolesUser = new ArrayList<>();
	rolesUser.add(rolUser);
	user.setRoles(rolesUser);
	usuarioDao.save(user);

	/********************************
	 ************* ADMIN ************
	********************************/

	//Crear privilegio acceso-gestion-usuarios
	Privilegio privilegioAccesoGestionUsuarios = new Privilegio();
	privilegioAccesoGestionUsuarios.setNombre("acceso-gestion-usuarios");
	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
	privilegioAccesoGestionUsuarios = privilegioDao.save(privilegioAccesoGestionUsuarios);

	// Crear rol
	Rol rolAdmin = new Rol();
	rolAdmin.setNombre("ROLE_ADMIN");
	Collection<Privilegio> privilegiosAdmin = new ArrayList<>();
	privilegiosAdmin.add(privilegioAccesoPantallaPrincipal);
	privilegiosAdmin.add(privilegioAccesoGestionUsuarios);
	rolAdmin.setPrivilegios(privilegiosAdmin);
	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
	rolAdmin = roleDao.save(rolAdmin);

	// Crear usuario
	Usuario admin = new Usuario();
	admin.setNombre("admin");
	admin.setContraseña(bCryptPasswordEncoder.encode("admin"));
	Collection<Rol> rolesAdmin = new ArrayList<>();
	rolesAdmin.add(rolAdmin);
	rolesAdmin.add(rolUser);
	admin.setRoles(rolesAdmin);
	usuarioDao.save(admin);    		

}
```

Al guardar los objetos, es importante que estos tengan el id, para que Spring Data puede relacionar en la tablas intermedias (N:M) las relaciones con los ids.

Por eso se recuperar los objeos despues de guardarlos, ya que los objetos que retorna el metodo .save() si tiene el id.

Los ids de las tablas estan definidos como autonumericos, solo podemos saber el id despues de hacer el insert en la tabla.

# Nota
En este ejemplo el usuario y la contraseña se envian como texto plano al servidor y cualquiera podria interceptarlas.

Para que no ocurra esto, es imprescindible montar la aplicacion sobre Https, es decir, sobre SSL/TLS.