/*
 ** File: WebResponse.java
 **
 ** Date Created: December 2016
 **
 ** Copyright @ 2016-2018 Roberto Rodriguez.
 ** Email: robertoSoftwareEngineer@gmail.com
 **
 ** All rights reserved. No part of this software may be 
 ** reproduced, transmitted, transcribed, stored in a retrieval 
 ** system, or translated into any language or computer language, 
 ** in any form or by any means, electronic, mechanical, magnetic, 
 ** optical, chemical, manual or otherwise, without the prior 
 ** written permission of Roberto Rodriguez.
 **
 */
package com.system.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author rrodriguez
 */
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Component
public class Principal implements Serializable {

    private static String PRINCIPAL = "PRINCIPAL";
    private static String TOKEN = "TOKEN";

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer roleId;
    private String role;
    private String token;
    private Integer entityId;
    private String entity;

    private List<String> pageAccess;

    public Principal() {
        pageAccess = new ArrayList<>();
    }

    /**
     * @return the PRINCIPAL
     */
    public static String getPRINCIPAL() {
        return PRINCIPAL;
    }

    /**
     * @param aPRINCIPAL the PRINCIPAL to set
     */
    public static void setPRINCIPAL(String aPRINCIPAL) {
        PRINCIPAL = aPRINCIPAL;
    }

    /**
     * @return the TOKEN
     */
    public static String getTOKEN() {
        return TOKEN;
    }

    /**
     * @param aTOKEN the TOKEN to set
     */
    public static void setTOKEN(String aTOKEN) {
        TOKEN = aTOKEN;
    }

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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    /**
     * @return the entityId
     */
    public Integer getEntityId() {
        return entityId;
    }

    /**
     * @param entityId the entityId to set
     */
    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    /**
     * @return the entity
     */
    public String getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     * @return the pageAccess
     */
    public List<String> getPageAccess() {
        return pageAccess;
    }

    /**
     * @param pageAccess the pageAccess to set
     */
    public void setPageAccess(List<String> pageAccess) {
        this.pageAccess = pageAccess;
    }

}
