package com.springapp.mvc.controllers;

import com.springapp.SessionFactorySingleton;
import com.springapp.mvc.models.Bid;
import com.springapp.mvc.models.Charity;
import com.springapp.mvc.models.Posting;
import com.springapp.mvc.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    @RequestMapping("post_item")
    public String newItem(Model model, @CookieValue(value = "auth_token", required = false) String authToken) {
        if(authToken == null) {
            return "redirect:/";
        }
        model.addAttribute("authToken", authToken);

        List charities = new LinkedList<>();

        Session session = SessionFactorySingleton.getFactory().openSession();

        try {
            charities = session.createCriteria(Charity.class).list();
        } finally {
            session.close();
        }
        model.addAttribute("charities", charities);
        return "create";
    }

    @RequestMapping(value = "post_item", method = RequestMethod.POST)
    public String createItem(Model model,
                             @CookieValue(value = "auth_token", required = false) String authToken,
                             @ModelAttribute("Posting") Posting post,
                             @RequestParam(value = "organization", required = false) String charityId) {


        Session session = SessionFactorySingleton.getFactory().openSession();
        Transaction tx = null;
        Long id = null;

        try {
            tx = session.beginTransaction();
            Charity charity = (Charity)session.load(Charity.class, Long.parseLong(charityId));
            post.setCharity(charity);

            User user = (User)session.load(User.class, Long.parseLong(authToken));

            post.setDonor(user);

            id = (Long)session.save(post);

            tx.commit();
        } catch (Exception e ) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        if(id == null) {
            return "redirect:/post_item";
        } else {
            return "redirect:/details/"+id;
        }
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
            tx.commit();
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
