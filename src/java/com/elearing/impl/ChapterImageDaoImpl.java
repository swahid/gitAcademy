/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.ChapterImage;
import com.elearing.entity.SubChapter;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class ChapterImageDaoImpl implements elearningDao<ChapterImage>, Serializable{

    @Override
    public boolean insert(ChapterImage obj) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
        session.clear();
        return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ChapterImage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ChapterImage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(ChapterImage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChapterImage getObjectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChapterImage getObjectByName(ChapterImage name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChapterImage> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChapterImage> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChapterImage> getListByName(ChapterImage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
      public List<ChapterImage> getListByNameChapter(SubChapter obj) {
      Session session=HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
        Query qr= session.createQuery("from ChapterImage where subChapter =:chap");
        qr.setParameter("chap", obj);
        List<ChapterImage> list=qr.list();
        session.clear();
        session.close();
        return list;
      }
    
    
    
    
}
