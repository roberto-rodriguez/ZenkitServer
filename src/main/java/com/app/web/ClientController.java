package com.app.web;
 
 import com.app.manager.ClientManager;
import com.system.dto.request.Hash;
import com.system.dto.response.WebResponse;
import com.system.dto.response.WebResponseData;
 import com.system.manager.AbstractManager;
 import com.system.web.AbstractController;
import java.text.ParseException;
import javax.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;
 
 /**
  *
  * @author DevTool
  */
 @RestController
 @RequestMapping(value = "/{pageId}/client")
 public class ClientController extends AbstractController{
     
     @Autowired
     protected ClientManager clientManager;
      
 
     @Override
     public AbstractManager getAbstractManager() {
        return clientManager;
     } 
     
        @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public WebResponse login(@PathVariable("pageId") String pageId,
            @RequestBody Hash data,
            HttpSession session) throws ParseException {

        try { 
            return new WebResponseData(clientManager.login(data));
        } catch (Exception e) {
            e.printStackTrace();
            return WebResponse.forException(e);
        }
    }
 }
