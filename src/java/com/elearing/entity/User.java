package com.elearing.entity;
// Generated Jun 27, 2015 4:08:38 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userId;
     private InstitutionInfo institutionInfo;
     private UserRole userRole;
     private String userName;
     private String userPass;
     private String userEmail;
     private String userPhone;
     private Date date;
     private String firstName;
     private String lastName;
     private Set userImages = new HashSet(0);
     private Set institutionInfos = new HashSet(0);
     private Set examResults = new HashSet(0);

    public User() {
    }

	
    public User(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }
    public User(InstitutionInfo institutionInfo, UserRole userRole, String userName, String userPass, String userEmail, String userPhone, Date date, String firstName, String lastName, Set userImages, Set institutionInfos, Set examResults) {
       this.institutionInfo = institutionInfo;
       this.userRole = userRole;
       this.userName = userName;
       this.userPass = userPass;
       this.userEmail = userEmail;
       this.userPhone = userPhone;
       this.date = date;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userImages = userImages;
       this.institutionInfos = institutionInfos;
       this.examResults = examResults;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public InstitutionInfo getInstitutionInfo() {
        return this.institutionInfo;
    }
    
    public void setInstitutionInfo(InstitutionInfo institutionInfo) {
        this.institutionInfo = institutionInfo;
    }
    public UserRole getUserRole() {
        return this.userRole;
    }
    
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return this.userPass;
    }
    
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Set getUserImages() {
        return this.userImages;
    }
    
    public void setUserImages(Set userImages) {
        this.userImages = userImages;
    }
    public Set getInstitutionInfos() {
        return this.institutionInfos;
    }
    
    public void setInstitutionInfos(Set institutionInfos) {
        this.institutionInfos = institutionInfos;
    }
    public Set getExamResults() {
        return this.examResults;
    }
    
    public void setExamResults(Set examResults) {
        this.examResults = examResults;
    }




}


