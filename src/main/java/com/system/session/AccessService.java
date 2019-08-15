/*
 
 */
package com.system.session;
 

import com.system.dao.PageAccessDAO;
import com.system.dao.RolePageAccessDAO;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sistemas
 */
@Service
@Transactional
public class AccessService {
        
    @Autowired
    private RolePageAccessDAO rolePageAccessDAO;
    @Autowired
    private PageAccessDAO pageAccessDAO;

    public Boolean checkAccess(Principal principal, String pageId) {
        return principal != null && pageAccess(principal, pageId);
    }

    private boolean pageAccess(Principal principal, String pageId) {
//        if (principal.getAccessAll()) {
//            return true;
//        } else {
            return principal.getPageAccess().contains(pageId);
//        }
    }
    
    public Boolean checkAuth(Principal principal, String pageId, String operation) {
        Integer idPageAccess = pageAccessDAO.getIdByPageId(pageId);        
        Integer idRole = principal.getRoleId();
       
//        if (principal.getAccessAll()) {//implementar permisos  determinadas funcionalidades
//            return true;
//        } else {            
            return rolePageAccessDAO.getPermission(idRole, idPageAccess, operation);
//        }
    }
}
