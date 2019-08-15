/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.setup;

import com.app.setup.AppSetup;
import com.system.dao.RoleDAO;
import com.system.manager.BaseManager;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto.rodriguez
 */
@Service
public class SetupSystem extends BaseManager {

    @Autowired
    private SetupRole setupRole;

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private SetupPageAccess setupPageAccess;

    @Autowired
    private SetupRolePageAccess setupRolePageAccess;

    @Autowired
    private SetupUser setupUser;

    @Autowired
    private AppSetup appSetup;

    public void setup() throws Exception {
        List<Setup> setups = Arrays.asList(
                setupRole,
                setupPageAccess,
                setupRolePageAccess,
                setupUser
        );

        System.out.println("Setting up system...");
        for (Setup setup : setups) {
            setup.setup();
        }

        System.out.println("Setting up app...");
        appSetup.setup();
    }

    public Boolean isSetup() {
        return roleDAO.isSetup();
    }
}
