package com.zhiyaya.zhiyayaweb.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.zhiyaya.zhiyayaweb.mapper")
@EnableTransactionManagement
public class PersistenceConfig {

}