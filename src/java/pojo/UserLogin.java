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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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
   
    
    public UserLogin(){       
    }

    public UserLogin(String user, String pass){
        this.userName = user;
        this.userPassword = pass;
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

      public String validate() {
          Userdetails currentUser = new Userdetails(-1, "", "", "", "", "");
          currentUser.setUserName(this.userName);
          currentUser.setUserPassword(this.userPassword);
          UserController us = new UserController(currentUser);
          HttpSession session = SessionController.getSession();
          session.setAttribute("username", userName);
          return us.doLogin();       
    } 
      
       public void logout(){
        HttpSession session = SessionController.getSession();
	session.invalidate();
       // FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
      
}
