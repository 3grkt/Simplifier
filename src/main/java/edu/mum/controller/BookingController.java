package edu.mum.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.amqp.MessageService;
import edu.mum.amqp.MessageServiceImpl;
import edu.mum.domain.Booking;
import edu.mum.domain.Member;
import edu.mum.domain.Room;
import edu.mum.service.BookingService;
import edu.mum.service.MemberService;
import edu.mum.service.RoomService;


@Controller
@RequestMapping("/bookings")
public class BookingController {
	private final String SENDER_XML = "classpath:META-INF/spring/amqp-rabbit-sender-context.xml";
	

	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RoomService roomService;
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MessageService messageService;
 
 	@RequestMapping({"","/all"})
	public String list(Model model) {
 		
		model.addAttribute("bookings", bookingService.findBookingsByStatus(1));
		return "bookings";
	}
	
 	@RequestMapping("/detailbooking")
	public String getBookingById(Model model, @RequestParam("id") Long id, @RequestParam(value="approve", required=false) Boolean approve) {
 		
		Booking booking = bookingService.findOne(id);

 		if(approve != null){
 			if(approve==true){
 				bookingService.processBooking(booking, 3);
 		 		ApplicationContext context = new GenericXmlApplicationContext(SENDER_XML);
 		    	// Publish to "direct" exchange on order.key == directQueue
 		        RabbitTemplate directTemplate =  context.getBean("directTemplate", RabbitTemplate.class);
 		        RabbitTemplate integrateTemplate =  context.getBean("integrateTemplate", RabbitTemplate.class);
 		    	messageService = new MessageServiceImpl();
 		    	messageService.publish(directTemplate, booking,"booking.key");
 		    	messageService.publish(integrateTemplate, booking,"booking.inte");
 			}
 			else{
 				bookingService.processBooking(booking, 2);
 			}
 			return "redirect:/bookings";
 		}
 		
		model.addAttribute("booking", booking);
		return "detailbooking";
	}


	@RequestMapping(value = "/addmemberbooking", method = RequestMethod.GET)
	public String getAddNewItemForm(@ModelAttribute("newBooking") Booking newBooking, Model model) {
		model.addAttribute("rooms", roomService.listAvailableRooms(true));
	   return "memberbookings";
	}
 	
	@RequestMapping(value = "/addmemberbooking", method = RequestMethod.POST)
	public String approveBooking(@ModelAttribute("newBooking") Booking newbooking, HttpServletRequest request, HttpSession session, BindingResult result) {
		
		if(result.hasErrors()) {
			return "memberbookings";
		}
		Booking bookingToBeAdded = new Booking();
		bookingToBeAdded = newbooking;
		
 		try {
 			bookingToBeAdded.setBookingDate(new Date());
 			bookingToBeAdded.setBookingStatus(1);
 			Member curMember = new Member();
 			curMember = (Member)session.getAttribute("member");
 			curMember = memberService.findOne(curMember.getId());
 			bookingToBeAdded.setUser(curMember);

 			List<Room> listBookedRooms = new ArrayList<Room>();
 			
 			String select[] = request.getParameterValues("roomid"); 
 			Room room = new Room();
 			long roomID;
 			if (select != null && select.length != 0) {
	 			for (int i = 0; i < select.length; i++) {
	 				room = new Room();
	 				roomID = Long.parseLong(select[i]);
	 				room = roomService.findOne(roomID);
	 				bookingToBeAdded.getRooms().add(room);
	 				room.setBooking(bookingToBeAdded);
	 			}
 			}
 			bookingService.update(bookingToBeAdded);
 			
		 		ApplicationContext context = new GenericXmlApplicationContext(SENDER_XML);
 		    	// Publish to "direct" exchange on order.key == directQueue
 		        RabbitTemplate requestTemplate =  context.getBean("requestTemplate", RabbitTemplate.class);
 		    	messageService.publish(requestTemplate, bookingToBeAdded, "booking.in");
		} catch (Exception up) {
			System.out.println(up.getMessage());
			System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/welcome";
		
	}
	
//	@RequestMapping(value = "/approveBooking", method = RequestMethod.POST)
//	public String getApproveBookingForm(@ModelAttribute("booking") Booking booking) {
//	   return "approveBooking";
//	}
	   
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String processAddNewProductForm( @Valid @ModelAttribute("newProduct") Product productToBeAdded, BindingResult result) {
//		if(result.hasErrors()) {
//			return "addProduct";
//		}
//
// 		try {
//			productService.save(productToBeAdded);
//		} catch (Exception up) {
//	      System.out.println("Transaction Failed!!!");
// 
//		}
//		
//	   	return "redirect:/bookings";
//	}
//	
   
}
