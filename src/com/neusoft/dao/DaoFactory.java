package com.neusoft.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

	/**
	 *  ͨ����ȡ�����ļ���ʵ����ʵ�������
	 */
	
	private static Properties ps = new Properties();
	
	static {
	 InputStream is = 	Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
	 try {
		ps.load(is);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/**
	 * ����ʵ��������
	 */
	
	public static <T>  T getInstance(String daoname,Class<T>cls) {
		T t=null;
		if(daoname==null||"".equals(daoname)) {
			return t;
		}
		
		String className= ps.getProperty(daoname);
		if(className==null||"".equals(className)) {
			return t ;
		}
		try {
			Class<?> clzz= Class.forName(className);
			  t = (T)clzz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
