package com.springapp.mvc.controllers;

import com.springapp.SessionFactorySingleton;
import com.springapp.mvc.models.Posting;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MonolithicController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, @CookieValue(value = "auth_token", required = false) String authToken) {
		model.addAttribute("authToken", authToken);
        List postings = new LinkedList<>();

        Session dbSession = SessionFactorySingleton.getFactory().openSession();
        Transaction tx = dbSession.beginTransaction();
        try {
            postings = dbSession.createCriteria(Posting.class)
                                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                                .list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            dbSession.close();
        }
        model.addAttribute("postings", postings);
		return "home"; // This is the path of the template file
	}
}