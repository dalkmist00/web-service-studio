package com.studio.app.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studio.app.dynamo.model.UserDTO;
import com.studio.app.services.LogManager;
import com.studio.app.tool.Converter;

@Controller
@RequestMapping("/login")
public class Login {
	private static Logger log = LoggerFactory.getLogger(Registration.class);
	
	@Autowired
	Converter converter;
	
	@Autowired
	LogManager logManager;

	@GetMapping("")
	public String check(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info("Checking session...");
		if(null == session.getAttribute("session")) {
			log.info("Session = NULL");
			log.info("Redirecting to Registration page...");
			return "redirect:login/attempt";
		}else {
			log.info("Session != NULL");
			log.info("Redirecting to Home...");
			return "redirect:home";
		}
	}
	
	@PostMapping("/attempt")
	public String loginAttempt(HttpSession session,@RequestParam(name="username") String username,@RequestParam(name="password") String password) {
		log.info("LoginAttempt start with inputs -> {}", username,password);
		
		UserDTO dto = converter.newUserToDto(converter.newUserToMap(username, password));
		
		if(logManager.log(dto)) {
			session.setAttribute("session", username);
			log.info("LoginAttempt DONE");
			return "redirect:/hall";
		}else {
			log.info("LoginAttempt FAIL");
			session.setAttribute("session", null);
			return "redirect:/access";
		}
		
	}
}
