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
public class Monthly {
    private double bal;
    private String place;
    private double amount;
    private String date;
    private String Udate;
    
    public Monthly(double bal, String place, double amount, String date){
        this.bal = bal;
        this.place = place;
        this.amount = amount;
        this.date = date;
    }
    public Monthly() {
        
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

    public String getUdate() {
        return Udate;
    }

    public void setUdate(String Udate) {
        this.Udate = Udate;
    }

}
