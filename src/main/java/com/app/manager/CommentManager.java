package com.app.manager;

import com.app.dao.CommentDAO;
import com.app.dto.CommentDTO;
import com.app.model.Comment;
import com.system.dao.AbstractBaseDAO;
import com.system.dto.request.Hash;
import com.system.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DevTool
 */
@Service
@Transactional
public class CommentManager extends AbstractManager<Comment, CommentDTO> {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public AbstractBaseDAO dao() {
        return commentDAO;
    }

    @Override
    protected Comment create(Hash data) throws Exception {
        return new Comment();
    }

    @Override
    protected void update(Comment entity, Hash data) {
        entity.setTitle(data.getString("title"));
        entity.setDescription(data.getString("description"));
        entity.setCreationDate(data.getDate("creationDate"));
        entity.setClient(data.getInteger("client"));
        entity.setTask(data.getInteger("task"));

    }
}
