package com.springapp.mvc.controllers;

import com.springapp.SessionFactorySingleton;
import com.springapp.mvc.models.Bid;
import com.springapp.mvc.models.Charity;
import com.springapp.mvc.models.Posting;
import com.springapp.mvc.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Controller
@RequestMapping("/")
public class MonolithicController {


	// TODO Authentication/session variables
	// TODO Database access

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        SessionFactory factory = SessionFactorySingleton.getFactory();

        Session mySession = factory.openSession();
        Transaction tx = mySession.beginTransaction();

        Charity charity = new Charity();
        mySession.load(charity, 2L);
        Set<Posting> postings = charity.getPostings();
        postings.forEach((p) -> System.out.println(p.getDescription()));

        tx.commit();
        mySession.close();

		model.addAttribute("message", "Welcome to Charit-E-Bay!");
		return "hello"; // This is the path of the template file
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String login(@ModelAttribute("User") User user,
                        HttpServletResponse response,
                        @CookieValue(value = "auth_token", required = false) String authToken) {
        if(authToken != null) {
            System.out.println(authToken);
        } else {
            System.out.println("Adding cookie");
            response.addCookie(new Cookie("auth_token", "Hello World!"));
        }

		if(user.authenticate()) {

			// TODO be logged in
		} else {
			// TODO reject login
		}
		return "hello";
	}



//	@RequestMapping("/new_account")
//	public String newAccount(ModelMap model) {
//		model.addAttribute("message", "Login Failed!");
//		User temp = new User("test@example.com");
//		return "hello";
//	}
}