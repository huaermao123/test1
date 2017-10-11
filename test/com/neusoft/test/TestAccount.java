package com.neusoft.test;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.DaoFactory;
import com.neusoft.entity.Account;

public class TestAccount {

	public static void main(String[] args) {
		testLogin();
	}
	
	public static void testLogin() {
		
		AccountDao accDao=DaoFactory.getInstance("accDao", AccountDao.class);
		
		Account acc=accDao.doLogin("admin", "admin");
		 if(acc!=null) {
			 acc.setLogindate(System.currentTimeMillis());
			 acc.setIp("10.25.151.170");
			 accDao.update(acc);
		 }
		
		
		
	}
	
}
