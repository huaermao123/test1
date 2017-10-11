package com.neusoft.dao;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public interface ProductDao {
	
	
	
	
	/**
	 * 
	 * @param pro
	 * @return
	 * @throws 分页查询
	 */
	
	public PageModel<Cate>  getproductByPage(int pageNo,int pageSize) throws DaoException;
	

	
	
	
	
	
	
	
	/*
	 * 添加
	 * 商品表
	 *
	 * */
	public int insert(Product  pro)throws DaoException;
	
	
	/*
	 * 删除
	 */
	public int deleteDept(Integer dept_id)throws DaoException;
	
}
