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
@Table(name = "system_page_access")
@XmlRootElement
public class PageAccess extends BaseEntity{
    
    public PageAccess(){}
   
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_system_page_access", sequenceName = "system_page_access_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_system_page_access")
    @Generated(GenerationTime.INSERT)
    private Integer id;
    
    private String nombre;

    private String idPage;

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
