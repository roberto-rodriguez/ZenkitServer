/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dao;

import com.system.dto.Nom;
import com.system.model.BaseEntity;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roberto.rodriguez
 */
@Repository
public class NomDAO extends BaseDAO<BaseEntity> {

    public void save(String entity, String value) {
        String q = "INSERT INTO " + entity + " (nombre) VALUES (:val)";
        SQLQuery query = getSession().createSQLQuery(q);
        query.setParameter("val", value);

        query.executeUpdate();
    }

    public void update(String entity, Integer id, String value) {
        String q = "UPDATE " + entity + " SET nombre = :val WHERE id = :id";
        SQLQuery query = getSession().createSQLQuery(q);
        query.setParameter("val", value);
        query.setParameter("id", id);

        query.executeUpdate();
    }
    
    public <T> T getById(Integer id, String entity, Class clazz){  
        String q = "SELECT id, nombre FROM " + entity + " WHERE id = " + id;
        SQLQuery query = getSession().createSQLQuery(q);
         
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        
        return (T)query.uniqueResult();
    }

    public Map list(String entity, Integer page, Integer start, Integer limit) {
        Map result = new HashMap();

        String q = "SELECT * FROM " + entity + " OFFSET :start LIMIT :limit";
        SQLQuery query = getSession().createSQLQuery(q);

        query.setParameter("start", start);
        query.setParameter("limit", limit);

        query.setResultTransformer(Transformers.aliasToBean(Nom.class));

        result.put("List", query.list());

        if (limit != 0) {
            result.put("page", page);

            String totalQ = "select count(*) from " + entity;
            SQLQuery totalQuery = getSession().createSQLQuery(totalQ);
            BigInteger total = (BigInteger) totalQuery.uniqueResult();

            if (total != null) {
                result.put("TotalCount", total.longValue());
            }
        }

        return result;
    }
    
    public Map nomenclator(String entity) {
        Map result = new HashMap();

        String q = "SELECT * FROM " + entity;
        SQLQuery query = getSession().createSQLQuery(q);       

        query.setResultTransformer(Transformers.aliasToBean(Nom.class));

        result.put("data", query.list());

        return result;
    }
}
