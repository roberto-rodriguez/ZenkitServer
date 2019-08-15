package com.app.dao;

import com.app.dto.ClientDTO;
import com.app.model.Client;
import com.system.dao.AbstractBaseDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DevTool
 */
@Repository
public class ClientDAO extends AbstractBaseDAO<Client, ClientDTO> {

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("creationDate").as("creationDate"))
                .add(Projections.property("username").as("username"))
                .add(Projections.property("passw").as("passw"))
                .add(Projections.property("active").as("active"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ClientDTO.class));
    }

    public ClientDTO login(String username, String passw) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"));

        Criteria criteria = getCriteria()
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("passw", passw))
                .add(Restrictions.eq("active", true))
                .setMaxResults(1);

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(ClientDTO.class));

        return (ClientDTO) criteria.uniqueResult();
    }
}
