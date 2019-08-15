package com.app.web;
 
 import com.app.manager.LogManager;
 import com.system.manager.AbstractManager;
 import com.system.web.AbstractController;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 
 /**
  *
  * @author DevTool
  */
 @RestController
 @RequestMapping(value = "/{pageId}/log")
 public class LogController extends AbstractController{
     
     @Autowired
     protected LogManager logManager;
      
 
     @Override
     public AbstractManager getAbstractManager() {
        return logManager;
     } 
 }
