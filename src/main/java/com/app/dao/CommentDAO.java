package com.app.dao;

import com.app.dto.CommentDTO;
import com.app.model.Comment;
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
public class CommentDAO extends AbstractBaseDAO<Comment, CommentDTO> {

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("title").as("title"))
                .add(Projections.property("description").as("description"))
                .add(Projections.property("creationDate").as("creationDate"))
                .add(Projections.property("client").as("client"))
                .add(Projections.property("task").as("task"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(CommentDTO.class));
    }
}
