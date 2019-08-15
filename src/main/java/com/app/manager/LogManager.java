package com.app.manager;
 
 import com.app.dao.LogDAO;
 import com.app.dto.LogDTO;
 import com.app.model.Log;
 import com.system.dao.AbstractBaseDAO;
 import com.system.dto.request.Hash;
 import com.system.manager.AbstractManager;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 
 /**
  *
  * @author DevTool
  */
 @Service
 @Transactional
 public class LogManager extends AbstractManager<Log, LogDTO>{
     
     @Autowired
     private LogDAO logDAO;
     
     @Override
     public AbstractBaseDAO dao() {
         return logDAO;
     }
     
     @Override
     protected Log create(Hash data) throws Exception {
         return new Log();
     }
     
     @Override
     protected void update(Log entity, Hash data) {
         entity.setName(data.getString("name"));
        entity.setDescription(data.getString("description"));
        entity.setCreationDate(data.getDate("creationDate"));
        entity.setClient(data.getInteger("client"));

     }
 }
