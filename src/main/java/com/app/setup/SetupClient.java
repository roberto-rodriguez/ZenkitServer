/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.setup;

import com.app.manager.ClientManager;
import com.system.dto.request.Hash;
import com.system.dto.request.HashList;
import com.system.setup.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
public class SetupClient implements Setup {

    @Autowired
    private ClientManager clientManager;

    @Override
    public void setup() {
        try {

            HashList users = new HashList(
                    new Hash(
                            "name", "Rober",
                            "username", "r",
                            "passw", "r"
                    ),
                    new Hash(
                            "name", "Ismail",
                            "username", "i",
                            "passw", "i"
                    ),
                    new Hash(
                            "name", "Javier",
                            "username", "j",
                            "passw", "j"
                    ),
                    new Hash(
                            "name", "Eduardo",
                            "username", "e",
                            "passw", "e"
                    ),
                    new Hash(
                            "name", "Annier",
                            "username", "a",
                            "passw", "a"
                    ) 
            );

            for (Hash user : users) {
                clientManager.save(user);
            }

        } catch (Exception ex) {
            Logger.getLogger(SetupClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
