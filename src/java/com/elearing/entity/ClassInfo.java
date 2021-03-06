package com.elearing.entity;
// Generated Jun 27, 2015 4:08:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ClassInfo generated by hbm2java
 */
public class ClassInfo  implements java.io.Serializable {


     private Integer classId;
     private String className;
     private Set subjects = new HashSet(0);

    public ClassInfo() {
    }

	
    public ClassInfo(String className) {
        this.className = className;
    }
    public ClassInfo(String className, Set subjects) {
       this.className = className;
       this.subjects = subjects;
    }
   
    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    public Set getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(Set subjects) {
        this.subjects = subjects;
    }




}


