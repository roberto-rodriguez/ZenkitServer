/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.web;

import com.system.manager.AbstractManager;
import com.system.manager.RolePageAccessManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo
 */
@RestController
@RequestMapping(value = "/{pageId}/rolePageAccess")
public class RolePageAccessController extends AbstractController{
    
    @Autowired
    protected RolePageAccessManager rolepageManager;
     

    @Override
    public AbstractManager getAbstractManager() {
       return rolepageManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return rolepageManager;
  }
    
}
