package com.example.zhiyaya.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.example.zhiyaya.mapper")
@EnableTransactionManagement
public class PersistenceConfig {

}