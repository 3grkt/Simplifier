package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Group;
import edu.mum.domain.Member;
import edu.mum.domain.Role;
import edu.mum.service.GroupService;
import edu.mum.service.MemberService;

@Controller
public class RegisterController {
	
	@Autowired
	private MemberService  memberService;
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerMemberForm(@ModelAttribute("newMember") Member member){
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegisterMemberForm( @Valid @ModelAttribute("newMember") Member memberToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "register";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
			Group group = groupService.findGroupById((long) Role.ROLE_USER.getIdRole());
			group.getUserCredentials().add(memberToBeAdded.getUserCredentials());
			memberService.saveFull(memberToBeAdded, group);

	   	return "redirect:/welcome";
 
	}
}
