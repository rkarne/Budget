/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import pojo.User;

/**
 *
 * @author rkarne
 */

@Named
@ApplicationScoped
public class UserController {
    private List<User> users;
    private User userobj;
    
   public UserController(){
        userobj = new User(-1, "", "", "");
        getData();
   }
   
   private void getData(){
        try {
            users = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userlogin");
            while(rs.next()){
                User us = new User(
                 rs.getInt("id"),
                 rs.getString("username"),
                 rs.getString("userpass"),
                 rs.getString("name")
                );
                users.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    public List<User> getUsers() {
        return users;
    }

    public User getUserobj() {
        return userobj;
    }
   
     public String validate() {
      
     
        return "index";
    }

  
}
