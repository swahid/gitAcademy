/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.Exam;
import com.elearing.entity.ExamQuesLink;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class ExamQuesLinkDaoImpl implements elearningDao<ExamQuesLink>, Serializable{

    @Override
    public boolean insert(ExamQuesLink obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ExamQuesLink obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ExamQuesLink obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(ExamQuesLink obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExamQuesLink getObjectById(int id) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         ExamQuesLink eql=(ExamQuesLink) session.get(ExamQuesLink.class, id);
         session.close();
         return eql;
    }

    @Override
    public ExamQuesLink getObjectByName(ExamQuesLink name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamQuesLink> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamQuesLink> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamQuesLink> getListByName(ExamQuesLink obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<ExamQuesLink> getQueLinkByExamId(Exam ex) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       // ExamQuesLink qlink = (ExamQuesLink) session.get(ExamQuesLink.class, ex);
       Query qr = session.createQuery("from ExamQuesLink where exam =:ex");
        qr.setParameter("ex", ex);
        List<ExamQuesLink> lis = qr.list();    
        session.clear();
        session.close();
        return  lis;
    }
    
}
