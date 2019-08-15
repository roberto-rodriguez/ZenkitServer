package com.app.dto;

import com.system.dto.DTO;
import java.util.Date;

/**
 *
 * @author DevTool
 */
public class TaskDTO extends DTO {

    private Integer id;
    private String name;
    private String title;
    private String description;
    private Integer assigneeId;
    private String assignee;
    private Integer status;
    private Integer flag;
    private Date creationDate;
    private Integer estimatedHours;
    private Integer loggedHours;
    private Integer completed;
    private Integer sprint;

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
     * @return the assigneeId
     */
    public Integer getAssigneeId() {
        return assigneeId;
    }

    /**
     * @param assigneeId the assigneeId to set
     */
    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    /**
     * @return the assignee
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @param assignee the assignee to set
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * @return the loggedHours
     */
    public Integer getLoggedHours() {
        return loggedHours;
    }

    /**
     * @param loggedHours the loggedHours to set
     */
    public void setLoggedHours(Integer loggedHours) {
        this.loggedHours = loggedHours;
    }

    /**
     * @return the completed
     */
    public Integer getCompleted() {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    /**
     * @return the sprint
     */
    public Integer getSprint() {
        return sprint;
    }

    /**
     * @param sprint the sprint to set
     */
    public void setSprint(Integer sprint) {
        this.sprint = sprint;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the estimatedHours
     */
    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    /**
     * @param estimatedHours the estimatedHours to set
     */
    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

}
