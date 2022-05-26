package com.studio.app.controllers;
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
import com.studio.app.services.UserManager;
import com.studio.app.tool.Converter;

@Controller
@RequestMapping("/registration/new")
public class ManageRegistration {
	
	private static Logger log = LoggerFactory.getLogger(ManageRegistration.class);
	
	@Autowired
	Converter converter;
	
	@Autowired
	UserManager userManager;
	
	@GetMapping("")
	public String home(HttpSession session) {
		if(null == session.getAttribute("session")) {
			log.info("Session = NULL");
			log.info("Redirecting to Registration page...");
			return "/views/registration.html";
		}else {
			log.info("Session != NULL");
			log.info("Redirecting to Home...");
			return "redirect:hall";
		}

	}

	@PostMapping("/user")
	public String addNewUser(HttpSession session,@RequestParam(name="username") String username,@RequestParam(name="password") String password) {
		log.info("Add start with input -> {}", username);
		
		UserDTO dto = converter.newUserToDto(converter.newUserToMap(username, password));
		
		if(userManager.createUser(dto)) {
			session.setAttribute("session", username);
			log.info("Add end with output -> {}", dto);
			return "redirect:/hall";
		}else {
			session.setAttribute("session", null);
			return "redirect:/access";
		}
		
	}
}