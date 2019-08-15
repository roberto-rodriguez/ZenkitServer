/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.setup;

import com.app.manager.TaskManager;
import com.system.dto.request.Hash;
import com.system.dto.request.HashList;
import com.system.setup.*;
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
public class SetupTask implements Setup {

    @Autowired
    private TaskManager taskManager;

    @Override
    public void setup() {
        try {
            HashList tasks = new HashList(
                    new Hash(
                            "title", "Architecture",
                            "description", "Keep refining the architecture, and create all form fields.",
                            "assigneeId", 1,
                            "creationDate", new Date(),
                            "flag", null,
                            "estimatedHours", 20,
                            "loggedHours", 0,
                            "completed", 0,
                            "sprint", 1,
                            "status", 2
                    ),
                    new Hash(
                            "title", "Sprint Board page",
                            "description", "Finish Sprint design and database integration",
                            "assigneeId", 3,
                            "creationDate", new Date(),
                            "flag", 1,
                            "estimatedHours", 20,
                            "loggedHours", 0,
                            "completed", 0,
                            "sprint", 1,
                            "status", 2
                    ),
                    new Hash(
                            "title", "Task page",
                            "description", "Finish the task section to view/add/edit/remove a task",
                            "assigneeId", 2,
                            "creationDate", new Date(),
                            "flag", 2,
                            "estimatedHours", 20,
                            "loggedHours", 0,
                            "completed", 0,
                            "sprint", 1,
                            "status", 2
                    ),
                    new Hash(
                            "title", "Sprints page",
                            "description", "Finish the Sprints page, showing a list of sprints, open the sprints when click an item from the list and a button to Add new Sprint.",
                            "assigneeId", 4,
                            "creationDate", new Date(),
                            "flag", 3,
                            "estimatedHours", 20,
                            "loggedHours", 0,
                            "completed", 0,
                            "sprint", 1,
                            "status", 3
                    ),
                    new Hash(
                            "title", "Comments",
                            "description", "List of comments under the task. Add new Comment",
                            "assigneeId", 5,
                            "creationDate", new Date(),
                            "flag", 3,
                            "estimatedHours", 20,
                            "loggedHours", 0,
                            "completed", 0,
                            "sprint", 1,
                            "status", 1
                    )
            );

            for (Hash task : tasks) {
                taskManager.save(task);
            }

        } catch (Exception ex) {
            Logger.getLogger(SetupTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
