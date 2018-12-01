package com.zhiyaya.zhiyayaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yerunjie on 2018-12-01
 *
 * @author yerunjie
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    private String getCookie(String cookieName) {
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

    void addCookie(String name, String value) {
        addCookie(name, value, "/");
    }

    private void addCookie(String name, String value, String path) {
        addCookie(name, value, path, -1);
    }

    private void addCookie(String name, String value, String path, int maxAge) {
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
}
