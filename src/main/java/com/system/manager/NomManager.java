/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.manager;

import com.system.dao.NomDAO;
import com.system.dto.Nom;
import com.system.dto.request.Hash;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roberto.rodriguez
 */
@Service
@Transactional
public class NomManager {

    @Autowired
    private NomDAO nomDAO;

    public void save(String entity, Hash request) {
        Integer id = request.getId();
        String name = request.getString("nombre");

        if (id == null) {
            nomDAO.save(entity, name);
        } else {
            nomDAO.update(entity, id, name);
        } 
    }

    public Map list(String entity, Integer page, Integer start, Integer limit) {
        return nomDAO.list(entity, page, start, limit);
    }
    
    public Map nomenclator(String entity) {
        return nomDAO.nomenclator(entity);
    }

}
