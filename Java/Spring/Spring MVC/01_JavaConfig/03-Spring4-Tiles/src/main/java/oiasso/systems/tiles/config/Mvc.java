package oiasso.systems.tiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@EnableWebMvc // <mvc:annotation-driven />
@Configuration
@ComponentScan({ "oiasso.systems.tiles" })
public abstract class Mvc extends WebMvcConfigurerAdapter {

  @Bean
  public TilesViewResolver tilesViewResolver() {
    final TilesViewResolver tilesViewResolver = new TilesViewResolver();
    tilesViewResolver.setViewClass(TilesView.class);
    tilesViewResolver.setRequestContextAttribute("springRequestContext");
    tilesViewResolver.setOrder(1);
    return tilesViewResolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    final TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles-defs.xml" });
    return tilesConfigurer;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new SessionLocaleResolver();
  }

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    // registrar el parametro locale que pasamos para el multilenguaje
    final LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
    localeInterceptor.setParamName("locale");

    registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
  }
  
}

