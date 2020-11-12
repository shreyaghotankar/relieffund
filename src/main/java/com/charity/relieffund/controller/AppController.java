package com.charity.relieffund.controller;


import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.charity.relieffund.dto.UserProfileInfoDTO;




@Controller
public class AppController {
	

	@GetMapping ("/")
    String home() {
	    return "home";
    }
	
	@GetMapping("/restricted")  
    String restricted() {  
        return "restricted"; 
    }
	
	@GetMapping("/profile")
    public ModelAndView userDetails(Authentication authentication) {
		UserProfileInfoDTO profile = new UserProfileInfoDTO();
		profile.setUserName((String)((OAuth2AuthenticationToken)authentication).getPrincipal().getAttributes().get("preferred_username"));
		profile.setFirstName((String)((OAuth2AuthenticationToken)authentication).getPrincipal().getAttributes().get("given_name"));
		profile.setLastName((String)((OAuth2AuthenticationToken)authentication).getPrincipal().getAttributes().get("family_name"));
		profile.setEmail((String)((OAuth2AuthenticationToken)authentication).getPrincipal().getAttributes().get("email"));
		return new ModelAndView("profile" , Collections.singletonMap("details", profile));
    }
	
	@GetMapping("/admin")
	String admin() {
		return "admin";
	}
	
}
