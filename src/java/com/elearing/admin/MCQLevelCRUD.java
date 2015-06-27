/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.QuesLevel;
import com.elearing.impl.QuesLevelDaoImpl;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emrul
 */
@ManagedBean
@RequestScoped
public class MCQLevelCRUD implements Serializable{
    public QuesLevel quesLevel=new QuesLevel();
    public QuesLevelDaoImpl quesLevelDaoImpl=new QuesLevelDaoImpl();
    public  String msg;

    public QuesLevel getQuesLevel() {
        return quesLevel;
    }

    public void setQuesLevel(QuesLevel quesLevel) {
        this.quesLevel = quesLevel;
    }

    public QuesLevelDaoImpl getQuesLevelDaoImpl() {
        return quesLevelDaoImpl;
    }

    public void setQuesLevelDaoImpl(QuesLevelDaoImpl quesLevelDaoImpl) {
        this.quesLevelDaoImpl = quesLevelDaoImpl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String save(){
        quesLevelDaoImpl.insert(quesLevel);
        msg="Question Leve Add";
        return msg;
    }
    
}
