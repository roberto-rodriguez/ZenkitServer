package com.app.web;
 
 import com.app.manager.SprintManager;
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
 @RequestMapping(value = "/{pageId}/sprint")
 public class SprintController extends AbstractController{
     
     @Autowired
     protected SprintManager sprintManager;
      
 
     @Override
     public AbstractManager getAbstractManager() {
        return sprintManager;
     } 
 }
