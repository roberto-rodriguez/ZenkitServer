package com.app.manager;

import com.app.dao.SprintDAO;
import com.app.dao.TaskDAO;
import com.app.dto.SprintDTO;
import com.app.dto.TaskDTO;
import com.app.model.Sprint;
import com.system.dao.AbstractBaseDAO;
import com.system.dto.request.Hash;
import com.system.manager.AbstractManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DevTool
 */
@Service
@Transactional
public class SprintManager extends AbstractManager<Sprint, SprintDTO> {
    
    @Autowired
    private SprintDAO sprintDAO;
    
    @Autowired
    private TaskDAO taskDAO;
    
    @Override
    public AbstractBaseDAO dao() {
        return sprintDAO;
    }
    
    @Override
    protected Sprint create(Hash data) throws Exception {
        return new Sprint();
    }
    
    @Override
    protected void update(Sprint entity, Hash data) {
        entity.setName(data.getString("name"));
        
        Boolean active = data.getBoolean("active");
        
        if (active) {
            String query = "UPDATE sprint SET active = false";
            
            if (entity.getId() != null) {
                query += " WHERE id != " + entity.getId();
            }
            sprintDAO.query(query);
        }
        
        entity.setActive(active);
        entity.setStartDate(data.getString("startDate"));
        entity.setEndDate(data.getString("endDate"));
        entity.setHours(data.getInteger("hours"));
        entity.setLoggedHours(data.getInteger("loggedHours"));
        entity.setCompleted(data.getInteger("completed"));
    }
    
    protected void completeLoad(SprintDTO sprint) {
        List<TaskDTO> taskList = taskDAO.listBySprint(sprint.getId());
        sprint.setTasks(taskList);
    }
}
