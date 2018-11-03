package com.example.zhiyaya.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class MonitorData {

    private int id;
    private int deviceId;
    private int fertility;
    private int air;
    private int intensity;
    private int moisture;
    private int touch;
    private float temp;
    private LocalDateTime createTime;
}