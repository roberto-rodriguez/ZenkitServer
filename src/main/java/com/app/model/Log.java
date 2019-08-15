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
 @Table(name = "log")
 @XmlRootElement
 public class Log extends BaseEntity{ 
 
     @Id
     @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
     @SequenceGenerator(name = "log_id_sequence", sequenceName = "log_id_seq", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_id_sequence")
     private Integer id;
 
 
     @Column(name = "name")
     private String name;
 
     @Column(name="description", columnDefinition="TEXT") 
     private String description;


     @Type(type = "timestamp")
     @Column(name = "creation_date")
     private Date creationDate;


     @Column(name = "client")
     private Integer client;


  
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
      * @return the client
      */ 
     public Integer getClient() {
         return client;
     }
 
     /**
      * @param client the client to set
      */
     public void setClient(Integer client) {
         this.client = client;
     }

 }
