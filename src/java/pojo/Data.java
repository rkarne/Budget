/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 *
 * @author c0681010
 */
public class Data {
    private int id;
    private double bal;
    private String place;
    private double amount;
    private String date;
    private int UId;
    private String radio;
    private String user;
    
    public Data(int id, double bal, String place, double amount, String date, int UId){
        this.id = id;
        this.bal = bal;
        this.place = place;
        this.amount = amount;
        this.date = date;
        this.UId = UId;
    }

    public Data() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
