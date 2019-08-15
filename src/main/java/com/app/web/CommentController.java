package com.app.web;
 
 import com.app.manager.CommentManager;
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
 @RequestMapping(value = "/{pageId}/comment")
 public class CommentController extends AbstractController{
     
     @Autowired
     protected CommentManager commentManager;
      
 
     @Override
     public AbstractManager getAbstractManager() {
        return commentManager;
     } 
 }
