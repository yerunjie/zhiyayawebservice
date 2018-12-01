package com.zhiyaya.zhiyayaweb.wx;

import com.zhiyaya.zhiyayaweb.wx.response.Code2Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yerunjie on 2018-12-01
 *
 * @author yerunjie
 */
public interface WxApi {

    @RequestMapping(value = "/jscode2session", method = RequestMethod.GET)
    Code2Session code2Session(@RequestParam("js_code") String code,
                              @RequestParam("grant_type") String grant_type);
}
