/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dao;

import com.system.dto.RolePageAccessDTO;
import com.system.model.RolePageAccess;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo
 */
@Repository
public class RolePageAccessDAO extends AbstractBaseDAO<RolePageAccess, RolePageAccessDTO>{
    
    @Override
    public Criteria buildCriteria() {
        return getCriteria()
                .createAlias("role", "role")
                .createAlias("pageAccess", "pageAccess");
    }

    @Override
    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("pageAccess.nombre"));
    } 

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("creat").as("creat"))
                .add(Projections.property("upd").as("upd"))
                .add(Projections.property("delt").as("delt"))
                .add(Projections.property("role.id").as("roleId"))
                .add(Projections.property("role.nombre").as("role"))
                .add(Projections.property("pageAccess.id").as("pageAccessId"))
                .add(Projections.property("pageAccess.nombre").as("pageAccess"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(RolePageAccessDTO.class));
    }
    
    @Transactional
    public List<String> getPageAccessByRole(Integer appRole) { 
        return getCriteria()
                .createAlias("role", "role")
                .createAlias("pageAccess", "pageAccess")
                .add(Restrictions.eq("role.id", appRole))
                .setProjection(Projections.property("pageAccess.idPage").as("idPage"))
                .list();
    }
    
    @Transactional
    public void deleteByPageId(String pageId) { 
        List<RolePageAccess> list = getCriteria() 
                .createAlias("pageAccess", "pageAccess")
                .add(Restrictions.like("pageAccess.idPage", pageId)) 
                .list();
        
        for (RolePageAccess rolePageAccess : list) {
            delete(rolePageAccess);
        }
    }
    
    public Boolean exist(Integer idRole, Integer idPageAccess) {
        return  buildCriteria()
                .add(Restrictions.eq("role.id", idRole))
                .add(Restrictions.eq("pageAccess.id", idPageAccess))                
                .setMaxResults(1)
                .uniqueResult() != null;       
    }
    
    public Boolean existRole(Integer idRole) {
        return  buildCriteria()
                .add(Restrictions.eq("role.id", idRole))                               
                .setMaxResults(1)
                .uniqueResult() != null;       
    }
    
    public Boolean existPageAccess(Integer idPage) {
        return  buildCriteria()
                .add(Restrictions.eq("pageAccess.id", idPage))                               
                .setMaxResults(1)
                .uniqueResult() != null;       
    }
    
    public Boolean getPermission(Integer idRole, Integer idPageAccess, String operation){
        Criteria criteria = buildCriteria()
                .add(Restrictions.eq("role.id", idRole))
                .add(Restrictions.eq("pageAccess.id", idPageAccess));
        
        ProjectionList projectionList = Projections.projectionList();
        
        switch (operation){
            case "delete":
               projectionList.add(Projections.property("delt").as("delt"));
                break;
            case "create":
               projectionList.add(Projections.property("creat").as("creat"));
                break;
            case "update":
               projectionList.add(Projections.property("upd").as("upd"));
                break;
        }
        
        return (Boolean) criteria.setProjection(projectionList)
                                    .setMaxResults(1)
                                    .uniqueResult();
        
    }
    
}
