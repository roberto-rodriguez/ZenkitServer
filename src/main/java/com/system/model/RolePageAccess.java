/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.model;

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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author Alejo
 */
@Entity
@Table(name = "system_role_page_access")
@XmlRootElement
public class RolePageAccess extends BaseEntity{
    
    public RolePageAccess(){}
    
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_system_role_page_access", sequenceName = "system_role_page_access_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_system_role_page_access")
    @Generated(GenerationTime.INSERT)
    
    private Integer id;
    
    private Boolean creat;
    
    private Boolean upd;
    
    private Boolean delt;
    
    @ManyToOne
    @JoinColumn(name = "rol")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "page_access")
    private PageAccess pageAccess;

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
     * @return the creat
     */
    public Boolean getCreat() {
        return creat;
    }

    /**
     * @param creat the creat to set
     */
    public void setCreat(Boolean creat) {
        this.creat = creat;
    }

    /**
     * @return the upd
     */
    public Boolean getUpd() {
        return upd;
    }

    /**
     * @param upd the upd to set
     */
    public void setUpd(Boolean upd) {
        this.upd = upd;
    }

    /**
     * @return the delt
     */
    public Boolean getDelt() {
        return delt;
    }

    /**
     * @param delt the delt to set
     */
    public void setDelt(Boolean delt) {
        this.delt = delt;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the pageAccess
     */
    public PageAccess getPageAccess() {
        return pageAccess;
    }

    /**
     * @param pageAccess the pageAccess to set
     */
    public void setPageAccess(PageAccess pageAccess) {
        this.pageAccess = pageAccess;
    }
    
}
