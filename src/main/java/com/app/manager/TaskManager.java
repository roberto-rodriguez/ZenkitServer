package com.app.manager;

import com.app.dao.ClientDAO;
import com.app.dao.CommentDAO;
import com.app.dao.TaskDAO;
import com.app.dto.CommentDTO;
import com.app.dto.SprintDTO;
import com.app.dto.TaskDTO;
import com.app.model.Client;
import com.app.model.Task;
import com.system.dao.AbstractBaseDAO;
import com.system.dto.request.Hash;
import com.system.manager.AbstractManager;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DevTool
 */
@Service
@Transactional
public class TaskManager extends AbstractManager<Task, TaskDTO> {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public AbstractBaseDAO dao() {
        return taskDAO;
    }

    @Override
    protected Task create(Hash data) throws Exception {
        return new Task();
    }

    @Override
    protected void update(Task entity, Hash data) {
        Integer clientId = data.getInteger("assigneeId");
        Client assignee = clientDAO.findById(clientId);
        entity.setAssignee(assignee);

        entity.setTitle(data.getString("title"));
        entity.setDescription(data.getString("description"));

        entity.setStatus(data.getInteger("status"));
        entity.setFlag(data.getInteger("flag"));
        entity.setCreationDate(data.getDate("creationDate"));

        Integer estimatedHours = data.getInteger("estimatedHours");
        //Esto se va a setear con comments
//        Integer loggedHours = data.getInteger("loggedHours");
//        Integer completed = (loggedHours * 100) / estimatedHours;
//         entity.setLoggedHours(loggedHours);
//        entity.setCompleted(completed);
        entity.setEstimatedHours(estimatedHours);

        entity.setSprint(data.getInteger("sprint"));
    }

    protected void afterCreate(Task entity, Hash data) throws Exception {
        entity.setName("T-" + StringUtils.leftPad(entity.getId() + "", 3, "0"));
        saveOrUpdate(entity);
    }

    protected void completeLoad(TaskDTO task) {
        List<CommentDTO> comments = commentDAO.listByTask(task.getId());
        task.setComments(comments);
    }

}
