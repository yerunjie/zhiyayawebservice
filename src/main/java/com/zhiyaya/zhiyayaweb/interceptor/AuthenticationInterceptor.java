package com.zhiyaya.zhiyayaweb.interceptor;

import com.zhiyaya.zhiyayaweb.annotation.Authentication;
import com.zhiyaya.zhiyayaweb.constants.Role;
import com.zhiyaya.zhiyayaweb.controller.AuthenticationRequiredController;
import com.zhiyaya.zhiyayaweb.dto.Token;
import com.zhiyaya.zhiyayaweb.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component("authenticationInterceptor")
public class AuthenticationInterceptor extends BaseInterceptor {

    @Autowired
    private TokenService tokenService;

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object handler)
            throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            Set<Role> roles = new HashSet<>();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Authentication authentication =
                    ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);

            AuthenticationRequiredController controller = null;
            if (authentication != null) {
                Collections.addAll(roles, authentication.value());
            }
            if (handlerMethod.getBean() instanceof AuthenticationRequiredController) {
                controller = (AuthenticationRequiredController) handlerMethod.getBean();
                authentication = controller.getClass().getAnnotation(Authentication.class);
                if (authentication != null) {
                    Collections.addAll(roles, authentication.value());
                }
            }
            Token token = getToken(httpServletRequest);
            if (roles.isEmpty()) { // 没有声明需要权限,或者声明不验证权限
                if (token != null) {
                    tokenService.setToken(token);
                }
                return true;
            } else {
                logger.info("token:" + token + " request:" + httpServletRequest.getRequestURI());
                if (token == null || token.isExpired()) {
                    makeResponse(controller, httpServletRequest, httpServletResponse);
                    return false;
                }
                tokenService.setToken(token);
                if (roles.contains(token.getRole()) || token.getRole() == Role.SuperAdmin) {
                    return true;
                } else {
                    makeResponse(handlerMethod.getBean(), httpServletRequest, httpServletResponse);
                    return false;
                }
            }
        } else {
            return true;
        }
    }


    private Token getToken(HttpServletRequest request) {
        String tokenString = getTokenFromHeaderOrCookie(request, "X-TOKEN");
        if (tokenString == null) {
            return null;
        }
        try {
            Token token = tokenService.parseToken(tokenString);
            return token;
        } catch (RuntimeException e) {
            return null;
        }
    }
}
