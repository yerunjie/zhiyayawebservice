package com.zhiyaya.zhiyayaweb.controller.wx;

import com.zhiyaya.zhiyayaweb.constants.Role;
import com.zhiyaya.zhiyayaweb.controller.BaseController;
import com.zhiyaya.zhiyayaweb.dto.LoginResponse;
import com.zhiyaya.zhiyayaweb.service.TokenService;
import com.zhiyaya.zhiyayaweb.wx.WxApi;
import com.zhiyaya.zhiyayaweb.wx.response.Code2Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by yerunjie on 2018-12-01
 *
 * @author yerunjie
 */
@RestController
@RequestMapping("/v1/api")
public class WxController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(WxController.class);

    @Autowired
    private WxApi wxApi;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/wx/token", method = RequestMethod.GET)
    public LoginResponse login(@RequestParam("code") String code) {
        logger.info("code: {}",code);
        Code2Session code2Session = wxApi.code2Session(code, "authorization_code");
        logger.info("code2Session: {}", code2Session.toString());
        String token = tokenService.generateToken(Role.User, 1);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        return loginResponse;
    }

}
