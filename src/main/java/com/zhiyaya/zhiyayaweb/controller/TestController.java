package com.zhiyaya.zhiyayaweb.controller;


import com.zhiyaya.zhiyayaweb.dto.TestBean;
import com.zhiyaya.zhiyayaweb.mapper.MonitorDataMapper;
import com.zhiyaya.zhiyayaweb.model.MonitorData;
import com.zhiyaya.zhiyayaweb.utils.Jdpush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @Autowired
    private MonitorDataMapper monitorDataMapper;


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

    @RequestMapping(value = "/v1/api/monitor", method = RequestMethod.POST)
    public String post(@RequestBody TestBean data) {
        MonitorData monitorData = new MonitorData();
        monitorData.setAir(data.getAir());
        monitorData.setDeviceId(data.getId());
        monitorData.setFertility(data.getF());
        monitorData.setIntensity(data.getLight());
        monitorData.setMoisture(data.getHumi());
        monitorData.setTouch(data.getTouch());
        monitorData.setTemp(data.getT());
        monitorData.setCreateTime(LocalDateTime.now());
        monitorDataMapper.insert(monitorData);
        return "data_" + monitorData.getId();
    }
}
