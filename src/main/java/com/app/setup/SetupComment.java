/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.setup;

import com.app.manager.CommentManager;
import com.system.dto.request.Hash;
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
public class SetupComment implements Setup {

    @Autowired
    private CommentManager commentManager;

    @Override
    public void setup() {
        Hash hash = new Hash(
                "title", "Sample Comment",
                "description", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "client", 1,
                "creationDate", new Date(),
                "task", 1
        );

        try {
            commentManager.save(hash);
        } catch (Exception ex) {
            Logger.getLogger(SetupComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
