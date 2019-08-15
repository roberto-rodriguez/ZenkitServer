/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dao;

import com.system.dto.UserDTO;
import com.system.model.User;
import com.system.session.Principal;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  
 */
@Repository
public class UserDAO extends AbstractBaseDAO<User, UserDTO>{
    
     @Override
     public Criteria buildCriteria() {
        return getCriteria()
                .createAlias("role", "role");
    }

     @Override
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("firstName"));
    }
    
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("firstName").as("firstName"))
                .add(Projections.property("lastName").as("lastName"))
                .add(Projections.property("username").as("username"))
                .add(Projections.property("passw").as("passw"))  
                .add(Projections.property("email").as("email"))
                .add(Projections.property("active").as("active"))               
                .add(Projections.property("role.id").as("roleId"))
                .add(Projections.property("role.nombre").as("role"))
                .add(Projections.property("entityId").as("entityId"))
                .add(Projections.property("entity").as("entity"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(UserDTO.class));
    }
    
    public Boolean exist(String username) {
          return buildCriteria()
                .add(Restrictions.eq("username", username))
                .setMaxResults(1)
                .uniqueResult() != null;
    }
    
    public Boolean existRole(Integer idRole) {
        return  buildCriteria()
                .add(Restrictions.eq("role.id", idRole))                               
                .setMaxResults(1)
                .uniqueResult() != null;       
    }
    
    public Boolean getActive(String username, String password) {
         return (Boolean) getCriteria()
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("passw", password))
                .setProjection(Projections.property("active"))
                .setMaxResults(1)
                .uniqueResult();     
    }
    
    public Principal getPrincipal(String username, String password)throws Exception {
           
        //criterio de busqueda
        Criteria criteria = buildCriteria()
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("passw", password))
                .setMaxResults(1);
        //datos a devolver
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("firstName").as("firstName"))
                .add(Projections.property("lastName").as("lastName"))
                .add(Projections.property("role.id").as("roleId"))
                .add(Projections.property("role.nombre").as("role")) 
                .add(Projections.property("entityId").as("entityId"))
                .add(Projections.property("entity").as("entity"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Principal.class));

        return (Principal) criteria.uniqueResult();
    }
    
}
