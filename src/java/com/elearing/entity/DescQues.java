package com.elearing.entity;
// Generated Jun 27, 2015 4:08:38 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DescQues generated by hbm2java
 */
public class DescQues  implements java.io.Serializable {


     private Integer descQuesId;
     private SubChapter subChapter;
     private String descQuTitle;
     private String firstQuestion;
     private String firstAnswer;
     private String secondQuestion;
     private String secondAnswer;
     private String thirdQuestion;
     private String thirdAnswer;
     private String fourthQuestion;
     private String fourthAnswer;
     private Date descQuPubTime;
     private String image;
     private Set descQuesMetas = new HashSet(0);

    public DescQues() {
    }

    public DescQues(SubChapter subChapter, String descQuTitle, String firstQuestion, String firstAnswer, String secondQuestion, String secondAnswer, String thirdQuestion, String thirdAnswer, String fourthQuestion, String fourthAnswer, Date descQuPubTime, String image, Set descQuesMetas) {
       this.subChapter = subChapter;
       this.descQuTitle = descQuTitle;
       this.firstQuestion = firstQuestion;
       this.firstAnswer = firstAnswer;
       this.secondQuestion = secondQuestion;
       this.secondAnswer = secondAnswer;
       this.thirdQuestion = thirdQuestion;
       this.thirdAnswer = thirdAnswer;
       this.fourthQuestion = fourthQuestion;
       this.fourthAnswer = fourthAnswer;
       this.descQuPubTime = descQuPubTime;
       this.image = image;
       this.descQuesMetas = descQuesMetas;
    }
   
    public Integer getDescQuesId() {
        return this.descQuesId;
    }
    
    public void setDescQuesId(Integer descQuesId) {
        this.descQuesId = descQuesId;
    }
    public SubChapter getSubChapter() {
        return this.subChapter;
    }
    
    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }
    public String getDescQuTitle() {
        return this.descQuTitle;
    }
    
    public void setDescQuTitle(String descQuTitle) {
        this.descQuTitle = descQuTitle;
    }
    public String getFirstQuestion() {
        return this.firstQuestion;
    }
    
    public void setFirstQuestion(String firstQuestion) {
        this.firstQuestion = firstQuestion;
    }
    public String getFirstAnswer() {
        return this.firstAnswer;
    }
    
    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }
    public String getSecondQuestion() {
        return this.secondQuestion;
    }
    
    public void setSecondQuestion(String secondQuestion) {
        this.secondQuestion = secondQuestion;
    }
    public String getSecondAnswer() {
        return this.secondAnswer;
    }
    
    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }
    public String getThirdQuestion() {
        return this.thirdQuestion;
    }
    
    public void setThirdQuestion(String thirdQuestion) {
        this.thirdQuestion = thirdQuestion;
    }
    public String getThirdAnswer() {
        return this.thirdAnswer;
    }
    
    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }
    public String getFourthQuestion() {
        return this.fourthQuestion;
    }
    
    public void setFourthQuestion(String fourthQuestion) {
        this.fourthQuestion = fourthQuestion;
    }
    public String getFourthAnswer() {
        return this.fourthAnswer;
    }
    
    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }
    public Date getDescQuPubTime() {
        return this.descQuPubTime;
    }
    
    public void setDescQuPubTime(Date descQuPubTime) {
        this.descQuPubTime = descQuPubTime;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Set getDescQuesMetas() {
        return this.descQuesMetas;
    }
    
    public void setDescQuesMetas(Set descQuesMetas) {
        this.descQuesMetas = descQuesMetas;
    }




}


