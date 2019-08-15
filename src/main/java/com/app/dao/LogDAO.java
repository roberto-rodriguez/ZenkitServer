package com.app.dao;
 
 import com.app.dto.LogDTO; 
 import com.app.model.Log;
 import com.system.dao.AbstractBaseDAO;
 import org.hibernate.Criteria;
 import org.hibernate.criterion.Order;
 import org.hibernate.criterion.ProjectionList;
 import org.hibernate.criterion.Projections;
 import org.hibernate.transform.Transformers;
 import org.springframework.stereotype.Repository;
 
 /**
  *
  * @author DevTool
  */
 @Repository
 public class LogDAO extends AbstractBaseDAO<Log, LogDTO>{
  
     
     @Override
     public void applyListProjection(Criteria criteria) {
         ProjectionList projectionList = Projections.projectionList()
                 .add(Projections.property("id").as("id"))
         .add(Projections.property("name").as("name"))
        .add(Projections.property("description").as("description"))
        .add(Projections.property("creationDate").as("creationDate"))
        .add(Projections.property("client").as("client"))
; 
 
         criteria.setProjection(projectionList)
                 .setResultTransformer(Transformers.aliasToBean(LogDTO.class));
     }
 }
