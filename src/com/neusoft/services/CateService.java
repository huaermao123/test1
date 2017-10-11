package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.DaoFactory;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;


public class CateService {
	
	CateDao cateDao=DaoFactory.getInstance("cateDao", CateDao.class);
	 /**
	   * 添加
	   */
	public int insert(Cate  cate)throws DaoException{
			  
			 return cateDao.insert(cate);
		}
	/**
	 * 查询所有的
	 */
	public List<Cate> getCateList() throws DaoException{
		return cateDao.getCateList();
	}
	/**
	 * 修改
	 */
	public int updateCate(Cate cate)throws DaoException{
		return    cateDao.updateCate(cate);
	}
	
	
	/**
	 * 删除 父节点
	 */
	public int deleteCate(Integer pid ,Integer cid)throws DaoException{
		return cateDao.deleteCate(pid, cid);
	}
	
	
	
	/**
	 * 
	 */
	public Cate rearchId(Integer cid) {
		return cateDao.rearchId(cid);
	}


	public Integer delRegion(int cid) {
		// TODO Auto-generated method stub
		return new CateDaoImpl().delRegion(cid);
	}
	
	

	
}
