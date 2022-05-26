package com.studio.app.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class Registration {
	private static Logger log = LoggerFactory.getLogger(Registration.class);
	
	@GetMapping("")
	public String check(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info("Checking session...");
		if(null == session.getAttribute("session")) {
			log.info("Session = NULL");
			log.info("Redirecting to Registration page...");
			return "redirect:registration/new";
		}else {
			log.info("Session != NULL");
			log.info("Redirecting to Home...");
			return "redirect:home";
		}
	}
}
