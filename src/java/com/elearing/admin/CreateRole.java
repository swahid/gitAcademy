/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.admin;

import com.elearing.entity.UserRole;
import com.elearing.impl.UserRoleDaoImpl;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emrul
 */
@ManagedBean
@RequestScoped
public class CreateRole implements Serializable{
    UserRole userRole=new UserRole();
    UserRoleDaoImpl userRoleDaoImpl=new UserRoleDaoImpl();
    String msg;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRoleDaoImpl getUserRoleDaoImpl() {
        return userRoleDaoImpl;
    }

    public void setUserRoleDaoImpl(UserRoleDaoImpl userRoleDaoImpl) {
        this.userRoleDaoImpl = userRoleDaoImpl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    public String saveRole(){
        userRoleDaoImpl.insert(userRole);
        msg="New role created......!!!";
        return "admin";
        
    }
            
    
    
}
