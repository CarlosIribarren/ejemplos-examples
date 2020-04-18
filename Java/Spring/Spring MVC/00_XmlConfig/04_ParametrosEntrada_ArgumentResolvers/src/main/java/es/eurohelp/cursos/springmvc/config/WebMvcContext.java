package es.eurohelp.cursos.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import es.eurohelp.cursos.springmvc.argumentresolvers.IdEstudianteArgumentResolver;

import java.util.List;
  
@Configuration
@EnableWebMvc
class WebMvcContext extends WebMvcConfigurerAdapter {
  
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new IdEstudianteArgumentResolver());
    }
}