package com.elearing.entity;
// Generated Jun 27, 2015 4:08:38 PM by Hibernate Tools 4.3.1



/**
 * ExamQuesLink generated by hbm2java
 */
public class ExamQuesLink  implements java.io.Serializable {


     private Integer examLinkId;
     private ChapterType chapterType;
     private Exam exam;
     private QuesLevel quesLevel;
     private Integer totalQuesNo;

    public ExamQuesLink() {
    }

    public ExamQuesLink(ChapterType chapterType, Exam exam, QuesLevel quesLevel, Integer totalQuesNo) {
       this.chapterType = chapterType;
       this.exam = exam;
       this.quesLevel = quesLevel;
       this.totalQuesNo = totalQuesNo;
    }
   
    public Integer getExamLinkId() {
        return this.examLinkId;
    }
    
    public void setExamLinkId(Integer examLinkId) {
        this.examLinkId = examLinkId;
    }
    public ChapterType getChapterType() {
        return this.chapterType;
    }
    
    public void setChapterType(ChapterType chapterType) {
        this.chapterType = chapterType;
    }
    public Exam getExam() {
        return this.exam;
    }
    
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public QuesLevel getQuesLevel() {
        return this.quesLevel;
    }
    
    public void setQuesLevel(QuesLevel quesLevel) {
        this.quesLevel = quesLevel;
    }
    public Integer getTotalQuesNo() {
        return this.totalQuesNo;
    }
    
    public void setTotalQuesNo(Integer totalQuesNo) {
        this.totalQuesNo = totalQuesNo;
    }




}


