/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.ChapterType;
import com.elearing.entity.McqQues;
import com.elearing.entity.QuesLevel;
import com.elearing.entity.SubChapter;
import com.elearing.entity.Subject;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class McqQuesDaoImpl implements elearningDao<McqQues>, Serializable {

    public Subject subject = new Subject();
    public SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
    public SubChapterDaoImpl subChapterDaoImpl = new SubChapterDaoImpl();
    public SubChapter subChapter = new SubChapter();

    public SubChapterDaoImpl getSubChapterDaoImpl() {
        return subChapterDaoImpl;
    }

    public void setSubChapterDaoImpl(SubChapterDaoImpl subChapterDaoImpl) {
        this.subChapterDaoImpl = subChapterDaoImpl;
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubjectDaoImpl getSubjectDaoImpl() {
        return subjectDaoImpl;
    }

    public void setSubjectDaoImpl(SubjectDaoImpl subjectDaoImpl) {
        this.subjectDaoImpl = subjectDaoImpl;
    }

    @Override
    public boolean insert(McqQues obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;

//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(McqQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(McqQues obj) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true; }

    @Override
    public boolean search(McqQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public McqQues getObjectById(int id) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       McqQues mcq=(McqQues) session.get(McqQues.class, id);
       session.clear();
       session.close();
        return mcq; 
    
    }

    @Override
    public McqQues getObjectByName(McqQues name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<McqQues> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<McqQues> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<McqQues> getListByName(McqQues obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<McqQues> getAllMcq(SubChapter ci) {
        System.out.println("Method is calling.");
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query qr = s.createQuery("from McqQues where subChapter = :ci");
        qr.setParameter("ci", ci);
        List<McqQues> list = qr.list();
        Collections.reverse(list);
        s.clear();
        s.close();
        return list;
    }

        public List<McqQues> getAllMcqForExam(SubChapter ci) {
        System.out.println("Method is calling.");
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        Query qr = s.createQuery("from McqQues where subChapter = :ci");
        qr.setParameter("ci", ci);

        List<McqQues> list = qr.list();
        Collections.reverse(list);
        s.clear();
        s.close();
        return list.subList(0, 15);
    }

    
     public List<McqQues> getAllMcqOnChapter() {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        Query qr = s.createQuery("from McqQues");
        

        List<McqQues> list = qr.list();
        
        s.clear();
        s.close();
        return list;
    }
    
    
    
    
    
    
    public List<McqQues> getMCQList(SubChapter sc, ChapterType ch, QuesLevel level, int a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query qr = session.createQuery("from McqQues where subChapter =:sub and chapterType =:chap and quesLevel =:lev");
        qr.setParameter("sub", sc);
        qr.setParameter("chap", ch);
        qr.setParameter("lev", level);

        List<McqQues> list = qr.list();
        session.clear();
        session.close();
        Collections.shuffle(list);
        return list.subList(0, a);//To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    int a[] = new int[10];
 List<McqQues> listreturn = null;
        
    public List<McqQues> getMCQListOnSub(Subject sc, ChapterType ch, QuesLevel level, int a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<McqQues> list = null;
        List<SubChapter> chapList = subChapterDaoImpl.chapter(sc);
   
        if (chapList.size() > 0) {
            int len = chapList.size();
            for (int l = 0; l < len; l++) {
                SubChapter link1 = chapList.get(l);

                
                if (l == 0) {
                    Query qr = session.createQuery("from McqQues where subChapter =:sub and chapterType =:chap and quesLevel =:lev");
                    qr.setParameter("sub", link1);
                    qr.setParameter("chap", ch);
                    qr.setParameter("lev", level);
                    list = qr.list();
                } else {
                    Query qr = session.createQuery("from McqQues where subChapter =:sub and chapterType =:chap and quesLevel =:lev");
                    qr.setParameter("sub", link1);
                    qr.setParameter("chap", ch);
                    qr.setParameter("lev", level);
                    
                    list.addAll(qr.list());
                }
            }
        }
        session.clear();
        session.close();
        
        for (McqQues mcq : list) {
            System.out.println("MCQ is printing Before suffle "+mcq.getMcqId());
        }
 // Collections.shuffle(list);
        
           for (McqQues mcq : list) {
            System.out.println("MCQ is printing After suffle "+mcq.getMcqId());
        }
        System.out.println(" sub list "+a);
        List<McqQues> ret=null;
       ret =list.subList(0, a);
            for (McqQues mcq : ret) {
            System.out.println("MCQ is printing After sublist "+mcq.getMcqId());
        }
        return ret;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      public List<McqQues> getMCQListOnChapter(ChapterType ch, QuesLevel level, int a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<McqQues> list = null;

    //   Query qr = session.createQuery("from McqQues where chapterType =:chap and quesLevel =:lev"); 
           Query qr = session.createQuery("from McqQues");
       
        session.clear();
        session.close();
        Collections.shuffle(list);
        return list.subList(0, a);
    }
    
    
    
    
}
