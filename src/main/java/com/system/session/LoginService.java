/*

 */
package com.system.session;
  
import com.system.dao.RolePageAccessDAO;
import com.system.dao.UserDAO;
import com.system.dto.UserDTO;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
@Transactional
public class LoginService {

    @Autowired
    private UserDAO userDAO; 
    
    @Autowired
    private RolePageAccessDAO rolePageAccessDAO;

    public Principal login(String username, String password) throws Exception { 
        Principal principal = userDAO.getPrincipal(username,password);
        
        if (principal != null) {            
            if (!userDAO.getActive(username, password)) {
                 throw new RuntimeException("Su usuario se encuentra desabilitado, consulte al Administrador");
            }
            List<String> pageAccess = rolePageAccessDAO.getPageAccessByRole(principal.getRoleId());
            
            principal.setPageAccess(pageAccess);//            
            principal.setToken(UUID.randomUUID().toString());
        }

        return principal;
    }

}
