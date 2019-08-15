/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.web;

import com.system.manager.AbstractManager;
import com.system.manager.PageAccessManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo
 */
@RestController
@RequestMapping(value = "/{pageId}/pageAccess")
public class PageAccessController extends AbstractController{
    
    @Autowired
    protected PageAccessManager pageManager;
     

    @Override
    public AbstractManager getAbstractManager() {
       return pageManager;
    }
    
     @Override
    public AbstractManager getReportManager(){
      return pageManager;
  
    }
    
}
