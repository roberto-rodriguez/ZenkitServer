/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dto;



/**
 *
 * @author Alejo
 */
public class RolePageAccessDTO extends DTO{
    
    private Integer id;
    private Boolean creat;    
    private Boolean upd;    
    private Boolean delt;
    private String role;
    private Integer roleId;
    private String pageAccess;
    private Integer pageAccessId;

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
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the pageAccess
     */
    public String getPageAccess() {
        return pageAccess;
    }

    /**
     * @param pageAccess the pageAccess to set
     */
    public void setPageAccess(String pageAccess) {
        this.pageAccess = pageAccess;
    }

    /**
     * @return the pageAccessId
     */
    public Integer getPageAccessId() {
        return pageAccessId;
    }

    /**
     * @param pageAccessId the pageAccessId to set
     */
    public void setPageAccessId(Integer pageAccessId) {
        this.pageAccessId = pageAccessId;
    }
    
    
}
