package com.app.model;

import com.system.model.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;

/**
 *
 * @author Dev Tool
 */
@Entity
@Table(name = "task")
@XmlRootElement
public class Task extends BaseEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "task_id_sequence", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    private Integer id;
    private String name;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "assignee")
    private Client assignee;

    @Column(name = "status")
    private Integer status;

    @Column(name = "flag")
    private Integer flag;

    @Type(type = "timestamp")
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    @Column(name = "logged_hours")
    private Integer loggedHours;

    @Column(name = "completed")
    private Integer completed;

    @Column(name = "sprint")
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
     * @return the assignee
     */
    public Client getAssignee() {
        return assignee;
    }

    /**
     * @param assignee the assignee to set
     */
    public void setAssignee(Client assignee) {
        this.assignee = assignee;
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
