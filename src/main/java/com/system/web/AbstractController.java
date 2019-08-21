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

import com.system.dao.AbstractBaseDAO;
import com.system.dto.request.Hash;
import com.system.dto.request.ListRequestDTO;
import com.system.dto.Nom;
import com.system.manager.AbstractManager;
import com.system.util.RequestParser;
import com.system.dto.response.WebResponse;
import com.system.dto.response.WebResponseData;
import com.system.dto.response.WebResponseDataList;
import com.system.util.OrderParser;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

@RestController
public abstract class AbstractController<D> {

//    @Autowired
//    private AccessService accessService;
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public Map report(
            @PathVariable("pageId") String pageId,
            @RequestParam(value = "report", defaultValue = "") String report, //Type of report
            @RequestParam(value = "params", defaultValue = "") String params,
            HttpSession session) throws Exception {

        System.out.println("FrontAMS / report = " + report);
        System.out.println("FrontAMS / params = " + params);
        List<Criterion> data = RequestParser.parseParamsToExpressions(params);

        AbstractManager manager = getAbstractManager();

        if (manager != null) {
            return manager.pageList(new ListRequestDTO(0, 0, 0, report, data));
        } else {
            //For entities that just use list, dont need Manager, go straight to DAO
            return dao().pageList(new ListRequestDTO(0, 0, 0, report, data));
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map list(
            @PathVariable("pageId") String pageId,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "limit", defaultValue = "0") Integer limit,
            @RequestParam(value = "report", defaultValue = "") String report,
            @RequestParam(value = "params", defaultValue = "") String params,
            @RequestParam(value = "order", defaultValue = "") String order,
            HttpSession session) throws Exception {

        System.out.println("List:: params = " + params);

        List<Criterion> data = RequestParser.parseParamsToExpressions(params);
        List<Order> orders = OrderParser.parseOrders(order);

        AbstractManager manager = getAbstractManager();

        ListRequestDTO request = new ListRequestDTO(page, start, limit, report, data, orders);

        if (manager != null) {
            return manager.pageList(request);
        } else {
            //For entities that just use list, dont need Manager, go straight to DAO
            return dao().pageList(request);
        }
    }

    //This is for the App
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    public WebResponse persist(@PathVariable("pageId") String pageId,
            @RequestBody Hash data,
            HttpSession session) throws ParseException {

        try {
            return new WebResponseData(getAbstractManager().save(data));
        } catch (Exception e) {
            e.printStackTrace();
            return WebResponse.forException(e);
        }
    }

    //This is for the AMS 
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public WebResponse save(@PathVariable("pageId") String pageId,
            @RequestBody Hash map,
            HttpSession session) throws ParseException {

        try {
            Hash data = RequestParser.parseRequestMap(map);

            return new WebResponseData(getAbstractManager().save(data));
        } catch (Exception e) {
            e.printStackTrace();
            return WebResponse.forException(e);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public WebResponse delete(
            @PathVariable("pageId") String pageId,
            @PathVariable("id") Integer id,
            HttpSession session) throws ParseException, Exception {

        try {
            return getAbstractManager().delete(id);

        } catch (Exception e) {
            e.printStackTrace();
            return WebResponse.forException(e);
        }
    }

    @RequestMapping(value = "/nomenclator", method = RequestMethod.GET)
    public WebResponseDataList nomenclator(
            @PathVariable("pageId") String pageId,
            @RequestParam(value = "params", defaultValue = "") String params,
            HttpSession session) throws Exception {

        System.out.println("nomenclator params = " + params);

        List<Criterion> expressions = RequestParser.parseParamsToExpressions(params);

        AbstractManager manager = getAbstractManager();

        if (manager != null) {
            return new WebResponseDataList<Nom>(manager.nomenclatorList(expressions));
        } else {
            //For entities that just use list, dont need Manager, go straight to DAO
            return new WebResponseDataList<Nom>(dao().nomenclatorList(expressions));
        }

    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public D load(@RequestParam(value = "params", defaultValue = "") String params) {
        List<Criterion> expressions = RequestParser.parseParamsToExpressions(params);
        return (D) getAbstractManager().load(expressions);
    }

    private void checkAccess(HttpSession session, String page, List<Criterion> expressions) throws Exception {

//        Principal principal = (Principal) session.getAttribute(Principal.PRINCIPAL);
//
//        if (!(accessService.checkAccess(principal, page) && checkAuth(principal, expressions))){
//            throw new Exception("Access Denied");
//        }
    }

    public boolean checkAuth(Principal principal, List<Criterion> expressions) {
        return true;
    } //Redefine if need special check access

    public AbstractManager getAbstractManager() {
        return null;
    }

    ;
    
    public AbstractManager getReportManager() {
        return getAbstractManager();
    }

    private AbstractBaseDAO dao() {
        String daoName = getEntityName() + "DAO";
        return (AbstractBaseDAO) ContextLoader.getCurrentWebApplicationContext().getBean(daoName);
    }

    public static void main(String[] args) {
        System.out.println("asdSummary".split("Summary")[0]);
    }

    private String getEntityName() {
        String path = this.getClass().getAnnotation(RequestMapping.class).value()[0];
        return path.substring(path.lastIndexOf("/") + 1);
    }
}
