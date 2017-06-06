package com.ejemplos.config;

import com.ejemplos.interceptors.LoggerInterceptor;
import com.ejemplos.interceptors.NombreVistaInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc // <mvc:annotation-driven />
@Configuration
@ComponentScan({ "com.ejemplos.*" })
public abstract class WebMvc extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Bean
  public InternalResourceViewResolver viewResolver() {
    final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  /** Definir Interceptores */
  @Bean
  public NombreVistaInterceptor nombreVistaInterceptor() {
    return (new NombreVistaInterceptor());
  }

  @Bean
  public LoggerInterceptor loggerInterceptor() {
    return (new LoggerInterceptor());
  }

  /** Registrar los Path Patterns en los interceptores */
  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    // NombreVistaInterceptor
    registry.addInterceptor(this.nombreVistaInterceptor()).addPathPatterns("/*");
    // LoggerInterceptor
    registry.addInterceptor(this.loggerInterceptor()).addPathPatterns("/*");
  }

}
