/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.SubChapter;
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
public class SubChapterDaoImpl implements elearningDao<SubChapter>, Serializable {

    @Override
    public boolean insert(SubChapter obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }

    @Override
    public boolean update(SubChapter obj) {
   Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true; }

    @Override
    public boolean delete(SubChapter obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }

    @Override
    public boolean search(SubChapter obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubChapter getObjectById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SubChapter subCh = (SubChapter) session.get(SubChapter.class, id);
        session.clear();
        session.close();
        return subCh; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubChapter getObjectByName(SubChapter name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SubChapter> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SubChapter> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SubChapter> getListByName(SubChapter obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<SubChapter> chapter(Subject ci) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query qr = session.createQuery("from SubChapter where subject = :ci");
        qr.setParameter("ci", ci);
        List<SubChapter> list = qr.list();
        session.clear();
        session.close();
        return list;
    }

}
