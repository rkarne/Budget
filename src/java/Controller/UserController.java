/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import pojo.HashCredentials;
import pojo.UserLogin;
import pojo.Userdetails;

/**
 *
 * @author rkarne
 */

@Named
@ApplicationScoped
public class UserController {
    private List<Userdetails> users;
    private  Userdetails userobj;
    
    
   public UserController(Userdetails userde){
       this.userobj = userde;
      
   }
   
 public UserController(){
     getData();
 }
  
   private void getData(){
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
                       rs.getString("Name"),
                       rs.getString("Email"),
                       rs.getString("Date")
               );
               if(rs.getString("Username").equals("admin")){
                   
               }
               else{
                   users.add(us);
               }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
             users = new ArrayList<>();
        }
   }

    public List<Userdetails> getUsers() {
        return users;
    }

    public  Userdetails getUserobj() {
        return userobj;
    }
    
 
    public String doLogin(){
        //String pass = HashCredentials.hashPassword(password);
        String dbuser = null;
        String dbpass = null;
        try {
            // String pass = HashCredentials.hashPassword(password);
            Connection con = DBUtils.getConnection();
            PreparedStatement pstm = con.prepareCall("SELECT * FROM users where Username=? and Password=?");
            pstm.setString(1, userobj.getUserName());
            pstm.setString(2, userobj.getUserPassword());
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                dbuser = rs.getString("Username");
                dbpass = rs.getString("Password");
                userobj.setName(rs.getString("Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
           
        }
       if(dbuser == null || dbpass == null){
          
            return "index"; 
       }
        if(dbuser.equals(userobj.getUserName()) && dbpass.equals(userobj.getUserPassword())){
            getData();  
            String pass = HashCredentials.hashPassword(userobj.getUserPassword());
            userobj.setUserPassword(pass);
            if(dbuser.equals("admin") ){
                return "Admin";
            }
           return "Template";
          } 
        else{
          return "index";  
        }
    }
    
    public String edit(){
        return "edit";
    }
    
    public String view(Userdetails us){
        userobj =us;
        return "edit";
    }
   public String delete(Userdetails us){
        try {
            Connection conn = DBUtils.getConnection();
            System.out.println(us.getId());
            if (us.getId() > 0) {
                String sql = "DELETE FROM users WHERE UId = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, us.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        getData();  
        return "Admin";
    }
   
   public String addUser(){
       return "Admin";
   }
   
   public String saveUser(){
       try  {
           Connection conn = DBUtils.getConnection();
            if (userobj.getId() >= 0) {
                String sql = "UPDATE users SET Name = ?, Username = ? WHERE UId = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userobj.getName());
                pstmt.setString(2, userobj.getUserName());
                pstmt.setInt(3, userobj.getId());
                pstmt.executeUpdate();
            }
            else{                
                String sql = "INSERT INTO users (Name, Email, Password, Username, Date) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userobj.getName());
                pstmt.setString(2, userobj.getEmail());
                pstmt.setString(3, userobj.getUserPassword());
                pstmt.setString(4, userobj.getUserName());
                pstmt.setString(5, userobj.getDate());
                pstmt.executeUpdate();
                 
            }
          } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getData();
        return "Admin";
   }
   
   public String cancel(){
       return "Admin";
   }
   
  
}

