package com.hcl;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;






@RestController
public class MainController {
	@Autowired 
	Services service;
	
	@RequestMapping(value = "/")
	public ModelAndView hello(){
		return  new ModelAndView("hello");
		
	}
	@RequestMapping(value = "/save")
	public ModelAndView save(@ModelAttribute User user){
		System.out.println("Inside controller");
		service.saveUser(user);
		return new  ModelAndView("redirect:/list");
		//return  "success";
		
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView listUser(@ModelAttribute("users") User users){
		
		List<User> user = service.listUser(users);
		return new ModelAndView("listUser","User",user);
		
	}
	@RequestMapping(value = "/delete")
	public ModelAndView deleteUserById(HttpServletRequest request, @ModelAttribute("customer") User user) {
		int userId = Integer.parseInt(request.getParameter("id"));
		service.deleteUserById(userId);
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping("/edit")
	public ModelAndView editCustomer(@ModelAttribute("users") User users, HttpServletRequest request) {
		List<User> list = service.allUser();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("EDIT ID" + id);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		User user = service.editCustomer(id);
		ModelAndView modelAndView = new ModelAndView("Edit", "list", list);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@RequestMapping("/Update")
	public ModelAndView updateCustomer(@ModelAttribute("user") User user, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int userId =  (int) session.getAttribute("id");
		System.out.println("userId" + userId);
		service.updateCustomer(userId,user);
		return new ModelAndView("redirect:/list");
	}
}
