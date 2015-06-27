/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.ClassInfo;
import com.elearing.entity.Subject;
import com.elearing.impl.ClassInfoDaoImpl;
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
public class SubjectCRUD implements Serializable{
    public ClassInfo classInfo=new ClassInfo();
    public Subject subject=new Subject();
    public SubjectDaoImpl subjectDaoImpl=new SubjectDaoImpl();
    public ClassInfoDaoImpl classInfoDaoImpl=new ClassInfoDaoImpl();
    public String className=null;
    public String subName=null;
    public String chapetrName=null;
    public String quesAdd=null;

    public String getQuesAdd() {
        return quesAdd;
    }

    public void setQuesAdd(String quesAdd) {
        this.quesAdd = quesAdd;
    }

    public String getChapetrName() {
        return chapetrName;
    }

    public void setChapetrName(String chapetrName) {
        this.chapetrName = chapetrName;
    }
    

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
    

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
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

    public ClassInfoDaoImpl getClassInfoDaoImpl() {
        return classInfoDaoImpl;
    }

    public void setClassInfoDaoImpl(ClassInfoDaoImpl classInfoDaoImpl) {
        this.classInfoDaoImpl = classInfoDaoImpl;
    }

   public List<SelectItem> getClassData() {
        List<SelectItem> classList = new ArrayList<>();

        for (ClassInfo ar : classInfoDaoImpl.getAllObject()) {

            classList.add(new SelectItem(ar.getClassId(), ar.getClassName()));

        }
        return classList;
    }
    
    public String insertSub(){
        System.out.println("Subject name is "+ classInfo.getClassName());
        subject.setClassInfo(classInfoDaoImpl.getObjectById(classInfo.getClassId()));
        subjectDaoImpl.insert(subject);
        return"conSubject";
    }
    
    
    public String deleteSub(){
       subject=subjectDaoImpl.getObjectById(subject.getSubId());
        subjectDaoImpl.delete(subject);
        subject=new Subject();
        return"conSubject";
    }
       
    public String redirectTo(){
        
        return"admin";
    } 
    
    public String subjectByID(){
        
        subject=subjectDaoImpl.getObjectById(subject.getSubId());
        return "update";
    }
    
    
    
    
     public String update(){
      
        subjectDaoImpl.update(subject);
       
        return"conSubject";
    }
    
    
}
