package com.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CustomerDao;
import com.model.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getAllCustomer() {
		List <Customer> customer = null;
		try {
			Transaction transaction = null;
			Session session = sessionFactory.getCurrentSession();
			String hql = "SELECT c from Customers c";
			Query query = session.createQuery(hql);
			customer = query.getResultList();
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@Override
	public Customer findAllCustomer(int id) {
		Customer customer = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			customer = session.get(Customer.class, id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean isInserted = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(customer);
			isInserted = true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return isInserted;
	}

	@Override
	public boolean updateCustomer(Customer customerInfo) {
		boolean isUpdated = false;
		try {
			Session session = sessionFactory.getCurrentSession();
			Customer customer = session.get(Customer.class, customerInfo.getId());
			customer.setName(customerInfo.getName());
			customer.setAge(customerInfo.getAge());
			customer.setPhone_Number(customerInfo.getPhone_Number());
			customer.setUpdatedAt(customerInfo.getUpdatedAt());
			session.update(customer);
			isUpdated = true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return isUpdated;
	}

	@Override
	public boolean deleteCustomer(int id) {
		boolean isDeleted =  false;
		try {
			Session session = sessionFactory.getCurrentSession();
			Customer customer = session.get(Customer.class, id);
			session.delete(customer);
			isDeleted = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
