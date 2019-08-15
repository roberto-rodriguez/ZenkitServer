package com.app.dto;
 
 import com.system.dto.DTO;
 import java.util.Date;
 
 /**
  *
  * @author DevTool
  */
 public class ClientDTO extends DTO{
     
     private Integer id;
      private String name;
     private Date creationDate;
     private String username;
     private String passw;
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

     
 }
