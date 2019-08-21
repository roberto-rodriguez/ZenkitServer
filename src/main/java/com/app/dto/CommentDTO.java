package com.app.dto;

import com.system.dto.DTO;
import java.util.Date;

/**
 *
 * @author DevTool
 */
public class CommentDTO extends DTO {

    private Integer id;
    private String title;
    private String description;
    private Date creationDate;
    private Integer client;
    private Integer task;
    private Integer flag;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the client
     */
    public Integer getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Integer client) {
        this.client = client;
    }

    /**
     * @return the task
     */
    public Integer getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(Integer task) {
        this.task = task;
    }

    /**
     * @return the flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    
}
