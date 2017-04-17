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
import pojo.Data;

/**
 *
 * @author c0689497
 */
public class AdminController {

    private List<Data> data;

    public AdminController() {
        getData();
    }

    private void getData() {
        try {
            data = new ArrayList<>();
            int userid = getUerId();
            Connection con = DBUtils.getConnection();
            PreparedStatement pstmtget = con.prepareStatement("SELECT * FROM userdata where UId = ?");
            pstmtget.setInt(1, userid);
            ResultSet record = pstmtget.executeQuery();
            while (record.next()) {
                Data d = new Data(
                        record.getInt("TransId"),
                        record.getDouble("Balance"),
                        record.getString("Place"),
                        record.getDouble("Amount"),
                        record.getString("Tdate"),
                        record.getInt("UId")
                );
                data.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
            data = new ArrayList<>();

        }
    }

    private int getUerId() {
        return 0;
    }
}
