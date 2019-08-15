/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.setup;

import com.system.dao.QueryDAO;
import com.system.enums.PageAccessEnum;
import com.system.setup.Setup;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
public class SetupPageAccess implements Setup{
    
    @Autowired
    private QueryDAO queryDAO;
    
    @Override
    public void setup() {         
        Arrays.stream(PageAccessEnum.values())
                .forEach(n -> {
                    queryDAO.query("INSERT INTO system_page_access (idpage, nombre) VALUES ( '" + n.getIdPage() + "', '" + n.getName() + "')");
                });
  }    
    
}
