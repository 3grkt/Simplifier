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
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Room;
import edu.mum.domain.RoomType;
import edu.mum.domain.UserCredentials;
import edu.mum.service.RoomService;
import edu.mum.service.RoomTypeService;

@RestController
@RequestMapping({ "/rest_room" })
public class RoomRestController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@RequestMapping("")
	public List<Room> list() {

 		return  roomService.listAll();
	}
	
	
}
