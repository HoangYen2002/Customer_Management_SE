package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Customer;
import com.service.impl.CustomerServiceImpl;

@Controller
public class AdminController {

	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerServiceImpl customerService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "/403";
	}
	
	@GetMapping(value = { "/login" })
	public String login(Model model) {
		return "login";
	}
	
	// ADMIN CO QUYEN XEM HET DANH SACH CUSTOMER
	@RequestMapping(value = {"customer/list"}, method = RequestMethod.GET)
	@ResponseBody
	public List <Customer> getAllCustomer(){
		List<Customer> customer = customerService.getAllCustomer();
		if(customer == null) {
			System.out.println("Not found");
		}
		return customer;
	}
	
	// ADMIN CO QUYEN XOA CUSTOMER
	@DeleteMapping(value = {"customer/delete/{id}"})
	public String deleteCustomer(@PathVariable("id") int id) {
		boolean isDeleted = customerService.deleteCustomer(id);
		if(isDeleted) {
			System.out.println("Delete Customer Successfully.");
		}
		return "redirect:/main/customer/list";
	}
}
