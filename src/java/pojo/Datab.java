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

    /**
     *
     * @param id
     * @param bal
     * @param place
     * @param amount
     * @param date
     */
    public Datab(int id, double bal, String place, double amount, String date) {

        this.id = id;
        this.bal = bal;
        this.place = place;
        this.amount = amount;
        this.date = date;
    }

    /**
     * Empty constructor
     */
    public Datab() {

    }

    /**
     * getId
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * setId
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getBal
     *
     * @return bal
     */
    public double getBal() {
        return bal;
    }

    /**
     * setBal
     *
     * @param bal
     */
    public void setBal(double bal) {
        this.bal = bal;
    }

    /**
     * getPlace
     *
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * setPlace
     *
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * getAmount
     *
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * setAmount
     *
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * getDate
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * ]
     * setDate
     *
     * @param date
     */
    public void setDate(String date) {

        this.date = date;
    }

    /**
     * getRadio
     *
     * @return radio
     */
    public String getRadio() {
        return radio;
    }

    /**
     * setRadio
     *
     * @param radio
     */
    public void setRadio(String radio) {
        this.radio = radio;
    }

    /**
     * getUser
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * setUser
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

}
