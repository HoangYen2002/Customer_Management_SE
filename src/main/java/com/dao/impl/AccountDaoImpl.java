package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.AccountDao;
import com.entity.Account;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account getAccountByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT ACC FROM Account ACC WHERE ACC.userName = :USERNAME";
		Query<Account> query = session.createQuery(hql);
		query.setParameter("USERNAME", userName);
		Account account = (Account) query.uniqueResult();
		return account;
	}

}
