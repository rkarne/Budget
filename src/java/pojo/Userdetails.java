/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author c0689497
 */
public class Userdetails {
    private int id;
    private String userName;
    private String userPassword;
    private String name;
    private String email;
    private String date;
    
    public Userdetails(int id, String usname, String uspass, String name, String email, String date){
        this.id = id;
        this.userName = usname;
        this.userPassword = uspass;
        this.name = name;
        this.email=email;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
