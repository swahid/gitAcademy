/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.user;

import com.elearing.entity.User;
import com.elearing.entity.UserRole;
import com.elearing.impl.UserDaoImpl;
import com.elearing.impl.UserRoleDaoImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emrul
 */
@ManagedBean
@RequestScoped

public class RegistrationBean {
    public User user =new User();
    public UserRole userRole=new UserRole();
    public UserDaoImpl userDaoImpl=new UserDaoImpl();
    public UserRoleDaoImpl userRoleDaoImpl=new UserRoleDaoImpl();

    
    String msg;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public UserRoleDaoImpl getUserRoleDaoImpl() {
        return userRoleDaoImpl;
    }

    public void setUserRoleDaoImpl(UserRoleDaoImpl userRoleDaoImpl) {
        this.userRoleDaoImpl = userRoleDaoImpl;
    }
    
    

    
    
    
    
    
    public String register(){
//      userRole=userRoleDaoImpl.getRole(userRole.getRoleName());
      user.setUserRole(userRoleDaoImpl.getRole(userRole.getRoleName()));
      userDaoImpl.insert(user);
        return "login";
        
    }
    
}
