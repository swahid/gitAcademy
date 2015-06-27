/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.ChapterType;
import com.elearing.entity.Subject;
import com.elearing.impl.ChapterTypeDaoImpl;
import com.elearing.impl.SubjectDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Emrul
 */
@ManagedBean
@RequestScoped
public class ChapterTypeCRUD implements Serializable{
    
     public ChapterType chapterType=new ChapterType();
    public ChapterTypeDaoImpl chapterTypeDaoImpl=new ChapterTypeDaoImpl();
    public SubjectDaoImpl subjectDaoImpl=new SubjectDaoImpl();
    public Subject subject=new Subject();
    
    
    String msg;

    public SubjectDaoImpl getSubjectDaoImpl() {
        return subjectDaoImpl;
    }

    public void setSubjectDaoImpl(SubjectDaoImpl subjectDaoImpl) {
        this.subjectDaoImpl = subjectDaoImpl;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    
    public List<SelectItem> getSubjectData() {

        List<SelectItem> itemlist = new ArrayList<>();
      
            for (Subject sub : subjectDaoImpl.getAllObject()) {

                itemlist.add(new SelectItem(sub.getSubId(), sub.getSubName()));
            }
            return itemlist;      
        }
  
      public List<SelectItem> getChapterTypeData() {

        List<SelectItem> itemlist = new ArrayList<>();
     // subject=subjectDaoImpl.getObjectById(subject.getSubId());
      
            for (ChapterType chap : chapterTypeDaoImpl.Chapter()) {
                
                itemlist.add(new SelectItem(chap.getChTyId(), chap.getTypeName()));
            }
            return itemlist;      
        }
    
    
    
    
    public String chapterAdd(){
        subject=subjectDaoImpl.getObjectById(subject.getSubId());
       chapterType.setSubject(subject);
        chapterTypeDaoImpl.insert(chapterType);
        msg="New Chapter Added";
        return msg;
    }
}
