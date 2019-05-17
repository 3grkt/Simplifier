package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Group;
import edu.mum.domain.Member;
import edu.mum.domain.Role;
import edu.mum.service.GroupService;
import edu.mum.service.MemberService;

@RestController
@RequestMapping("/rest_register")
public class RegisterRestController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Member registerMember(@RequestBody Member memberToRegister) {
 
 		try {
 			Group group = groupService.findGroupById((long) Role.ROLE_USER.getIdRole());
			group.getUserCredentials().add(memberToRegister.getUserCredentials());
			memberService.saveFull(memberToRegister, group);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return null;
	}
}
