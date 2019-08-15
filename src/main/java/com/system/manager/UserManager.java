/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.manager;
 
import com.system.dao.AbstractBaseDAO;
import com.system.dao.RoleDAO;
import com.system.dao.UserDAO;
import com.system.dto.UserDTO;
import com.system.dto.request.Hash;
import com.system.dto.response.WebResponseData;
import com.system.model.Role;
import com.system.model.User; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo
 */
@Service
@Transactional
public class UserManager extends AbstractManager<User, UserDTO>{

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private RoleDAO roleDAO;
        
    @Override
    public AbstractBaseDAO dao() {
        return userDAO;
    }
    
    @Override
    protected User create(Hash data) throws Exception {
        if (userDAO.exist( data.getString("usuario"))) {
            throw new RuntimeException("There is already an user with that identifier, enter another");
        }
        String entity = "Admin";
        Integer entityId = 0;
        if (data.containsKey("entityId")) {
            entity = data.getString("entity");
            entityId = data.getInt("entityId");
        }
        
        data.put("entity",entity);
        data.put("entityId",entityId);
        User user = new User();  
        return user;
    }

    @Override
    protected void update(User entity, Hash data) { 
        entity.setFirstName(data.getString("firstName"));
        entity.setLastName(data.getString("lastName"));
        entity.setUsername(data.getString("username"));
        entity.setPassw( data.getString("passw"));
        entity.setEmail(data.getString("email"));
        entity.setActive(data.getBoolean("active"));
        entity.setEntityId(data.getInt("entityId"));
        entity.setEntity(data.getString("entity"));
        
        //TODO
//        String agentName = (String )agentDAO.getPropertyValueFromEntityId(data.getInt("agentId"), "legalName");        
//        entity.setAgentName(agentName);
        
        Role role = roleDAO.findById(data.getInt("roleId"));
        entity.setRole(role);        
    }
    
    @Override
    public WebResponseData del(User entity) throws Exception{
      
        if (!entity.getActive()) { 
            dao().delete(entity);
            return new WebResponseData();
        }
        return new WebResponseData(500, "User can not be deleted while is active.");
    }
    
}
