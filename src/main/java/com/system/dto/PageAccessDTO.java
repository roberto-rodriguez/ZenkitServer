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
public class PageAccessDTO extends DTO{
    
    private Integer id;

    private String nombre;
    
    private String idPage;

    /**
     * @return the id
     */
    @Override
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idPage
     */
    public String getIdPage() {
        return idPage;
    }

    /**
     * @param idPage the idPage to set
     */
    public void setIdPage(String idPage) {
        this.idPage = idPage;
    }
    
}
