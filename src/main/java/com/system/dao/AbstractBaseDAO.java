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
package com.system.dao;

import com.system.dto.DTO;
import com.system.dto.Nom;
import com.system.dto.request.Hash;
import com.system.dto.request.ListRequestDTO;
import com.system.model.BaseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rrodriguez
 */
public class AbstractBaseDAO<T extends BaseEntity, D> extends BaseDAO<T> {

    public Criteria buildCriteria() {
        return getCriteria();
    }

    @Transactional
    public Map pageList(ListRequestDTO request) {
        Criteria criteria = buildCriteria(request.getExpressions());

        if (request.getStart() != null) {
            criteria.setFirstResult(request.getStart());
        }

        if (request.getLimit() != 0) {
            criteria.setMaxResults(request.getLimit());
        }

        applyListProjection(criteria);

        if (request.getOrders() != null) {
            for (Order order : request.getOrders()) {
                criteria.addOrder(order);
            }
        } else {
            addOrder(criteria);
        }

        Map result = new HashMap();

        result.put("List", criteria.list());

        if (request.includeCount() && request.getLimit() != 0) {
            result.put("page", request.getPage());
            Long total = (Long) buildCriteria(request.getExpressions()).setProjection(Projections.rowCount()).uniqueResult();
            result.put("TotalCount", total);
        }

        return result;
    }

    //The Criteria should already contain the ProjectionList and the transformer DTO class
    @Transactional
    public List<D> list(Criteria criteria, List<Criterion> expressions) {
        return buildCriteriaWithParams(criteria, expressions).list();
    }

    @Transactional
    public List<Nom> nomenclatorList(List<Criterion> expressions) {
        Criteria criteria = buildCriteria(expressions);

        applyNomenclatorProjection(criteria);

        return criteria.list();
    }

    protected Criteria buildCriteria(List<Criterion> expressions) {
        return buildCriteriaWithParams(buildCriteria(), expressions);
    }

    protected Criteria buildCriteriaWithParams(Criteria criteria, List<Criterion> expressions) {
        System.out.println("AbstractBaseDAO:: buildCriteriaWithParams");
        for (Criterion expression : expressions) {
            System.out.println("" + expression.toString());
            criteria.add(expression);
        }

        return criteria;
    }

    @Transactional
    public D load(List<Criterion> expressions) {
        Criteria critera = buildCriteria(expressions);

        applyLoadProjection(critera);

        D dto = (D) critera.setMaxResults(1).uniqueResult();

        return dto;
    }

    @Transactional
    public D load(Integer id) {
        Criteria criteria = buildCriteria().add(Restrictions.eq("id", id));

        applyLoadProjection(criteria);

        D dto = (D) criteria.uniqueResult();

        return dto;
    }

    protected void applyLoadProjection(Criteria criteria) {
        applyListProjection(criteria); // override this method if need different projection
    }

    protected void applyListProjection(Criteria criteria) {
    } // override this method if need different projection

    protected void applyReportProjection(Criteria criteria, String reportType) {
    } // override this method if need different projection

    public void addOrder(Criteria criteria) {
        //Override this if need to add Order to the list
    }

    public Nom getNomenclatorById(Integer id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        applyNomenclatorProjection(criteria);
        return (Nom) criteria.uniqueResult();
    }

    protected void applyNomenclatorProjection(Criteria criteria) {
        criteria.addOrder(Order.asc(getLabelProperty()));
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property(getLabelProperty()).as("name"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(Nom.class));

    }

    protected String getLabelProperty() {
        return "name";
    }

    public Boolean exist(Hash data) {
        String labelProperty = getLabelProperty();
        return (Long) getCriteria()
                .add(Restrictions.eq(labelProperty, labelProperty))
                .setProjection(Projections.rowCount())
                .uniqueResult() > 0;
    }

    public Object getPropertyValueFromEntityId(Integer entityId, String propertyName) {
        return getCriteria().add(Restrictions.eq("id", entityId))
                .setProjection(Projections.property(propertyName))
                .setMaxResults(1)
                .uniqueResult();
    }

}
