package com.app.dao;

import com.app.dto.SprintDTO;
import com.app.model.Sprint;
import com.system.dao.AbstractBaseDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DevTool
 */
@Repository
public class SprintDAO extends AbstractBaseDAO<Sprint, SprintDTO> {

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("active").as("active"))
                .add(Projections.property("startDate").as("startDate"))
                .add(Projections.property("endDate").as("endDate"))
                .add(Projections.property("hours").as("hours"))
                .add(Projections.property("loggedHours").as("loggedHours"))
                .add(Projections.property("completed").as("completed"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(SprintDTO.class));
    }
}
