package edu.mum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Group;
import edu.mum.domain.Member;
import edu.mum.service.GroupService;
import edu.mum.service.MemberService;

@Controller
@RequestMapping({ "/members" })
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private GroupService groupService;
	
	private Map<String, Group> groupCache;
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

    AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");
    
	@RequestMapping
	public String listMembers(Model model, HttpSession session) {
		try {			
			model.addAttribute("members", memberService.findAll());
		} catch (AuthenticationCredentialsNotFoundException e) {
			System.out.println();
			System.out.println(" ******** ANONYMOUS USER Attempted to access a secure resource *********");
			System.out.println();
			return "redirect:/welcome";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "error-forbidden";
		}

		
		return "members";
	}

	@RequestMapping("/manage")
	public String manageMember(Model model, HttpSession session) {
		try {			
			model.addAttribute("members", memberService.findAll());
		} catch (AuthenticationCredentialsNotFoundException e) {
			System.out.println();
			System.out.println(" ******** ANONYMOUS USER Attempted to access a secure resource *********");
			System.out.println();
			return "redirect:/welcome";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "error-forbidden";
		}

		
		return "manageMember";
	}

	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findOne(id);
		model.addAttribute("member", member);

		return "member";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newMember") Member newMember,Model model) {
		List<Group> groupList = groupService.findAll();
		groupCache = new HashMap<String, Group>();
		for (Group group : groupList) {
			groupCache.put(group.getIdAsString(), group);
		}
		model.addAttribute("groupList",groupList);
		return "addMember";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@Valid @ModelAttribute("newMember") Member memberToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addMember";
		}

		// Error caught by ControllerAdvice IF no authorization...
		memberService.saveFull(memberToBeAdded, new Group());

		return "redirect:/members/manage";

	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String updateMemberById(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findOne(id);
		model.addAttribute("newMember", member);
		List<Group> groupList = groupService.findAll();
		model.addAttribute("groupList",groupList);
		return "addMember";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updateMember(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("newRoom") Member memberToAdd,BindingResult result) {
		if (result.hasErrors()) {
			List<Group> groupList = groupService.findAll();
			model.addAttribute("groupList",groupList);
			return "addMember";
		}
		memberService.update(memberToAdd);

		return "redirect:/members/manage";
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "groups", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof Group) {					
					return element;
				}
				if (element instanceof String) {
					Group group = groupCache.get(element);
					
					return group;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}
	@RequestMapping("/{id}/delete")
	public String deleteMemberById(@PathVariable("id") Long id, Model model) {
		memberService.delete(id);	

		return "redirect:/members/manage";
	}


}
