/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import Controller.SessionController;
import Controller.UserController;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkarne
 */
@Named
@SessionScoped
@ManagedBean

public class UserLogin implements Serializable {

    private String userName;
    private String userPassword;
    private String email;
    private String name;
    private String date;

    /**
     * user login
     */
    public UserLogin() {
    }

    /**
     * UserLogin constructor
     *
     * @param user
     * @param pass
     * @param email
     * @param name
     * @param date
     */
    public UserLogin(String user, String pass, String email, String name, String date) {
        this.userName = user;
        this.userPassword = pass;
        this.email = email;
        this.name = name;
        this.date = date;
    }

    /**
     * getUserName
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * getUserPassword
     *
     * @return userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * setUserName
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * setUserPassword
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * getEmail
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getName
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getDate
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * setEmail
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setName
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setDate
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * validate
     *
     * @return
     */
    public String validate() {
        Userdetails currentUser = new Userdetails(-1, "", "", "", "", "");
        currentUser.setUserName(this.userName);
        currentUser.setUserPassword(this.userPassword);
        UserController us = new UserController(currentUser);
        HttpSession session = SessionController.getSession();
        session.setAttribute("username", userName);
        return us.doLogin();
    }

    /**
     * dataFrom
     *
     * @return
     */
    public String dataFrom() {
        Userdetails User = new Userdetails(-1, userName, userPassword, name, email, date);
        UserController us = new UserController(User);
        return us.insert();
    }

    public void logout() throws IOException {
        HttpSession session = SessionController.getSession();
        session.invalidate();
        /* FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } */
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("logged out successfully"));
        ExternalContext externalContext = context.getExternalContext();
        externalContext.getFlash().setKeepMessages(true);
        externalContext.invalidateSession();
        externalContext.redirect("index.xhtml");
    }
    
    
     public void success() throws IOException {
        HttpSession session = SessionController.getSession();
        session.invalidate();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Created User successfully.. Try Login !"));
        ExternalContext externalContext = context.getExternalContext();
        externalContext.getFlash().setKeepMessages(true);
        externalContext.invalidateSession();
        externalContext.redirect("index.xhtml");
    }
    

}
