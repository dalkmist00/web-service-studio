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
@RequestMapping("/hall")
public class Hall {
	private static Logger log = LoggerFactory.getLogger(Hall.class);

	@GetMapping("")
	public String check(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info("Checking session...");
		if(null == session.getAttribute("session")) {
			log.info("Session = NULL");
			log.info("Redirecting to Login...");
			return "redirect:access";
		}else {
			log.info("Session != NULL");
			log.info("Redirecting to Home...");
			return "/views/home.html";
		}
	}
}
