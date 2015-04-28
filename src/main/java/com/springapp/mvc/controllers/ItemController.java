package com.springapp.mvc.controllers;

import com.springapp.SessionFactorySingleton;
import com.springapp.mvc.models.Bid;
import com.springapp.mvc.models.Posting;
import com.springapp.mvc.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ItemController {

    @RequestMapping(value = "details/{id}")
    public String postingDetails(Model model,
                                 @PathVariable("id") int id,
                                 @CookieValue(value = "auth_token", required = false) String authToken) {
        model.addAttribute("authToken", authToken);

        Session dbSession = SessionFactorySingleton.getFactory().openSession();
        Posting posting = new Posting();
        Long objId = (long)id;
        try {
            dbSession.load(posting, objId);
        } finally {
            dbSession.close();
        }

        model.addAttribute(posting);
        return "details";
    }

    @RequestMapping(value = "bid/{id}")
    public String placeBid(Model model,
                           @PathVariable("id") int id,
                           @CookieValue(value = "auth_token", required = false) String authToken,
                           @ModelAttribute("Bid") Bid bid) {
        Session session = SessionFactorySingleton.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Posting post = new Posting();
            session.load(post, (long)id);

            User user = (User)session.load(User.class, Long.parseLong(authToken));

            bid.setPosting(post);
            bid.setBidder(user);
            bid.setDateBid(new Date()); // Now
            session.save(bid);

        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return String.format("redirect:/details/%d", id);
    }
}
