package com.elearing.entity;
// Generated Jun 27, 2015 4:08:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * InstitutionInfo generated by hbm2java
 */
public class InstitutionInfo  implements java.io.Serializable {


     private Integer insId;
     private User user;
     private String insName;
     private String insType;
     private String insAddress;
     private String insDistrict;
     private Set users = new HashSet(0);

    public InstitutionInfo() {
    }

	
    public InstitutionInfo(User user) {
        this.user = user;
    }
    public InstitutionInfo(User user, String insName, String insType, String insAddress, String insDistrict, Set users) {
       this.user = user;
       this.insName = insName;
       this.insType = insType;
       this.insAddress = insAddress;
       this.insDistrict = insDistrict;
       this.users = users;
    }
   
    public Integer getInsId() {
        return this.insId;
    }
    
    public void setInsId(Integer insId) {
        this.insId = insId;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getInsName() {
        return this.insName;
    }
    
    public void setInsName(String insName) {
        this.insName = insName;
    }
    public String getInsType() {
        return this.insType;
    }
    
    public void setInsType(String insType) {
        this.insType = insType;
    }
    public String getInsAddress() {
        return this.insAddress;
    }
    
    public void setInsAddress(String insAddress) {
        this.insAddress = insAddress;
    }
    public String getInsDistrict() {
        return this.insDistrict;
    }
    
    public void setInsDistrict(String insDistrict) {
        this.insDistrict = insDistrict;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }




}


