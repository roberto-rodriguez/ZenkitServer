package com.app.dao;

import com.app.dto.CommentDTO;
import com.app.model.Comment;
import com.system.dao.AbstractBaseDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
                .add(Projections.property("flag").as("flag"))
                .add(Projections.property("task").as("task"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(CommentDTO.class));
    }

    @Transactional
    public List<CommentDTO> listByTask(Integer task) {
        Criteria criteria = buildCriteria()
                .add(Restrictions.eq("task", task));

        applyListProjection(criteria);

        return criteria.list();
    }

    protected String getLabelProperty() {
        return "title";
    }
}
