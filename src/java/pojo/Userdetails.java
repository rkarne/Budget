/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0689497
 */
@Named

public class Userdetails {

    private int id;
    private String userName;
    private String userPassword;
    private String name;
    private String email;
    private String date;

    /**
     * Userdetails
     *
     * @param id
     * @param usname
     * @param uspass
     * @param name
     * @param email
     * @param date
     */
    public Userdetails(int id, String usname, String uspass, String name, String email, String date) {
        this.id = id;
        this.userName = usname;
        this.userPassword = uspass;
        this.name = name;
        this.email = email;
        this.date = date;
    }
public Userdetails(){
    
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
     * setUserName
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * setUserPassword
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * setName
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * getUserName
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * getUserPassword
     *
     * @return userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * getName
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getEmail
     *
     * @return email
     */
    public String getEmail() {
        return email;
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
     * setEmail
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setDate
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
 public JsonObject convertToJson() {
        return Json.createObjectBuilder()
                .add("id", id)
                .add("title", email)
                .add("name", name)
                .add("username",userName.toString())
                .build();
    }
    
}
