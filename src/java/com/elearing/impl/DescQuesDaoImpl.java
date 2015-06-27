/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.DescQues;
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
public class DescQuesDaoImpl implements elearningDao<DescQues>, Serializable{

    @Override
    public boolean insert(DescQues obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DescQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(DescQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(DescQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DescQues getObjectById(int id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        DescQues ques=(DescQues) session.get(DescQues.class, id);
        session.close();
        return ques;
    }

    @Override
    public DescQues getObjectByName(DescQues name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DescQues> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DescQues> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DescQues> getListByName(DescQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public List<DescQues> getAllDesc(SubChapter ci) {
        Session s= HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        Query qr= s.createQuery("from DescQues where subChapter = :ci");
        qr.setParameter("ci", ci);
       
       
       List<DescQues> list= qr.list();
       s.close();
       return list;
    }
    
    
}
