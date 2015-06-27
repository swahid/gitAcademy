/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.user;


import com.elearing.entity.DescQues;
import com.elearing.entity.DescQuesMeta;
import com.elearing.entity.User;
import com.elearing.impl.DescQuesDaoImpl;
import com.elearing.impl.DescQuesMetaDaoImpl;
import com.elearing.impl.UserDaoImpl;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Emrul
 */
@ManagedBean
@SessionScoped
public class CommentsOnDesc implements Serializable {

    public User user = new User();
    public UserDaoImpl userDaoImpl = new UserDaoImpl();
    public DescQues descQues = new DescQues();
    public DescQuesDaoImpl descQuesDaoImpl = new DescQuesDaoImpl();
    public DescQuesMeta descQuesMeta = new DescQuesMeta();
    public DescQuesMetaDaoImpl descQuesMetaDaoImpl = new DescQuesMetaDaoImpl();

    public DescQuesMetaDaoImpl getDescQuesMetaDaoImpl() {
        return descQuesMetaDaoImpl;
    }

    public void setDescQuesMetaDaoImpl(DescQuesMetaDaoImpl descQuesMetaDaoImpl) {
        this.descQuesMetaDaoImpl = descQuesMetaDaoImpl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public DescQues getDescQues() {
        return descQues;
    }

    public void setDescQues(DescQues descQues) {
        this.descQues = descQues;
    }

    public DescQuesDaoImpl getDescQuesDaoImpl() {
        return descQuesDaoImpl;
    }

    public void setDescQuesDaoImpl(DescQuesDaoImpl descQuesDaoImpl) {
        this.descQuesDaoImpl = descQuesDaoImpl;
    }

    public DescQuesMeta getDescQuesMeta() {
        return descQuesMeta;
    }

    public void setDescQuesMeta(DescQuesMeta descQuesMeta) {
        this.descQuesMeta = descQuesMeta;
    }

    public String descComent() {
        if (descQues.getDescQuesId() != null) {
            descQues = descQuesDaoImpl.getObjectById(descQues.getDescQuesId());
            return "comments";
        } else {
            return "descriptive";
        }
    }

    ////////////////////
    public void insertComment() {

//        System.out.println(descQues.getDescQuesId());
//        System.out.println(descQuesMeta.getUserId());
        if (descQues.getDescQuesId() != null) {
            descQues = descQuesDaoImpl.getObjectById(descQues.getDescQuesId());
            descQuesMeta.setDescQues(descQues);
           
            System.out.println("Comments Printing here  " + descQuesMeta.getDescQuCmnt());
            java.util.Date today = new java.util.Date();
            long t = today.getTime();
            Date d = new java.sql.Date(t);

            descQuesMeta.setCmntTime(d);
            descQuesMetaDaoImpl.insert(descQuesMeta);
            descQuesMeta.setDescQuCmnt(null);
        }
    }

    public List<DescQuesMeta> getAllComents(){ 
     descQues = descQuesDaoImpl.getObjectById(descQues.getDescQuesId());     
     return descQuesMetaDaoImpl.getListByDesc(descQues);
        
    }
   
}
