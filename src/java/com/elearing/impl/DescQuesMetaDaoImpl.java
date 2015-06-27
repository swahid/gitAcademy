/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.DescQues;
import com.elearing.entity.DescQuesMeta;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class DescQuesMetaDaoImpl implements elearningDao<DescQuesMeta>, Serializable{

    @Override
    public boolean insert(DescQuesMeta obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DescQuesMeta obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(DescQuesMeta obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(DescQuesMeta obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DescQuesMeta getObjectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DescQuesMeta getObjectByName(DescQuesMeta name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DescQuesMeta> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DescQuesMeta> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DescQuesMeta> getListByName(DescQuesMeta obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  public List<DescQuesMeta> getListByDesc(DescQues obj) {
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query qr = session.createQuery("from DescQuesMeta where descQues = :ci");
        qr.setParameter("ci", obj);
        List<DescQuesMeta> list = qr.list();
        session.close();
        return list; //To change body of generated methods, choose Tools | Templates.
    }    
}
