package com.springapp.mvc.controllers;

import com.springapp.SessionFactorySingleton;
import com.springapp.mvc.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SessionController {

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String registration_page() { // This method should return the page with the form to register for the site
        return "registration_form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create_account(@ModelAttribute("User") User user) {
        // Read form values
        // Validate presence of all fields
        // Check that passwords match
        // System.out.println("Email = " + user.getEmail());
        // System.out.println("UName = " + user.getUserName());
        // System.out.println("PWord = " + user.getPasswordHash());

        if(user.getEmail()==null || user.getUserName()==null || user.getPasswordHash()==null) {
            return "registration_form"; // TODO display some kind of error message
        }

        Session dbSession = SessionFactorySingleton.getFactory().openSession();
        Transaction tx = dbSession.beginTransaction();

        try {
            System.out.println("Key = " + dbSession.save(user));
            tx.commit();
        } catch (Exception e){ // TODO Display some type of error message depending on what type of failure it is
            e.printStackTrace();
            tx.rollback();
            return "registration_form";
        } finally {
            dbSession.close();
        }

        return "hello"; // TODO Display some kind of success message
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("User") User user, HttpServletResponse response) {
        System.out.println(new String(user.getPasswordHash()));
        Long id = user.authenticate();
        System.out.println("Authenticating. id = " + id);
        if(id != null) { // TODO - Redirect to some other location  and display a success message
            Cookie authCookie = new Cookie("auth_token", id.toString());
            response.addCookie(authCookie);
            return "hello";
        } else {    // TODO - Redirect to login page and display an error message
            return "registration_form";
        }
    }
}
