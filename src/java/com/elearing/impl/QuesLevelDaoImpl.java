/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.QuesLevel;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class QuesLevelDaoImpl implements elearningDao<QuesLevel>, Serializable{

    @Override
    public boolean insert(QuesLevel obj) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;  }

    @Override
    public boolean update(QuesLevel obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(QuesLevel obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(QuesLevel obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuesLevel getObjectById(int id) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        QuesLevel quesLevel=(QuesLevel) session.get(QuesLevel.class, id);
        session.close();
        return quesLevel;
    }

    @Override
    public QuesLevel getObjectByName(QuesLevel name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuesLevel> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuesLevel> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuesLevel> getListByName(QuesLevel obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
