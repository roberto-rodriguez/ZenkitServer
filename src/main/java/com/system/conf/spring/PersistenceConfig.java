/*
 ** File: WebResponse.java
 **
 ** Date Created: December 2016
 **
 ** Copyright @ 2016-2018 Roberto Rodriguez.
 ** Email: robertoSoftwareEngineer@gmail.com
 **
 ** All rights reserved. No part of this software may be 
 ** reproduced, transmitted, transcribed, stored in a retrieval 
 ** system, or translated into any language or computer language, 
 ** in any form or by any means, electronic, mechanical, magnetic, 
 ** optical, chemical, manual or otherwise, without the prior 
 ** written permission of Roberto Rodriguez.
 **
 */
package com.system.conf.spring;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment; 
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author rrodriguez2
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({
    "com.system.dao",
    "com.app.dao"
})
@PropertySource({"classpath:hibernate.properties"})
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver_class"));
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
        dataSource.setUsername(env.getProperty("hibernate.connection.username"));
        dataSource.setPassword(env.getProperty("hibernate.connection.password"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{
            "com.system.model",
            "com.app.model"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
     

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());

        return txManager;
    }

//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                //setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                //     setProperty("hibernate.hbm2ddl.auto", "create");
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.type", "trace");
                setProperty("current_session_context_class", "thread");
                setProperty("hibernate.enable_lazy_load_no_trans", "true");
                //setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    } 
}
