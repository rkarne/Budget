/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import pojo.Datab;
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
    private List<Datab> usedata;
    private Datab useobj;

    public DataController(Data userde) {
        this.userobj = userde;
    }

    /**
     * refresh controller
     */
    public DataController() {
        getData();
        getDatab();
    }

    /**
     * get user Data
     */
    private void getData() {
        userobj = new Data();
        try {
            userdata = new ArrayList<>();
            Connection con = DBUtils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userdata");

            while (rs.next()) {
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
            usedata = new ArrayList<>();
        }
    }

    public List<Data> getUserdata() {
        return userdata;
    }

    /**
     * get user object
     *
     * @return
     */
    public Data getUserobj() {
        return userobj;
    }

    /**
     * set user data
     *
     * @return
     */
    public List<Datab> getUsedata() {
        return usedata;
    }

    /**
     * get user
     *
     * @return 'Admin'
     */
    public Datab getUseobj() {
        return useobj;
    }

    /**
     * Delete the user from user data
     *
     * @param d
     * @return 'Admin'
     */
    public String delete(Data d) {
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

    /**
     * Add the user
     *
     * @return "Records"
     */
    public String add() {
        int userID = getUserId();
        double g = 0;
        double trans;
        if ("+".equals(userobj.getRadio())) {
            trans = userobj.getAmount();
        } else {
            trans = -(userobj.getAmount());
        }
        try {
            Connection conn = DBUtils.getConnection();
            String h = ("SELECT Balance FROM userdata WHERE TransId=( SELECT max(TransId) FROM userdata) AND UId = ?");
            PreparedStatement stmt = conn.prepareStatement(h);
            stmt.setInt(1, userID);
            ResultSet r = stmt.executeQuery();

            while (r.next()) {
                g = r.getDouble("Balance");
            }

            String sql = "INSERT INTO userdata (Balance, Place, Amount, Tdate, UId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, (g + trans));
            pstmt.setString(2, userobj.getPlace());
            pstmt.setDouble(3, userobj.getAmount());
            pstmt.setString(4, userobj.getDate());
            pstmt.setInt(5, userID);
            pstmt.executeUpdate();
            getData();

            RecordController rc = new RecordController();
            rc.getRecord();

        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Records";

    }

    /**
     * get Data from users
     */
    private void getDatab() {
        useobj = new Datab();
        try {
            int userID = 0;
            String uname = SessionController.getUserName();
            usedata = new ArrayList<>();
            Connection conn = DBUtils.getConnection();
            String get = "SELECT UId from users where Username=?";
            PreparedStatement pstmtget = conn.prepareStatement(get);
            pstmtget.setString(1, uname);
            ResultSet rs = pstmtget.executeQuery();
            while (rs.next()) {
                userID = rs.getInt("UId");
            }
            String l = ("SELECT * FROM userdata WHERE UId = ?");
            PreparedStatement stmtt = conn.prepareStatement(l);
            stmtt.setInt(1, userID);
            ResultSet gr = stmtt.executeQuery();
            while (gr.next()) {
                Datab us = new Datab(
                        gr.getInt("TransId"),
                        gr.getDouble("Balance"),
                        gr.getString("Place"),
                        gr.getDouble("Amount"),
                        gr.getString("Tdate")
                );
                usedata.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
            usedata = new ArrayList<>();
        }
    }

    /**
     * get user id
     *
     * @return userID
     */
    public int getUserId() {
        int userID = 0;
        String uname = SessionController.getUserName();
        try {
            Connection conn = DBUtils.getConnection();
            String get = "SELECT UId from users where Username=?";
            PreparedStatement pstmtget = conn.prepareStatement(get);
            pstmtget.setString(1, uname);
            ResultSet rs = pstmtget.executeQuery();
            while (rs.next()) {
                userID = rs.getInt("UId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userID;
    }

}

