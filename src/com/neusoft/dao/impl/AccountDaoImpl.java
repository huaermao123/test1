package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.Account;
import com.neusoft.utils.ConnectionFactory;

public class AccountDaoImpl implements AccountDao {

	 
	private QueryRunner qr=new QueryRunner();
	
	   
	@Override
	public Account doLogin(String username, String password) {
		// TODO Auto-generated method stub
		Account acc=null;
		//��ȡ����
		Connection conn=ConnectionFactory.getInstance().getConnection();
		
		//sql���
		String sql="select id, username,password,ip,logindate from account where username=? and password=?";
		//
		ResultSetHandler<Account> rsh=new BeanHandler<Account>(Account.class);
		Object[] params= {username,password};
		try {
			 acc=qr.query(conn, sql, rsh, params);
			System.out.println(acc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("�û�����������󣬵�¼ʧ��");
		}finally {
			
			DbUtils.closeQuietly(conn);
		}
		
		
		
		return acc;
	}


	@Override
	public boolean update(Account acc) throws DaoException {
		// TODO Auto-generated method stub
		
		//��ȡ����
		Connection conn=ConnectionFactory.getInstance().getConnection();
		
		//sql���
		String sql="update account set ip=?,logindate=? where id=?";
		
		try {
			int count=qr.update(conn, sql, acc.getIp(),acc.getLogindate(),acc.getId());
		     if(count>0) {
		    	 return true;
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("��¼��Ϣ�޸�ʧ��");
		}finally {
			DbUtils.closeQuietly(conn);
		}
		
		return false;
	}

}
