package oiasso.systems.elastic.example;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { Config.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
