package com.upf.resto.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.upf.resto.view.admin, com.upf.resto.service, com.upf.resto.dao, com.upf.resto.business")
public class AppConfig {
	@Autowired
    private Environment environment;


    @Bean("dataSource")
    @Profile("PROD")
    public DataSource prodDataSource(){
        String driverClassName = environment.getProperty("datasource.driverClassName");
        String url = environment.getProperty("datasource.url");
        String userName = environment.getProperty("datasource.userName");
        String password = environment.getProperty("datasource.password");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean("dataSource")
    @Profile("DEV")
    public DataSource devProdDataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").addScript("default-user.sql").build();
    }
}
