package com.elearing.entity;
// Generated Jun 27, 2015 4:08:38 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Exam generated by hbm2java
 */
public class Exam  implements java.io.Serializable {


     private Integer examId;
     private Integer totalQues;
     private String examName;
     private Integer examTime;
     private String examStatus;
     private Integer passMarks;
     private Set examQuesLinks = new HashSet(0);
     private Set examResults = new HashSet(0);

    public Exam() {
    }

    public Exam(Integer totalQues, String examName, Integer examTime, String examStatus, Integer passMarks, Set examQuesLinks, Set examResults) {
       this.totalQues = totalQues;
       this.examName = examName;
       this.examTime = examTime;
       this.examStatus = examStatus;
       this.passMarks = passMarks;
       this.examQuesLinks = examQuesLinks;
       this.examResults = examResults;
    }
   
    public Integer getExamId() {
        return this.examId;
    }
    
    public void setExamId(Integer examId) {
        this.examId = examId;
    }
    public Integer getTotalQues() {
        return this.totalQues;
    }
    
    public void setTotalQues(Integer totalQues) {
        this.totalQues = totalQues;
    }
    public String getExamName() {
        return this.examName;
    }
    
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public Integer getExamTime() {
        return this.examTime;
    }
    
    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }
    public String getExamStatus() {
        return this.examStatus;
    }
    
    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }
    public Integer getPassMarks() {
        return this.passMarks;
    }
    
    public void setPassMarks(Integer passMarks) {
        this.passMarks = passMarks;
    }
    public Set getExamQuesLinks() {
        return this.examQuesLinks;
    }
    
    public void setExamQuesLinks(Set examQuesLinks) {
        this.examQuesLinks = examQuesLinks;
    }
    public Set getExamResults() {
        return this.examResults;
    }
    
    public void setExamResults(Set examResults) {
        this.examResults = examResults;
    }




}


