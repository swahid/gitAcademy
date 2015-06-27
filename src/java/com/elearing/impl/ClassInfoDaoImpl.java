/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.ClassInfo;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class ClassInfoDaoImpl implements elearningDao<ClassInfo>, Serializable {

    @Override
    public boolean insert(ClassInfo obj) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
        
    }

    @Override
    public boolean update(ClassInfo obj) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;  }

    @Override
    public boolean delete(ClassInfo obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(ClassInfo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassInfo getObjectById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ClassInfo info = (ClassInfo) session.get(ClassInfo.class, id);
        session.clear();
        session.close();
        return info;
    }

    @Override
    public ClassInfo getObjectByName(ClassInfo name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClassInfo> getAllObject() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query qr = session.createQuery("from ClassInfo");
        List<ClassInfo> list = qr.list();
        session.clear();
        session.close();
        return list;
    }

    @Override
    public List<ClassInfo> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClassInfo> getListByName(ClassInfo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
