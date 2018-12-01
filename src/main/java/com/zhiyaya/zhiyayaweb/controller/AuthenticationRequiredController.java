package com.zhiyaya.zhiyayaweb.controller;

import com.zhiyaya.zhiyayaweb.dto.Token;
import com.zhiyaya.zhiyayaweb.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yerunjie on 2018-12-01
 *
 * @author yerunjie
 */
public abstract class AuthenticationRequiredController extends BaseController {

    @Autowired
    protected TokenService tokenService;

    public void setToken(Token token) {
        tokenService.setToken(token);
    }

    public Token getToken() {
        return tokenService.getToken();
    }
}
