/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author c0681010
 */
public class Datab {
    private int id;
    private double bal;
    private String place;
    private double amount;

    private String date;
    private String radio;
    private String user;
    
    public Datab(int id, double bal, String place, double amount, String date){

        this.id = id;
        this.bal = bal;
        this.place = place;
        this.amount = amount;
        this.date = date;
    }


    public Datab() {
        
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
