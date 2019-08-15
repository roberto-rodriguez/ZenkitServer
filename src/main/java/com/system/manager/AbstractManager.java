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
package com.system.manager;

import com.system.dao.AbstractBaseDAO;
import com.system.dto.Nom;
import com.system.dto.request.Hash;
import com.system.dto.request.ListRequestDTO;
import com.system.dto.response.WebResponseData;
import com.system.model.BaseEntity;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author rrodriguez
 */
public abstract class AbstractManager<T extends BaseEntity, D> extends BaseManager {

    public Map pageList(ListRequestDTO request) {
        return dao().pageList(request);
    }

    public List<Nom> nomenclatorList(List<Criterion> expressions) {
        return dao().nomenclatorList(expressions);
    }

    public D load(List<Criterion> expressions) {
        D entity = (D) dao().load(expressions);
        completeLoad(entity);
        return entity;
    }

    public D load(Integer id) {
        D entity = (D) dao().load(id);
        completeLoad(entity);
        return entity;
    }

    protected void completeLoad(D dto) {
        // override this method if need add more things to the DTO
    }

    public abstract AbstractBaseDAO dao();

    protected WebResponseData del(T entity) throws Exception {
        dao().delete(entity);
        return new WebResponseData();
    }

    public WebResponseData delete(Hash data) throws Exception {
        T entity;
        Integer id = data.getInt("id");
        entity = (T) dao().findById(id);
        return del(entity);
    }

    public T save(Hash data) throws Exception {
        T entity;
        if (data == null) {
            data = new Hash();
        }

        Boolean creating = data.getId() == null || data.getId() == 0;

        if (creating) {
            entity = create(data);
        } else {
            Integer id = data.getId();
            entity = (T) dao().findById(id);
        }

        if (entity != null) {
            update(entity, data);
        }

        if (validate(entity, data)) {
            entity = (T) dao().saveOrUpdate(entity);

            if (creating) {
                afterCreate(entity, data);
            }

            afterSave(entity, data);
        }

        return entity;
    }

    protected T create(Hash data) throws Exception {
        return null;
    }

    protected void update(T entity, Hash data) throws Exception {
    }

    public T findById(Integer id) {
        return (T) dao().findById(id);
    }

    public T saveOrUpdate(T t) {
        return (T) dao().saveOrUpdate(t);
    }

    public Object getPropertyValueFromEntityId(Integer entityId, String propertyName) {
        return dao().getPropertyValueFromEntityId(entityId, propertyName);
    }

    protected void afterSave(T entity, Hash data) throws Exception {
    } //Redefine if need to do something after save

    protected void afterCreate(T entity, Hash data) throws Exception {
    } //Redefine if need to do something after save

    public boolean validate(T entity, Hash data) {
        return true;
    }
}
