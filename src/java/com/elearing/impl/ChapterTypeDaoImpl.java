/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.ChapterType;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class ChapterTypeDaoImpl implements elearningDao<ChapterType>, Serializable{

    @Override
    public boolean insert(ChapterType obj) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    
    }

    @Override
    public boolean update(ChapterType obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ChapterType obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(ChapterType obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChapterType getObjectById(int id) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ChapterType chapterType=(ChapterType) session.get(ChapterType.class, id);
        session.close();
        return chapterType;
       
       
    }

    @Override
    public ChapterType getObjectByName(ChapterType name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChapterType> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChapterType> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChapterType> getListByName(ChapterType obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       public List<ChapterType> Chapter() {
                 Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        Query qr= s.createQuery("from ChapterType");
//        qr.setParameter("ci", ci);
       
       
       List<ChapterType> list= qr.list();
       s.close();
       return list;
    }
    
    
}
