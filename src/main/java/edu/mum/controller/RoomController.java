package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Room;
import edu.mum.domain.RoomType;
import edu.mum.service.RoomService;
import edu.mum.service.RoomTypeService;

@Controller
@RequestMapping({ "/rooms" })
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@RequestMapping
	public String listRoom(Model model){
		
		model.addAttribute("rooms", roomService.listAll());
		return "rooms";
	}
	
	@RequestMapping("/manage")
	public String manageRoom(Model model){
		
		model.addAttribute("rooms", roomService.listAll());
		return "manageRoom";
	}
	
	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id, Model model) {
		Room room = roomService.findOne(id);
		model.addAttribute("room", room);

		return "room";
	}
	
	@RequestMapping("/{id}/delete")
	public String deleteMemberById(@PathVariable("id") Long id, Model model) {
		roomService.delete(id);	

		return "redirect:/manageRoom";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String updateMemberById(@PathVariable("id") Long id, Model model) {
		Room room = roomService.findOne(id);
		model.addAttribute("room", room);

		return "updateRoom";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String updateMember(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("newroom") Room roomToAdd, BindingResult result) {
		if (result.hasErrors()) {
			return "updateRoom";
		}
		roomService.update(roomToAdd);

		return "redirect:/manageRoom";
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewRoom(@ModelAttribute("newRoom") Room newRoom, Model model) {
		List<RoomType> roomTypeList = roomTypeService.listAll();
		model.addAttribute("roomTypeList", roomTypeList);
		return "addRoom";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@Valid @ModelAttribute("newRoom") Room roomToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addRoom";
		}

		// Error caught by ControllerAdvice IF no authorization...
		roomService.save(roomToBeAdded);

		return "redirect:/manageRoom";

	}
}
