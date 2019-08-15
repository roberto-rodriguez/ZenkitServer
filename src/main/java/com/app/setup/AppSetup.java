/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.setup;

import com.system.setup.*;
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
public class AppSetup extends BaseManager {

    @Autowired
    private SetupClient setupClient;

    @Autowired
    private SetupComment setupComment;

    @Autowired
    private SetupSprint setupSprint;

    @Autowired
    private SetupTask setupTask;

    public void setup() throws Exception {
        List<Setup> setups = Arrays.asList(
                setupClient,
                setupSprint,
                setupTask,
                setupComment
        );

        for (Setup setup : setups) {
            setup.setup();
        }
    }

}
