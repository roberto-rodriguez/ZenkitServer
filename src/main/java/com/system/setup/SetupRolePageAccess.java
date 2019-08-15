/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.setup;

import com.system.dao.QueryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
public class SetupRolePageAccess implements Setup {

    @Autowired
    private QueryDAO queryDAO;

    @Override
    public void setup() {
    }
}
