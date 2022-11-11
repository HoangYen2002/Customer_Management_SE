package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.model.Customer;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	public Customer findAllCustomer(int id) {
		return customerDao.findAllCustomer(id);
	}

	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}


	public boolean updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}


	public boolean deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}

}
