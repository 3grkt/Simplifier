package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.Member;
import edu.mum.domain.UserCredentials;
import edu.mum.security.AuthenticateUser;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("member")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

    AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model) {
		try {
			UserCredentials validCredentials = credentialsService.findByUserName(credentials.getUsername());
			AuthenticateUser authenticateUser = new AuthenticateUser();
			authenticateUser.authenticate(authenticationManager, validCredentials.getUsername(), validCredentials.getPassword());
			
			System.out.println(validCredentials.toString());
			if (validCredentials == null) {
				System.out.println("NULL===============");
				return "login";
			}
			model.addAttribute("member", validCredentials.getMember());
			return "redirect:/welcome";
		} catch (Exception e) {
			return "login";
		}
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/welcome";
	}
}
