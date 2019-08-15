/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.manager;

import com.system.dao.AbstractBaseDAO;
import com.system.dao.RoleDAO;
import com.system.dao.RolePageAccessDAO;
import com.system.dao.UserDAO;
import com.system.dto.RoleDTO;
import com.system.dto.request.Hash;
import com.system.dto.response.WebResponseData;
import com.system.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo
 */
@Service
@Transactional
public class RoleManager extends AbstractManager<Role, RoleDTO> {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO user;

    @Autowired
    private RolePageAccessDAO rolePageAcces;

    @Override
    public AbstractBaseDAO dao() {
        return roleDAO;
    }

    @Override
    protected Role create(Hash data) throws Exception {
        return new Role();
    }

    @Override
    protected void update(Role entity, Hash data) {
        entity.setNombre(data.getString("nombre"));
        entity.setDescription(data.getString("description"));
    }

    private boolean inUse(Integer entityId) {
        return (rolePageAcces.existRole(entityId) || user.existRole(entityId));
    }

    @Override
    public WebResponseData del(Role entity) throws Exception {

        boolean used = inUse(entity.getId());
        if (!used) {
            dao().delete(entity);
            return new WebResponseData();
        }
        return new WebResponseData(500, "The role " + entity.getNombre() + " can not be deleted.");
    } 
}
