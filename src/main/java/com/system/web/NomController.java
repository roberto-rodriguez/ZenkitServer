/*
 ** File: WebResponse.java
 **
 ** Date Created: December 2016
 **
 ** Copyright @ 2016-2018 Roberto Rodriguez.
 ** Email: robertoSoftwareEngineer@gmail.com
 **
 ** All rights reserved. No part of this software may be 
 ** reproduced, transmitted, transcribed, stored in a retrieval 
 ** system, or translated into any language or computer language, 
 ** in any form or by any means, electronic, mechanical, magnetic, 
 ** optical, chemical, manual or otherwise, without the prior 
 ** written permission of Roberto Rodriguez.
 **
 */
package com.system.web;

import com.system.dto.request.Hash;
import com.system.dto.response.WebResponse;
import com.system.enums.NomType;
import com.system.manager.NomManager;
import com.system.util.RequestParser;
import java.text.ParseException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@RequestMapping(value = "/{pageId}/nom", method = RequestMethod.GET)
public class NomController {

    @Autowired
    private NomManager nomManager;

    @RequestMapping(value = "/save/{entity}", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    WebResponse save(
            @PathVariable("pageId") String pageId,
            @PathVariable("entity") String entity,
            @RequestBody Hash request,
            HttpSession session) throws ParseException {

        validateEntity(entity);

        System.out.println("Request");
        System.out.println(request);

        Hash data = RequestParser.parseRequestMap(request);

        System.out.println("Data");
        System.out.println(data);

        nomManager.save("nom_" + entity, data);

        return new WebResponse();
    }
    
    @RequestMapping(value = "/nomenclator/{entity}")
    public @ResponseBody
    Map nomenclator(
            @PathVariable("pageId") String pageId,
            @PathVariable("entity") String entity,
            HttpSession session) throws Exception {        
            
        validateEntity(entity);
        return nomManager.nomenclator("nom_" + entity);
    }

    @RequestMapping(value = "/list/{entity}")
    public @ResponseBody
    Map list(
            @PathVariable("pageId") String pageId,
            @PathVariable("entity") String entity,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "0") Integer limit,
            HttpSession session) {

        validateEntity(entity);

        return nomManager.list("nom_" + entity, page, start, limit);
    }
    
   private void validateEntity(String entity) {
        if (entity == null || !EnumUtils.isValidEnum(NomType.class, entity.toUpperCase())
                || entity.equals("tx")) {
            throw new IllegalArgumentException("La entidad " + entity + " no es valida.");
        }
    }
}
