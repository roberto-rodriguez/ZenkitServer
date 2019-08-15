/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.web;

import com.system.manager.AbstractManager;
import com.system.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo
 */
@RestController
@RequestMapping(value = "/{pageId}/user")
public class UserController extends AbstractController{
    
    @Autowired
    protected UserManager userManager;
     

    @Override
    public AbstractManager getAbstractManager() {
       return userManager;
    }
    
    @Override
    public AbstractManager getReportManager(){
      return userManager;
  }
    
    
}
