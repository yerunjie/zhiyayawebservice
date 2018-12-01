package com.zhiyaya.zhiyayaweb.interceptor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yerunjie
 */
public abstract class BaseInterceptor extends HandlerInterceptorAdapter {

  protected void makeResponse(
      Object controller,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse)
      throws IOException {
    if (controller.getClass().isAnnotationPresent(RestController.class)
        || controller.getClass().getSuperclass().isAnnotationPresent(RestController.class)) {
      httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      httpServletResponse.sendRedirect("/signin?redirectUrl=" + httpServletRequest.getRequestURI());
    }
  }

  protected void makeResponse(String message, HttpServletResponse httpServletResponse)
      throws IOException {
    httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    httpServletResponse.setContentType("text/html;charset=utf-8");
    httpServletResponse.getWriter().println(message);
  }

  protected String getTokenFromHeaderOrCookie(HttpServletRequest request, String key) {
    String header = getHeader(request, key);
    if (header != null) {
      return header;
    }
    String cookie = getCookie(request, key);
    return cookie;
  }

  protected String getHeader(HttpServletRequest request, String key) {
    return request.getHeader(key);
  }

  protected String getCookie(HttpServletRequest request, String cookieName) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      return null;
    }
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(cookieName)) {
        return cookie.getValue();
      }
    }
    return null;
  }
}
