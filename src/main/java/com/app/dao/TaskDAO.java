package com.app.dao;

import com.app.dto.TaskDTO;
import com.app.model.Task;
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
public class TaskDAO extends AbstractBaseDAO<Task, TaskDTO> {

    @Override
    public Criteria buildCriteria() {
        return getCriteria().createAlias("assignee", "assignee");
    }

    @Override
    public void applyListProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("title").as("title"))
                .add(Projections.property("status").as("status"))
                .add(Projections.property("assignee.name").as("assignee"))
                .add(Projections.property("assignee.id").as("assigneeId"))
                .add(Projections.property("flag").as("flag"))
                .add(Projections.property("estimatedHours").as("estimatedHours"))
                .add(Projections.property("loggedHours").as("loggedHours"))
                .add(Projections.property("completed").as("completed"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(TaskDTO.class));
    }

    @Override
    public void applyLoadProjection(Criteria criteria) {
        ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("id").as("id"))
                .add(Projections.property("name").as("name"))
                .add(Projections.property("title").as("title"))
                .add(Projections.property("status").as("status"))
                .add(Projections.property("assignee.name").as("assignee"))
                .add(Projections.property("assignee.id").as("assigneeId"))
                .add(Projections.property("flag").as("flag"))
                .add(Projections.property("description").as("description"))
                .add(Projections.property("creationDate").as("creationDate"))
                .add(Projections.property("estimatedHours").as("estimatedHours"))
                .add(Projections.property("loggedHours").as("loggedHours"))
                .add(Projections.property("sprint").as("sprint"))
                .add(Projections.property("completed").as("completed"));

        criteria.setProjection(projectionList)
                .setResultTransformer(Transformers.aliasToBean(TaskDTO.class));
    }

    @Transactional
    public List<TaskDTO> listBySprint(Integer sprintId) {
        Criteria criteria = buildCriteria()
                .add(Restrictions.eq("sprint", sprintId));

        applyListProjection(criteria);

        return criteria.list();
    }

    public void updateFlag(Integer taskId, Integer flag) {
        query("UPDATE task SET flag = " + flag + " WHERE id = " + taskId);
    }
    
     
}
