/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.impl;

import com.elearing.dao.elearningDao;
import com.elearing.entity.User;
import com.elearing.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Faruqul Islam
 */
public class UserDaoImpl implements elearningDao<User>, Serializable {

    @Override
    public boolean insert(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
    }

    @Override
    public boolean update(User obj) {
       Session ses = HibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        
        String hql="Update User set firstName= :fn , lastName= :ln , userEmail= :email , userPhone= :ph where userName= :un";
        Query qr=ses.createQuery(hql);
        qr.setString("fn", obj.getFirstName());
        qr.setString("ln", obj.getLastName());
        qr.setString("email", obj.getUserEmail());
        qr.setString("ph", obj.getUserPhone());
        qr.setString("un", obj.getUserName());
        qr.executeUpdate();
        ses.getTransaction().commit();
        ses.clear();
        ses.close();
     
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getObjectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getObjectByName(User name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getListById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getListByName(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public User getUserObject(String name, String pass){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=  session.createQuery("from User where userName =:ur and userPass =:pass");
        query.setString("ur", name);
        query.setString("pass", pass);       
         User  user=(User) query.list().get(0);
      
        return user;
        
    }
  
       public boolean getObjectByName(String name) {
        
        Session sessi=HibernateUtil.getSessionFactory().openSession();
        sessi.beginTransaction();
        Query query=  sessi.createQuery("from User where userName =:ur");
        query.setString("ur", name);
        
         List list = query.list();
        
       
           if (list.size()>0) {
               
                return true; 
           } else {
               
                return false; 
           }    
           
    }
       
        public boolean getUserObjectOnNameAndPass(String name, String pass){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        Query query=  ss.createQuery("from User where userName =:ur and userPass =:pass");
        query.setString("ur", name);
        query.setString("pass", pass);       
        
        List list = query.list();
        
           if (list.size()>0) {
               
                return true; 
           } else {
              
                return false; 
           }
        
    }
       
       
       
       
}
