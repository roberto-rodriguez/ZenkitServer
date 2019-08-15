/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.dto;

import java.io.Serializable;

/**
 *
 * @author roberto.rodriguez
 */
public class Nom implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nombre;

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
    
        public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setIdx(String id) {
        this.id = Integer.parseInt(id);
    }
}
