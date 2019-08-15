package com.app.dto;
 
 import com.system.dto.DTO;
 import java.util.Date;
 
 /**
  *
  * @author DevTool
  */
 public class LogDTO extends DTO{
     
     private Integer id;
      private String name;
     private String description;
     private Date creationDate;
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
