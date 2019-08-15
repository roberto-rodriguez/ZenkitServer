/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.conf.contextListener;

import com.system.setup.SetupSystem;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author roberto.rodriguez
 */
public class SystemContextListener implements ServletContextListener {

    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("SystemContextListener -> contextInitialized");

        WebApplicationContext CTX = ContextLoader.getCurrentWebApplicationContext();

        SetupSystem setupSystem = (SetupSystem) CTX.getBean("setupSystem");

        Boolean isSetup = setupSystem.isSetup();

        System.out.println("isSetup = " + isSetup);

        if (!isSetup) {
            try {
                setupSystem.setup();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
