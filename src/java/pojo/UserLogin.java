/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;




import Controller.UserController;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
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
         
          Userdetails currentUser = new Userdetails(-1, "", "", "");
          currentUser.setUserName(this.userName);
          currentUser.setUserPassword(this.userPassword);
          UserController us = new UserController(currentUser);
           HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
           session.setAttribute("username", userName);
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
