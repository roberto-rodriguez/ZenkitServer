package com.app.web;
 
 import com.app.manager.TaskManager;
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
 @RequestMapping(value = "/{pageId}/task")
 public class TaskController extends AbstractController{
     
     @Autowired
     protected TaskManager taskManager;
      
 
     @Override
     public AbstractManager getAbstractManager() {
        return taskManager;
     } 
 }
