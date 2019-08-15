/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.manager;

import com.system.dao.AbstractBaseDAO;
import com.system.dao.PageAccessDAO;
import com.system.dao.RoleDAO;
import com.system.dao.RolePageAccessDAO;
import com.system.dto.RolePageAccessDTO;
import com.system.dto.request.Hash;
import com.system.model.PageAccess;
import com.system.model.Role;
import com.system.model.RolePageAccess; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo
 */
@Service
@Transactional
public class RolePageAccessManager extends AbstractManager<RolePageAccess, RolePageAccessDTO>{
    
    @Autowired
    private RolePageAccessDAO rolepageDAO;
    
    @Autowired
    private RoleDAO roleDAO;
    
    @Autowired
    private PageAccessDAO pageDAO;
      
    @Override
    public AbstractBaseDAO dao() {
        return rolepageDAO;
    }
    
    @Override
    protected RolePageAccess create(Hash data) throws Exception {
             
        if (rolepageDAO.exist(data.getInt("roleId"),  data.getInt("pageAccessId"))) {
                throw new RuntimeException("This Role is already associated with this Page.");
            }
        
            return new RolePageAccess();
    }

    @Override
    protected void update(RolePageAccess entity, Hash data) {
        Integer roleId = data.getInt("roleId");
        Integer pageAccessId = data.getInt("pageAccessId");       
                 
        entity.setCreat(data.getBoolean("creat"));
        entity.setUpd(data.getBoolean("upd"));
        entity.setDelt(data.getBoolean("delt"));
        
        Role role = roleDAO.findById(roleId);
        entity.setRole(role);     
        
        PageAccess page = pageDAO.findById(pageAccessId);
        entity.setPageAccess(page); 
    }
}
