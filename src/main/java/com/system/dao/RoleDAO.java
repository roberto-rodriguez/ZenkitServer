/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dao;

import com.system.dto.RoleDTO;
import com.system.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roberto
 */
@Repository
public class RoleDAO extends AbstractBaseDAO<Role, RoleDTO>{
    
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("nombre"));
    } 
     
    //campos a devolver en la consulta
    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("nombre").as("nombre"))
                .add(Projections.property("description").as("description"));
         
        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(RoleDTO.class));
    }
    
    public Boolean isSetup(){
        return (Long)getCriteria().setProjection(Projections.rowCount()).uniqueResult() > 0;
    }
    
}
