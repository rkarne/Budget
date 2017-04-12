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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import pojo.Data;

/**
 *
 * @author c0689497
 */

@Named
@ApplicationScoped
public class RecordController {
     private List<Data> record;
    private Data userobj;
    
    public RecordController(){
        getDatafromDB();
    }
    
    private void getDatafromDB(){
         try {
             DataController db = new DataController();
             int userid = db.getUserId();
             record = new ArrayList<>();
             Connection con = DBUtils.getConnection();
             PreparedStatement pstmt = con.prepareCall("SELECT * FROM userdata WHERE UId=? ");
             pstmt.setInt(1, userid);
             ResultSet rs = pstmt.executeQuery();
             while(rs.next()){
                  Data getrecord = new Data(
                       rs.getInt("TransId"),
                       rs.getDouble("Balance"),
                       rs.getString("Place"),
                       rs.getDouble("Amount"),
                       rs.getString("Tdate"),
                       rs.getInt("UId")
               );
                record.add(getrecord);
             }
         } catch (SQLException ex) {
             Logger.getLogger(RecordController.class.getName()).log(Level.SEVERE, null, ex);
             record = new ArrayList<>();
         }
    }

    public List<Data> getRecord() {
        return record;
    }

    public Data getUserobj() {
        return userobj;
    }

    public void setUserobj(Data userobj) {
        this.userobj = userobj;
    }
    
    
    
}
