package com.springapp.mvc.models;

import com.sun.istack.internal.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private String email;
    private String hashedPassword;

    public User(String email, String password) {
        this.email = email;
        this.hashedPassword = hashPassword(password);
    }

    public User(String email) {
        this.email = email;
        this.hashedPassword = null;
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
        System.out.println("output");
        return output;

    }

}
