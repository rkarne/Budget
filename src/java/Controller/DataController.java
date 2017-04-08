/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.DBUtils;
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
import javax.inject.Named;
import pojo.Data;

/**
 *
 * @author c0681010
 */
@Named
@ApplicationScoped
public class DataController {
    private List<Data> userdata;
    private Data userobj;
    
       public DataController(Data userde){
           this.userobj = userde;
       }
    public DataController(){
     getData();
 }
       private void getData(){
       //userobj = this;
        try {
            userdata = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userdata");
            
            while(rs.next()){
               Data us = new Data(
                       rs.getInt("TransId"),
                       rs.getDouble("Balance"),
                       rs.getString("Place"),
                       rs.getDouble("Amount"),
                       rs.getDate("Tdate"),
                       rs.getInt("UId")
               );
                userdata.add(us);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
             userdata = new ArrayList<>();
        }
   }
       public List<Data> getUserdata() {
        return userdata;
    }

    public Data getUserobj() {
        return userobj;
    }
    public String delete(){
        try (Connection conn = DBUtils.getConnection()) {
            System.out.println(userobj.getId());
            if (userobj.getId() > 0) {
                String sql = "DELETE FROM userdata WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userobj.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getData();  
        return "index";
    }
    
    public String add() {
        try {
            Connection conn = DBUtils.getConnection();
            //Statement stmt = conn.createStatement();
           // stmt.executeUpdate("INSERT INTO products VALUES (" + thisProduct.getProductId() + ",'" + thisProduct.getName() + "','" + thisProduct.getVendorId() + "')");
            String sql = "INSERT INTO Products (Balance, Place, Amount, Date, UId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, (userobj.getBal()));
            pstmt.setString(2, userobj.getPlace());
            pstmt.setDouble(3, userobj.getAmount());
            pstmt.setDate(4, userobj.getDate());
            pstmt.setInt(5, userobj.getId());
            pstmt.executeUpdate();
            getData();
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
        
    }
}