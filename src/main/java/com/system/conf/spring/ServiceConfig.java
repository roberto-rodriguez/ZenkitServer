/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.conf.spring;

import com.system.dev.DevExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author rrodriguez2
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({
    "com.system.manager",
    "com.system.session",
    "com.system.setup",
    "com.app.setup",
    "com.system.dev",
    "com.app.manager" 
})
@PropertySource({"classpath:hibernate.properties"})
public class ServiceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DevExecutor devExecutor() {
        String path = env.getProperty("dev.path");
        return new DevExecutor(path);
    }
 
}
