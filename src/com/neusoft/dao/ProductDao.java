package com.neusoft.dao;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public interface ProductDao {
	
	
	
	
	/**
	 * 
	 * @param pro
	 * @return
	 * @throws ��ҳ��ѯ
	 */
	
	public PageModel<Cate>  getproductByPage(int pageNo,int pageSize) throws DaoException;
	

	
	
	
	
	
	
	
	/*
	 * ���
	 * ��Ʒ��
	 *
	 * */
	public int insert(Product  pro)throws DaoException;
	
	
	/*
	 * ɾ��
	 */
	public int deleteDept(Integer dept_id)throws DaoException;
	
}
