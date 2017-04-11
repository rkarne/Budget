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

public class UserLogin  implements Serializable{
    private String userName;
    private String userPassword;
    private String email;
    private String name;
    private String date;
    
    public UserLogin(){       
    }

    public UserLogin(String user, String pass, String email, String name, String date){
        this.userName = user;
        this.userPassword = pass;
        this.email=email;
        this.name = name;
        this.date=date;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

  
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

      public String validate() {
          Userdetails currentUser = new Userdetails(-1, "", "", "", "", "");
          currentUser.setUserName(this.userName);
          currentUser.setUserPassword(this.userPassword);
          UserController us = new UserController(currentUser);
          HttpSession session = SessionController.getSession();
          session.setAttribute("username", userName);
          return us.doLogin();       
    } 
      
       public void logout() throws IOException{
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
      
}
