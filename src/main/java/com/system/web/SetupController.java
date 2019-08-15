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
package com.system.web;

import com.app.setup.AppSetup;
import com.system.setup.SetupSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@RequestMapping(value = "/setup", method = RequestMethod.GET)
public class SetupController {

    @Autowired
    private SetupSystem setupSystem;

    @Autowired
    private AppSetup appSetup;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String setupAll() throws Exception {
        System.out.println("Setup---all");
        setupSystem.setup();
        appSetup.setup();
        return "DONE";
    }

    @RequestMapping(value = "/system", method = RequestMethod.GET)
    public String setupProd() throws Exception {
        System.out.println("Setup---system");
        setupSystem.setup();

        return "DONE";
    }

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String appSetup() throws Exception {
        System.out.println("Setup---app");
        appSetup.setup();
        return "DONE";
    }

//    @RequestMapping(value = "/tx/{n}", method = RequestMethod.GET)
//    public String tx(@PathVariable("n") Integer n) {
//        Long l = System.currentTimeMillis();
//        System.out.println("Setup - tx -> " + n);
//        setupDev.setupTx(n);
//        return "Completted in " + (System.currentTimeMillis() - l) + " milliseconds.";
//    }
}
