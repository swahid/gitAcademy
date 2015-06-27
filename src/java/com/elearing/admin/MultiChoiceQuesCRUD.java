/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.ChapterType;
import com.elearing.entity.McqQues;
import com.elearing.entity.QuesLevel;
import com.elearing.entity.SubChapter;
import com.elearing.entity.Subject;
import com.elearing.entity.User;
import com.elearing.impl.ChapterTypeDaoImpl;
import com.elearing.impl.McqQuesDaoImpl;
import com.elearing.impl.QuesLevelDaoImpl;
import com.elearing.impl.SubChapterDaoImpl;
import com.elearing.impl.SubjectDaoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Emrul
 */
@SessionScoped
@ManagedBean
public class MultiChoiceQuesCRUD {

    public McqQuesDaoImpl mcqQuesDaoImpl = new McqQuesDaoImpl();
    public Subject subject = new Subject();
    public SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
    public McqQues mcqQues = new McqQues();
    public SubChapter subChapter = new SubChapter();
    public SubChapterDaoImpl subChapterDaoImpl = new SubChapterDaoImpl();
    public ChapterType chapterType = new ChapterType();
    public ChapterTypeDaoImpl chapterTypeDaoImpl = new ChapterTypeDaoImpl();
    public QuesLevel quesLevel = new QuesLevel();
    public QuesLevelDaoImpl quesLevelDaoImpl = new QuesLevelDaoImpl();
    public User user = new User();
    public String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuesLevel getQuesLevel() {
        return quesLevel;
    }

    public void setQuesLevel(QuesLevel quesLevel) {
        this.quesLevel = quesLevel;
    }

    public QuesLevelDaoImpl getQuesLevelDaoImpl() {
        return quesLevelDaoImpl;
    }

    public void setQuesLevelDaoImpl(QuesLevelDaoImpl quesLevelDaoImpl) {
        this.quesLevelDaoImpl = quesLevelDaoImpl;
    }

    public ChapterType getChapterType() {
        return chapterType;
    }

    public void setChapterType(ChapterType chapterType) {
        this.chapterType = chapterType;
    }

    public ChapterTypeDaoImpl getChapterTypeDaoImpl() {
        return chapterTypeDaoImpl;
    }

    public void setChapterTypeDaoImpl(ChapterTypeDaoImpl chapterTypeDaoImpl) {
        this.chapterTypeDaoImpl = chapterTypeDaoImpl;
    }

    public McqQuesDaoImpl getMcqQuesDaoImpl() {
        return mcqQuesDaoImpl;
    }

    public void setMcqQuesDaoImpl(McqQuesDaoImpl mcqQuesDaoImpl) {
        this.mcqQuesDaoImpl = mcqQuesDaoImpl;
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubjectDaoImpl getSubjectDaoImpl() {
        return subjectDaoImpl;
    }

    public void setSubjectDaoImpl(SubjectDaoImpl subjectDaoImpl) {
        this.subjectDaoImpl = subjectDaoImpl;
    }

    public McqQues getMcqQues() {
        return mcqQues;
    }

    public void setMcqQues(McqQues mcqQues) {
        this.mcqQues = mcqQues;
    }

    public SubChapterDaoImpl getSubChapterDaoImpl() {
        return subChapterDaoImpl;
    }

    public void setSubChapterDaoImpl(SubChapterDaoImpl subChapterDaoImpl) {
        this.subChapterDaoImpl = subChapterDaoImpl;
    }

    public List<SelectItem> getChaptertData() {

        List<SelectItem> itemlist = new ArrayList<>();

        if (subject.getSubId() != null) {
            subject = subjectDaoImpl.getObjectById(subject.getSubId());

            subChapter.setSubject(subject);

            for (SubChapter chapter : subChapterDaoImpl.chapter(subChapter.getSubject())) {

                itemlist.add(new SelectItem(chapter.getSchId(), chapter.getSchName()));
            }

            return itemlist;
        } else {
            return null;
        }
    }

    public List<SubChapter> getChaptertDataWithDetails() {

        List<SubChapter> itemlist = new ArrayList<SubChapter>();

        if (subject.getSubId() != null) {
            subject = subjectDaoImpl.getObjectById(subject.getSubId());

            subChapter.setSubject(subject);

//            for (SubChapter chapter : subChapterDaoImpl.chapter(subChapter.getSubject())) {
//
//                itemlist.add(new SelectItem(chapter.getSchId(), chapter.getSchName()));
//            }
            itemlist.add((SubChapter) subChapterDaoImpl.chapter(subject));

            return itemlist;
        } else {
            return null;
        }
    }

    public String addMultipule() {

        Date dateoperation;
        dateoperation = new java.sql.Date(new java.util.Date().getTime());
        mcqQues.setMcqPubTime(dateoperation);
        mcqQues.setQuesLevel(quesLevelDaoImpl.getObjectById(quesLevel.getQuesLevelId()));
        mcqQues.setChapterType(chapterTypeDaoImpl.getObjectById(chapterType.getChTyId()));
        // mcqQues.setSubChapter(subChapterDaoImpl.getObjectById(subChapter.getSchId()));
        mcqQuesDaoImpl.insert(mcqQues);
        return "questionAdd";
    }

    public String deleteMultipule() {
        mcqQues = mcqQuesDaoImpl.getObjectById(mcqQues.getMcqId());
        mcqQuesDaoImpl.delete(mcqQues);
        mcqQues = new McqQues();
        return "questionAdd";
    }

    
    
    
    
    
    public List<McqQues> getAllMcqList() {
       
        subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
        mcqQues.setSubChapter(subChapter);     
        return mcqQuesDaoImpl.getAllMcq(mcqQues.getSubChapter());

    }

    
    
    
    
    
    
    public List<SubChapter> getAllChaptrName() {
        subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
        subject = subChapter.getSubject();
        return subChapterDaoImpl.chapter(subject);

    }

}
