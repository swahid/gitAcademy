/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.InstitutionInfo;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class InstitutionInfoDaoImpl implements elearningDao<InstitutionInfo>, Serializable{

    @Override
    public boolean insert(InstitutionInfo obj) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
       // session.clear();
        session.close();
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(InstitutionInfo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(InstitutionInfo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(InstitutionInfo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstitutionInfo getObjectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstitutionInfo getObjectByName(InstitutionInfo name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InstitutionInfo> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InstitutionInfo> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InstitutionInfo> getListByName(InstitutionInfo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
