package com.app.dto;

import com.system.dto.DTO;
import java.util.List;

/**
 *
 * @author DevTool
 */
public class SprintDTO extends DTO {

    private Integer id;
    private String name;
    private Boolean active;
    private String startDate;
    private String endDate;
    private Integer hours;
    private Integer loggedHours;
    private Integer completed;
    private List<TaskDTO> tasks;

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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the hours
     */
    public Integer getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(Integer hours) {
        this.hours = hours;
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
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the tasks
     */
    public List<TaskDTO> getTasks() {
        return tasks;
    }

    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

}
