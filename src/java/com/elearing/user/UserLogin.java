/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearing.user;

import com.elearing.entity.InstitutionInfo;
import com.elearing.entity.User;
import com.elearing.impl.InstitutionInfoDaoImpl;
import com.elearing.impl.UserDaoImpl;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Emrul
 */
@ManagedBean
@SessionScoped
public class UserLogin implements Serializable {

    private String msg, proname;

    public UserDaoImpl userDaoImpl = new UserDaoImpl();
    public User user = new User();
    public InstitutionInfo institutionInfo = new InstitutionInfo();
    public InstitutionInfoDaoImpl institutionInfoDaoImpl = new InstitutionInfoDaoImpl();
    public int userid;
    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public InstitutionInfoDaoImpl getInstitutionInfoDaoImpl() {
        return institutionInfoDaoImpl;
    }

    public void setInstitutionInfoDaoImpl(InstitutionInfoDaoImpl institutionInfoDaoImpl) {
        this.institutionInfoDaoImpl = institutionInfoDaoImpl;
    }

    public InstitutionInfo getInstitutionInfo() {
        return institutionInfo;
    }

    public void setInstitutionInfo(InstitutionInfo institutionInfo) {
        this.institutionInfo = institutionInfo;
    }

    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    public boolean isLogin = false;

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String login() {

        if (userDaoImpl.getObjectByName(user.getUserName())) {
            if (userDaoImpl.getUserObjectOnNameAndPass(user.getUserName(), user.getUserPass())) {
                user = userDaoImpl.getUserObject(user.getUserName(), user.getUserPass());
              
                System.out.println(user.getUserName() + " is unique and it is now printing ");

                user = (User) user;
                  userid=user.getUserId();
                
                if (user.getUserRole().getRoleName().equalsIgnoreCase("student")) {
                    user = (User) user;
                    isLogin = true;
                    msg=null;
                    setProname("student");
                    return "student";
                } else if (user.getUserRole().getRoleName().equalsIgnoreCase("admin")) {
                    user = (User) user;
                    isLogin = true;
                     msg=null;
                     setProname("admin");
                    return "admin";
                } else if (user.getUserRole().getRoleName().equalsIgnoreCase("teacher")) {
                    user = (User) user;
                    isLogin = true;
                     msg=null;
                     setProname("teacher");
                    return "teacher";
                } else {

                    return "404.xhtml";
                }

            } else {
                msg = "User Password Does not Matched";
               
            }

        } else {

            msg = "User Name  Does Not Matched";
           

        }
        return "login";
       
    }

    public void profileUpdate() {
        
        institutionInfo.setUser(user);
//             set foriegn key 
        if (institutionInfoDaoImpl.insert(institutionInfo)) {

            boolean updateInfo = userDaoImpl.update(user);

            FacesContext context = FacesContext.getCurrentInstance();
            String message = null;

            context.addMessage(null, new FacesMessage("Successful", "Your message: Institution uodate"));

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            String message = null;
            context.addMessage(null, new FacesMessage("Unsucessfull"));

        }

    }

    public String logout() {

//        user.setUserName("");
//        user.setUserRole(null);
//        user.setUserPass(null);
        isLogin = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        // session.invalidate();
        return "index";
    }

    
    
    public String loginFromComent() {

        if (userDaoImpl.getObjectByName(user.getUserName())) {
            if (userDaoImpl.getUserObjectOnNameAndPass(user.getUserName(), user.getUserPass())) {
                user = userDaoImpl.getUserObject(user.getUserName(), user.getUserPass());

                System.out.println(user.getUserName() + " is unique and it is now printing ");

                user = (User) user;
                isLogin = true;
                if (user.getUserRole().getRoleName().equalsIgnoreCase("student")) {
                    user = (User) user;
                    isLogin = true;
                    msg=null;
                    System.out.println("Login Successful");
                    return "comments";
                } else if (user.getUserRole().getRoleName().equalsIgnoreCase("admin")) {
                    user = (User) user;
                    isLogin = true;
                     msg=null;
                    return "admin";
                } else if (user.getUserRole().getRoleName().equalsIgnoreCase("teacher")) {
                    user = (User) user;
                    isLogin = true;
                     msg=null;
                    return "teacher";
                } else {

                    return "404.xhtml";
                }

            } else {
                msg = "User Password Does not Matched";
               
            }

        } else {

            msg = "User Name  Does Not Matched";
           

        }
        return "login";
       
    }
    
    
    
    
}
