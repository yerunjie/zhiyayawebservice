package com.zhiyaya.zhiyayaweb.wx.response;

import lombok.Data;
import lombok.ToString;

/**
 * Created by yerunjie on 2018-12-01
 *
 * @author yerunjie
 */
@Data
@ToString
public class Code2Session {
    private String openid;
    private String session_key;
    private String unionid;
    private int errcode;
    private String errmsg;
}
