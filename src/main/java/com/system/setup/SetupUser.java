/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.setup;
 
import com.system.dao.QueryDAO;
import com.system.dto.request.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roberto.rodriguez
 */
@Service
public class SetupUser implements Setup {

    @Autowired
    private QueryDAO queryDAO;

    private static final String QUERY = "INSERT INTO system_user ( active,  entityid,  entity,  passw,  email,  first_name,  last_name,  username,  _role)"
            + "VALUES (:active, :entityid, :entity, :passw, :email, :first_name, :last_name, :username, :_role)";
 
    @Override
    public void setup() {
        queryDAO.query(QUERY, generate());
    }

    public Hash generate() {
        Hash hash = new Hash();
        hash.put("active", true);
        hash.put("passw", "sad");
        hash.put("email", "admin@admin.com");
        hash.put("first_name", "Admin");
        hash.put("last_name", "Admin");
        hash.put("_role", 1);
        hash.put("username", "sad");

        hash.put("entityid", 0);
        hash.put("entity", "Admin");

        return hash;
    }
}
