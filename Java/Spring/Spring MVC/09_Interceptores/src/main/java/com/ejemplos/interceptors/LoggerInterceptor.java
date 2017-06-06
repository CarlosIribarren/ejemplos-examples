package com.ejemplos.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

  static Logger logger = Logger.getLogger(LoggerInterceptor.class);

  static {

    BasicConfigurator.configure();

  }

  @Override
  public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
      throws Exception {

    logger.info("Antes de manipular la solicitud request");

    return super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
      final ModelAndView modelAndView) throws Exception {

    logger.info("Despues de manipular la solicitud request");

    logger.info("ViewName : " + modelAndView.getViewName());

    super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
      final Object handler, final Exception ex)

      throws Exception {

    logger.info("Antes de redurigir a la Vista");

    super.afterCompletion(request, response, handler, ex);
  }

}
