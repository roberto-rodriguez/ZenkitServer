/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dao;

import com.system.dto.PageAccessDTO;
import com.system.dto.request.Hash;
import com.system.model.PageAccess;
import com.system.model.RolePageAccess;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo
 */
@Repository
public class PageAccessDAO extends AbstractBaseDAO<PageAccess, PageAccessDTO> {

    public void addOrder(Criteria criteria) {
        criteria.addOrder(Order.asc("nombre"));
    }

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("nombre").as("nombre"))
                .add(Projections.property("idPage").as("idPage"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(PageAccessDTO.class));
    }

    public Integer getIdByPageId(String idPage) {
        return (Integer) getCriteria()
                .add(Restrictions.eq("idPage", idPage))
                .setProjection(Projections.property("id"))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Transactional
    public void deleteByPageId(String pageId) {
        PageAccess page = (PageAccess) getCriteria()
                .add(Restrictions.like("pageAccess.idPage", pageId))
                .setMaxResults(1)
                .uniqueResult();

        delete(page);
    }
}
