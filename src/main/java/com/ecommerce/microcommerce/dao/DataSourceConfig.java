package com.ecommerce.microcommerce.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/* PROD HEROKU */
import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
//import java.sql.DriverManager;
//import org.springframework.context.annotation.*;

/* necessaire pour mapping */

@Configuration
public class DataSourceConfig {


    @Autowired  Environment env;

    @Value("${prod.spring.datasource.url}")
    private String prodDbUrl;

    @Value("${modeDevLocal}")
    private boolean isDev;

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        if(isDev){
            final DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(env.getProperty("driverClassName"));
            dataSource.setUrl(env.getProperty("url"));
            dataSource.setUsername(env.getProperty("user"));
            dataSource.setPassword(env.getProperty("password"));
            return dataSource;
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(prodDbUrl);
            return new HikariDataSource(config);

            //URI dbUri = new URI(prodDbUrl);
            //String username = dbUri.getUserInfo().split(":")[0];
            //String password = dbUri.getUserInfo().split(":")[1];
            //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            //return DriverManager.getConnection(dbUrl, username, password);


        }

    }

    /* Client REST */
    @Bean
    public RestTemplate restTemplate()  {

        return new RestTemplate();
    }
}

