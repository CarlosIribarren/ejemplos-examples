# Configuracion 
- Se ha configurado Spring Security para que protega todas las peticiones.
- Se permite acceso a las URLs de tipo "/css/**". Para cargar los ficheros de css.

        .antMatchers("/css/**").permitAll() // This allows anyone to access a URL that begins with /css/. Since this is where our css, javascript, and images are stored all our static resources are viewable by anyone.
        .anyRequest().authenticated()

## Login
- Si se hace una peticion a una URL y el usuario no esta logeado, sale la pantalla de login. si el usuario se logea con exito, se redirigue a la URL que se ha configurado en la propiedades, en este caso "/".
- Todos los usuarios pueden acceder a la url de "/login"

        .loginPage("/login")
        	.permitAll() // allow any access to any URL (i.e. /login and /login?error) associated to formLogin()
        	.defaultSuccessUrl("/")

## Logout
- Se ha definido la URL para el logout, en este caso "/logout"
- Todos los usuarios pueden acceder a la url de "/logout"

        .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Define URL to logout
            .logoutSuccessUrl("/login?logout")
            .permitAll() // allows any user to request logout and view logout success URL.
            .invalidateHttpSession(true)
            .clearAuthentication(true);

## Usuarios
- Los usuarios estan creados en memoria, en la parte de la configuracion.

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        auth
          .inMemoryAuthentication()
          	.withUser("user")
          	.password(encoder.encode("user"))
          	.roles("USER") 
          .and()
          	.withUser("admin")
          	.password(encoder.encode("admin"))
          	.roles("ADMIN");