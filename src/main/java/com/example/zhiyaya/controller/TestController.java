package com.example.zhiyaya.controller;


import com.example.zhiyaya.mapper.MonitorDataMapper;
import com.example.zhiyaya.model.MonitorData;
import com.example.zhiyaya.utils.Jdpush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TestController {

    @Autowired
    private MonitorDataMapper monitorDataMapper;

    @RequestMapping(value = "/v1/api/test_post/{id}", method = RequestMethod.POST)
    public String post(@PathVariable("id") int id, @RequestBody MonitorData data) {
        System.out.println(data);
        data.setDeviceId(id);
        data.setCreateTime(new Date());
        //monitorDataMapper.insert(data);
        return "post_" + id;
    }


    @RequestMapping(value = "/v1/api/test_get", method = RequestMethod.GET)
    public String get(@RequestParam("para") String para) {
        System.out.println(para);
        return "get" + para;
    }

    @RequestMapping(value = "/v1/api/get", method = RequestMethod.GET)
    public String get() {
        System.out.println(123);
        Jdpush.testSendPush();
        return "get";
    }
}
