package com.booterror.errordemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.ConstructorProperties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@Slf4j
public class ErrordemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrordemoApplication.class, args);
    }


    /**
     * 设置双数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("one.spring.datasource")
    public DataSourceProperties oneDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource oneDataSource() {
        DataSourceProperties dataSourceProperties = oneDataSourceProperties();
        log.info("one: {}",dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager oneTxManage(DataSource oneDataSource) {
        return new DataSourceTransactionManager(oneDataSource);
    }


    @Bean
    @ConfigurationProperties("two.spring.datasource")
    public DataSourceProperties twoDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource twoDataSource() {
        DataSourceProperties dataSourceProperties = twoDataSourceProperties();
        log.info("two: {}",dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean 
    @Resource
    public PlatformTransactionManager twoTxManage(DataSource twoDataSource) {
        return new DataSourceTransactionManager(twoDataSource);
    }


}
