# Ejemplo
En este ejemplo se muestra como hacer login con usuarios en base de datos.

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

## Usuarios
Los usuarios estan definidos en la BD. La primera vez se insertan los usuarios admin y user.

El password se guarda en la BD encriptado. (Ejemplo de admin: $2a$10$SUSDaYLh8Z3O/aZxpe9fGO83sItnUvjqigqnV9YsvGlY1QByZ/ln6). El password se guarda encriptado, porque, se ha configurado que los passwords en la BD estan encriptados. 

Entonces cuando un usuario hace login, en el service UserDetailsServiceImpl se obtiene el usuario de la BD y se retorna como un User de Spring Security. Con ese usuario que se retorna de esa clase, Spring Security automaticamente desencriptara el password para compararlo con el password introducido por el usuario. Y asi de esta manera concuerdan los password.

Si hicieramos un CRUD, al insertar un usuario nuevo, tendriamos que encriptar el password de la misma manera. 

```java        
if(!usuarioDao.existsById(1)) {
        Usuario admin = new Usuario();
        admin.setId(1);
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        usuarioDao.save(admin);    		
}
		
if(!usuarioDao.existsById(2)) {
        Usuario user = new Usuario();
        user.setId(2);
        user.setUsername("user");
        user.setPassword(bCryptPasswordEncoder.encode("user"));
        usuarioDao.save(user);    		
} 
``` 

# Roles
El objetivo de este ejemplo no es mostrar el uso de los Roles, pero se utilizan.

Al obtener el usuario de la BD para validar el login, se añade el rol de admin o de user.

Por defecto en Spring Security los Roles se guardan los el prefijo de "ROLE_", esto es algo que se puede configurar.

```java 
// Se simula la parte de obtener el rol.
// Por defecto en Spring Security los Roles se guardan los el prefijo de "ROLE_", se puede configurar
switch (username) {
        case "admin":
                grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
        case "user":
                grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
        default:
                break;
}
```

Y luego en las pantallas se utilizan los roles para mostrar o no enlaces,...
```html
<!-- Solo los usuarios admin puede gestionar usuarios -->
<div sec:authorize="hasRole('ROLE_ADMIN')">
        <a th:href="@{/usuarios}">Gestion de usuarios</a>
</div>
```

# Nota
En este ejemplo el usuario y la contraseña se envian como texto plano al servidor y cualquiera podria interceptarlas.

Para que no ocurra esto, es imprescindible montar la aplicacion sobre Https, es decir, sobre SSL/TLS.