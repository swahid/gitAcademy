/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.ClassInfo;
import com.elearing.entity.Subject;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class SubjectDaoImpl implements elearningDao<Subject>, Serializable{

    @Override
    public boolean insert(Subject obj) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;   
    }

    @Override
    public boolean update(Subject obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;    }

    @Override
    public boolean delete(Subject obj) {
       
    Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    
    
    }

    @Override
    public boolean search(Subject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subject getObjectById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Subject subj=(Subject) session.get(Subject.class, id);
       session.clear();
       session.close();
        return subj;
    }

    @Override
    public Subject getObjectByName(Subject name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subject> getAllObject() {
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        Query qr= s.createQuery("from Subject");
       List<Subject> list= qr.list();
       s.close();
       return list;
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subject> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subject> getListByName(Subject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public List<Subject> subject(ClassInfo ci) {
                 Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        Query qr= s.createQuery("from Subject where classInfo = :ci");
        qr.setParameter("ci", ci);
       
       
       List<Subject> list= qr.list();
       s.close();
       return list;
    }
}
