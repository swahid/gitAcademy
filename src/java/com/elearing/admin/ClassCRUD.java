/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.ClassInfo;
import com.elearing.impl.ClassInfoDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Emrul
 */
@ManagedBean
@SessionScoped
    public class ClassCRUD implements Serializable{
    public ClassInfo classInfo=new ClassInfo();
    public ClassInfoDaoImpl classInfoDaoImpl=new ClassInfoDaoImpl();
    String msg;
private String updateInfo;

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }




    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public ClassInfoDaoImpl getClassInfoDaoImpl() {
        return classInfoDaoImpl;
    }

    public void setClassInfoDaoImpl(ClassInfoDaoImpl classInfoDaoImpl) {
        this.classInfoDaoImpl = classInfoDaoImpl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    public String saveClass(){
        
        classInfoDaoImpl.insert(classInfo);
        msg="Class Insert Successfully...........!!!";
        return "admin";
   
    
    }
    
    public String delete(){
        classInfo=classInfoDaoImpl.getObjectById(classInfo.getClassId());
        System.out.println(classInfo.getClassName() +"Class Name is printing");
        classInfoDaoImpl.delete(classInfo);
        classInfo=new ClassInfo();
        msg=classInfo.getClassName() +" Class Has Been Deleted";
        return "admin";
    }
    
    public List<ClassInfo> getAllClass(){
        return classInfoDaoImpl.getAllObject();
    }
    public String update(){
        //classInfo=classInfoDaoImpl.getObjectById(classInfo.getClassId());
        //System.out.println(classInfo.getClassName() +"Class Name is printing");
        classInfoDaoImpl.update(classInfo);
        classInfo=new ClassInfo();
        msg=classInfo.getClassName() +" Class Has Been Deleted";
        return "admin";
    }
    
    public String classById(){
        classInfo= classInfoDaoImpl.getObjectById(classInfo.getClassId());
        return "update";
    }
    
    
}
