package com.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Customer;
import com.service.impl.CustomerServiceImpl;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerServiceImpl customerService;
	
	@RequestMapping(value = {"customer/list"}, method = RequestMethod.GET)
	@ResponseBody
	public List <Customer> getAllCustomer(){
		List<Customer> customer = customerService.getAllCustomer();
		if(customer == null) {
			System.out.println("Not found");
		}
		return customer;
	}
	
	@GetMapping(value = {"find/{id}"})
	@ResponseBody
	public Customer findAllCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.findAllCustomer(id);
		if(customer == null) {
			System.out.println("Not found");
		}
		return customer;
	}
	
	@PostMapping("customer/insert")
	@ResponseBody
	public String addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = new Customer();
		//newCustomer.setId(customer.getId());
		newCustomer.setName(customer.getName());
		newCustomer.setAge(customer.getAge());
		newCustomer.setPhone_Number(customer.getPhone_Number());
		newCustomer.setUpdatedAt(new Date());
		boolean customerInserted = customerService.addCustomer(customer);
		if(customerInserted) {
			System.out.println("Add New Customer Successfully.");
		}
		return "redirect:/main/customer/list";
	}
	
	
	@PutMapping(value = {"customer/update/{id}"})
	public String updateCustomer(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("age") int age, 
			@RequestParam("phone_Number") String phone_Number ) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setAge(age);
		customer.setPhone_Number(phone_Number);
		customer.setUpdatedAt(new Date());
		boolean isUpdated = customerService.updateCustomer(customer);
		if(isUpdated) {
			System.out.println("Updated Customer Successfully.");
		}
		return "redirect:/main/customer/list";
	}
	
	@DeleteMapping(value = {"customer/delete/{id}"})
	public String deleteCustomer(@PathVariable("id") int id) {
		boolean isDeleted = customerService.deleteCustomer(id);
		if(isDeleted) {
			System.out.println("Delete Customer Successfully.");
		}
		return "redirect:/main/customer/list";
	}
	
	
	
}
