/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.manager;

import com.system.dao.AbstractBaseDAO;
import com.system.dao.PageAccessDAO;
import com.system.dao.RolePageAccessDAO;
import com.system.dto.PageAccessDTO;
import com.system.dto.request.Hash;
import com.system.dto.response.WebResponseData;
import com.system.model.PageAccess;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo
 */
@Service
@Transactional
public class PageAccessManager extends AbstractManager<PageAccess, PageAccessDTO> {

    @Autowired
    private PageAccessDAO pageAccessDAO;

    @Autowired
    private RolePageAccessDAO rolePageAccesDAO;

    @Override
    public AbstractBaseDAO dao() {
        return pageAccessDAO;
    }

    @Override
    protected PageAccess create(Hash data) throws Exception {
        return new PageAccess();
    }

    @Override
    protected void update(PageAccess entity, Hash data) {
        entity.setNombre(data.getString("nombre"));
        entity.setIdPage(data.getString("idPage"));
    }

    @Override
    public WebResponseData del(PageAccess entity) throws Exception {

        if (!rolePageAccesDAO.existPageAccess(entity.getId())) {
            dao().delete(entity);
            return new WebResponseData();
        }
        return new WebResponseData(500, "The page " + entity.getNombre() + " can not be deleted.");
    }

    public void deleteRecursivelly(String pageId) {
         rolePageAccesDAO.deleteByPageId(pageId);
         pageAccessDAO.deleteByPageId(pageId);
    }
}
