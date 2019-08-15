/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.setup;

import com.system.dao.QueryDAO;
import com.system.enums.RoleEnum; 
import com.system.util.StringUtil;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
public class SetupRole implements Setup{
    
    @Autowired
    private QueryDAO queryDAO;
    
    @Override
    public void setup() {         
        Arrays.stream(RoleEnum.values())
                .forEach(n -> {
                    String name = StringUtil.capitalizeFirstLetter(n.toString());
                    queryDAO.query("INSERT INTO system_role (id, nombre, description ) VALUES ( " + n.getId() + " , '" +  name + "', 'Role for the " + name + "')");
                });
  }    
    
}
