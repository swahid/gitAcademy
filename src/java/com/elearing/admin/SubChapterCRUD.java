/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.ClassInfo;
import com.elearing.entity.SubChapter;
import com.elearing.entity.Subject;
import com.elearing.impl.ClassInfoDaoImpl;
import com.elearing.impl.SubChapterDaoImpl;
import com.elearing.impl.SubjectDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Emrul
 */
@ManagedBean
@SessionScoped
public class SubChapterCRUD implements Serializable{
    
public  SubChapterDaoImpl subChapterDaoImpl=new SubChapterDaoImpl();
public SubjectDaoImpl subjectDaoImpl=new SubjectDaoImpl();
public ClassInfoDaoImpl classInfoDaoImpl=new ClassInfoDaoImpl();
public ClassInfo classInfo = new ClassInfo();
public SubChapter subChapter=new SubChapter();
public Subject subject=new Subject();
 public String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public SubjectDaoImpl getSubjectDaoImpl() {
        return subjectDaoImpl;
    }

    public void setSubjectDaoImpl(SubjectDaoImpl subjectDaoImpl) {
        this.subjectDaoImpl = subjectDaoImpl;
    }

    public SubChapterDaoImpl getSubChapterDaoImpl() {
        return subChapterDaoImpl;
    }

    public void setSubChapterDaoImpl(SubChapterDaoImpl subChapterDaoImpl) {
        this.subChapterDaoImpl = subChapterDaoImpl;
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

    public ClassInfoDaoImpl getClassInfoDaoImpl() {
        return classInfoDaoImpl;
    }

    public void setClassInfoDaoImpl(ClassInfoDaoImpl classInfoDaoImpl) {
        this.classInfoDaoImpl = classInfoDaoImpl;
    }

   
    
public List<SelectItem> getSubjectData() {
    System.out.println("Class Id is " +classInfo.getClassId());
        List<SelectItem> itemlist = new ArrayList<>();

        if (classInfo.getClassId() != null) {
            classInfo=classInfoDaoImpl.getObjectById(classInfo.getClassId());
            
            subject.setClassInfo(classInfo);

            for (Subject sub : subjectDaoImpl.subject(subject.getClassInfo())) {

                itemlist.add(new SelectItem(sub.getSubId(), sub.getSubName()));

            }

            return itemlist;
        } else {
            return null;
        }
    }



     
     public String chaptrAdd(){
         subChapter.setSubject(subjectDaoImpl.getObjectById(subject.getSubId()));
         subChapterDaoImpl.insert(subChapter);
         
         
         return "conChapter";
     }
     
     
     
     
     
     public String chapterDelete(){
         subChapter=subChapterDaoImpl.getObjectById(subChapter.getSchId());
         subChapterDaoImpl.delete(subChapter);
         subChapter=new SubChapter();
         
         return "conChapter";
     }
     
      public String chapterByID(){
         subChapter=subChapterDaoImpl.getObjectById(subChapter.getSchId());
      //   subChapterDaoImpl.delete(subChapter);
       //  subChapter=new SubChapter();
         
         return "update";
     }
     
     
     
     
     
          public void chap() {
        if (subChapter.getSchId() != null) {
            subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
           subject=subChapter.getSubject();
           
           
        }
    }
     
     
   public String mcqOnReadPage() {
        if (subChapter.getSchId() != null) {
            subChapter = subChapterDaoImpl.getObjectById(subChapter.getSchId());
            System.out.println("Calling finish.....................");
            System.out.println(subChapter.getSchName());
        }
        return "readMcq";
    }
     
   
   
     public List<SubChapter> getAllChapterList() {
         
         classInfo=classInfoDaoImpl.getObjectById(classInfo.getClassId());
         
        subject=subjectDaoImpl.getObjectById(subject.getSubId());
        
        return subChapterDaoImpl.chapter(subject);

    }

   
   public String chapterToEdit(){
       subChapter=subChapterDaoImpl.getObjectById(subChapter.getSchId());
       
       return "update";
   }
   
   public String update(){
       subChapterDaoImpl.update(subChapter);
       subChapter=new SubChapter();
       
       return"conChapter";
   }
   
   
   
   
   
   
}
