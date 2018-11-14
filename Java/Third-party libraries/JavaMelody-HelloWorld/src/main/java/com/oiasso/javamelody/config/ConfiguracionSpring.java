package com.oiasso.javamelody.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.oiasso.javamelody")
@EnableWebMvc
public class ConfiguracionSpring  extends WebMvcConfigurerAdapter {
     

}

