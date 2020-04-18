package com.ejemplos.interceptors;

import java.util.ArrayDeque;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class NombreVistaInterceptor extends HandlerInterceptorAdapter {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  private final ArrayDeque<String> pila = new ArrayDeque<>();

  @Override
  public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
      final ModelAndView modelAndView) throws Exception {

    // Añadir el nombre de la vista en una pila
    this.pila.push(modelAndView.getViewName());

    // Añadir la pila a la vista
    modelAndView.addObject("pila", this.pila);

    super.postHandle(request, response, handler, modelAndView);
  }

}
