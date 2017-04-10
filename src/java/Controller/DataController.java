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
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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

        userobj = new Data();

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
                       rs.getString("Tdate"),
                       rs.getInt("UId")
               );
                userdata.add(us);
            }
            
        } catch (SQLException ex) {

            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);

             userdata = new ArrayList<>();
        }
   }
       public List<Data> getUserdata() {
        return userdata;
    }

    public Data getUserobj() {
        return userobj;
    }
    
    public String delete(Data d){
        try (Connection conn = DBUtils.getConnection()) {
            
            if (d.getId() > 0) {
                String sql = "DELETE FROM userdata WHERE TransId = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, d.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        getData();  
        return "Admin";
    }
    
    public String add() {
        int userID=getUserId();
        double g = 0;
        double trans;
        if ("+".equals(userobj.getRadio())){
            trans = userobj.getAmount();
        }
        else{
            trans = -(userobj.getAmount());
        }
        try {
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery("SELECT Balance FROM userdata WHERE TransId=( SELECT max(TransId) FROM userdata)");
            while(r.next()){
                g = r.getDouble("Balance");
            }
            String sql = "INSERT INTO userdata (Balance, Place, Amount, Tdate, UId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, (g +trans));
            pstmt.setString(2, userobj.getPlace());
            pstmt.setDouble(3, userobj.getAmount());
            pstmt.setString(4, userobj.getDate());
            pstmt.setInt(5,  userID);
            pstmt.executeUpdate();
            getData();
            RecordController rc = new RecordController();
            rc.getRecord();
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Records";
        
    }
    
    public int getUserId(){
        int userID=0;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
        String uname =  session.getAttribute("username").toString();
         try {
            Connection conn = DBUtils.getConnection();
            String get = "SELECT UId from users where Username=?";
            PreparedStatement pstmtget = conn.prepareStatement(get);
            pstmtget.setString(1, uname);
            ResultSet rs = pstmtget.executeQuery();
            while(rs.next()){
                userID = rs.getInt("UId");
            }
         }
           catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userID;
    }
    
}
