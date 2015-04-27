package com.springapp.mvc.models;

import com.springapp.SessionFactorySingleton;
import org.hibernate.*;

import java.util.Arrays;
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
    private byte[] passwordHash;

    public User() { // default constructor needed for Spring stuff
    }

    // Precondition: this.email and this.passwordHash are set
    // Postcondition: if the email and passwordHash match what appears in the database, the id associated with the
    //                  object is returned. If the data does not match, null is returned
    public Long authenticate() { // TODO database stuff
        Session session = SessionFactorySingleton.getFactory().openSession();
        try {
            String queryString = "FROM users WHERE email = ? AND passwordHash = ?";
            org.hibernate.Query authQuery = session.createQuery(queryString);
            List matches = authQuery.setString(0, this.getEmail())
                                    .setBinary(1, this.getPasswordHash())
                                    .list();
            if(matches.size() != 1) { // Should return at most one result since there is a UNIQUE constraint in the db
                return null;
            } else { // Authentication success
                User retrievedUser = (User)matches.get(0);
                return retrievedUser.getId(); // return d
            }
        } finally {
            session.close();
        }
    }

    private static byte[] hashPassword(String password) {
        MessageDigest myMD;
        try {
            myMD = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        myMD.update(password.getBytes());
        return myMD.digest();
    }

    public Long getId() {
        return id;
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

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] password) {
        this.passwordHash = password;
    }
    public void setPasswordHash(String password) {
        this.passwordHash = password.getBytes();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
