/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;



import Connection.DBUtils;
import Controller.UserController;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author rkarne
 */
@Named
@SessionScoped

public class UserLogin  implements Serializable{
    private String userName;
    private String userPassword;
   
    
    public UserLogin(){
       userName= null;
       userPassword = null;
       
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
         
          Userdetails currentUser = new Userdetails(-1, "", "", "");
          currentUser.setUserName(this.userName);
          currentUser.setUserPassword(this.userPassword);
          UserController us = new UserController(currentUser);
          return us.doLogin(); 
          
       /* try {
            // String pass = HashCredentials.hashPassword(password);
            Connection con = DBUtils.getConnection();
            PreparedStatement pstm = con.prepareCall("SELECT * FROM users where Username=? and Password=?");
            pstm.setString(1, userName);
            pstm.setString(2, userPassword);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                 uname = rs.getString("Username");
                 upass = rs.getString("Password");
                System.out.println("User: "+uname);
                System.out.println("Password: "+upass);
            }
            if(uname.equals(userName) && upass.equals(upass)){
                return "Template";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
      return "index"; */
        
        
    } 

}
