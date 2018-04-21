package com.example.zhiyaya.mapper;

import com.example.zhiyaya.model.MonitorData;

public interface MonitorDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorData record);

    int insertSelective(MonitorData record);

    MonitorData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorData record);

    int updateByPrimaryKey(MonitorData record);
}