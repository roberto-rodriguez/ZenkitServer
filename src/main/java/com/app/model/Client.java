package com.app.model;

import com.system.model.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;

/**
 *
 * @author Dev Tool
 */
@Entity
@Table(name = "client")
@XmlRootElement
public class Client extends BaseEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "client_id_sequence", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_sequence")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "token")
    private String token;

    @Type(type = "timestamp")
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "username")
    private String username;

    @Column(name = "passw")
    private String passw;

    @Column(name = "active")
    private Boolean active;

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passw
     */
    public String getPassw() {
        return passw;
    }

    /**
     * @param passw the passw to set
     */
    public void setPassw(String passw) {
        this.passw = passw;
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
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

}
