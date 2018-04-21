package com.example.zhiyaya.model;

import lombok.Data;

import java.util.Date;

@Data
public class MonitorData {
    private Integer id;

    private Integer deviceId;

    private Double weight;

    private Integer intensity;

    private Integer moisture;

    private Float temp;

    private Date createTime;

}