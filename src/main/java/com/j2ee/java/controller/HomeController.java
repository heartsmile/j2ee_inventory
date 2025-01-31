
package com.j2ee.java.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		logger.info("Welcome home!");
		session.setAttribute("staffIDSession", 1);
		
		return "Home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		logger.info("Welcome home!");
		
		return "Home";
	}
	
}
