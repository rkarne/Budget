/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author rkarne
 */
@Named
@SessionScoped
public class User implements Serializable {
    private int id;
    private String userName;
    private String userPassword;
    private String name;
    
    public User(int id, String usname, String uspass, String name){
        this.id = id;
        this.userName = usname;
        this.userPassword = uspass;
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
    
     public String validate() {
        
       
        return "index";
     }
}
