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
import pojo.Userdetails;

/**
 *
 * @author rkarne
 */

@Named
@ApplicationScoped
public class UserController {
    private List<Userdetails> users;
    private static UserController userobj;
    
   public UserController(){
        
   }
   
   public void getData(){
       //userobj = this;
        try {
            users = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            
            while(rs.next()){
               Userdetails us = new Userdetails(
                       rs.getInt("UId"),
                       rs.getString("Username"),
                       rs.getString("Password"),
                       rs.getString("Name")
               );
                users.add(us);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
             users = new ArrayList<>();
        }
   }

    public List<Userdetails> getUsers() {
        return users;
    }

    public static UserController getUserobj() {
        return userobj;
    }
    
  
}
