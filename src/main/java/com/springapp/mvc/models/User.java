package com.springapp.mvc.models;

import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String email;

    @Basic
    @Column(name="user_name")
    private String userName;

    @Basic
    @Column(name="password_hash")
    private String passwordHash;

    public User() { // default constructor needed for Spring stuff
    }

    public boolean authenticate() { // TODO database stuff
        return true;
    }

    public void save() { // save to database - May remove in favor of Hibernate
    }

    private static String hashPassword(String password) {
        MessageDigest myMD;
        try {
            myMD = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        myMD.update(password.getBytes());
        String output = new String(myMD.digest());
        return output;
    }

    public List<Bid> getBids() {
        List<Bid> temp = new ArrayList<Bid>();
        temp.add(new Bid());
        return temp; // TODO
    }

    public List<Posting> getPostings() {
        List<Posting> temp = new ArrayList<Posting>();
        temp.add(new Posting());
        return temp; // TODO
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = hashPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
