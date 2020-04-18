package oiasso.system.examples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        	.antMatchers("/css/**").permitAll() // This allows anyone to access a URL that begins with /css/. Since this is where our css, javascript, and images are stored all our static resources are viewable by anyone.
        	
        	// las URL se ordenan de mas precision a menos precision
        	.antMatchers("/mi-usuario_detalles").authenticated()
        	.antMatchers("/usuarios/**").hasRole("ADMIN")
        	.antMatchers("/usuarios/**").hasAuthority("acceso-gestion-usuarios")
        	.antMatchers("/**").authenticated()
        	
        	.and()
        .formLogin()
        	.loginPage("/login")
        		.permitAll() // allow any access to any URL (i.e. /login and /login?error) associated to formLogin()
        		.defaultSuccessUrl("/")
        	.and()
        	.logout()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Define URL to logout
        		.logoutSuccessUrl("/login?logout")
        		.permitAll() // allows any user to request logout and view logout success URL.
        		.invalidateHttpSession(true)
        		.clearAuthentication(true);
    }
    
    
    
}