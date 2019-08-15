/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.setup;

import com.app.manager.ClientManager;
import com.app.manager.SprintManager;
import com.system.dto.request.Hash;
import com.system.setup.*;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robert
 */
@Service
public class SetupSprint implements Setup {

    @Autowired
    private SprintManager sprintManager;

    @Override
    public void setup() {
        try {
            Calendar C = Calendar.getInstance();
            C.set(Calendar.MONTH, Calendar.AUGUST);
            C.set(Calendar.DATE, 15);
            Date startDate = C.getTime();
            C.add(Calendar.DATE, 10);
            Date endDate = C.getTime();

            Hash sprint1 = new Hash(
                    "name", "August 15 - 25. Finish Senkit",
                    "active", true,
                    "startDate", startDate,
                    "endDate", endDate,
                    "hours", 160,
                    "loggedHours", 0,
                    "completed", 0
            );

            sprintManager.save(sprint1);

            C.add(Calendar.DATE, 10);

            Hash sprint2 = new Hash(
                    "name", "August 25 - Sept 5. Next thing",
                    "active", false,
                    "startDate", endDate,
                    "endDate", C.getTime(),
                    "hours", 200,
                    "loggedHours", 0,
                    "completed", 0
            );

            sprintManager.save(sprint2);
        } catch (Exception ex) {
            Logger.getLogger(SetupSprint.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
