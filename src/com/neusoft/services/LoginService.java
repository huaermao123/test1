package com.neusoft.services;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.entity.Account;

/**
 * ҵ���߼���
 * */
public class LoginService {

	
	 /**
	  * �����¼ҵ���߼���
	  * @param username �û���
	  * @param password ����
	  * @return true:��¼�ɹ� 
	  * */
	public Account  doLogin(Account mAccount)  {
		
		
		//��ȡAccountDao��ʵ����
       AccountDao accDao=DaoFactory.getInstance("accDao", AccountDao.class);
       Account acc=null;
       
       try {
    	 //�����û����������ѯ�û��Ƿ����
   		 acc=accDao.doLogin(mAccount.getUsername(), mAccount.getPassword());
   		 if(acc!=null) {
   			 acc.setLogindate(System.currentTimeMillis());
   			 acc.setIp(mAccount.getIp());
   			 //�����û����ĵ�¼��ַ�͵�¼ʱ��
   			 accDao.update(acc);
   		 }
   		  
       }catch(DaoException e) {
    	   e.printStackTrace();
       }
		return acc;
	}
	
}
