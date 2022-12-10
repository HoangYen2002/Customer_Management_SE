package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {
	public List <Customer> getAllCustomer();
	
	public Customer findAllCustomer(int id);
	
	public boolean addCustomer(Customer customer);
	
	public boolean updateCustomer(Customer customer);
	
	public boolean deleteCustomer(int id);
	
}
