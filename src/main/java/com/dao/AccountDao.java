package com.dao;

import com.entity.Account;

public interface AccountDao {
	public Account getAccountByUserName(String userName);
}
