package com.neusoft.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public interface CateDao {
  /**
   * 添加
   */
	public int insert(Cate  cate)throws DaoException;
	
	/**
	 * 删除 父节点
	 */
	public int deleteCate(Integer pid ,Integer cid)throws DaoException;
	
	
	/**
	 * 修改
	 */
	public int updateCate(Cate cate)throws DaoException;

	/**
	 * 查询所有的
	 */
	public List<Cate> getCateList()throws DaoException;
	
	/**	  
	 * 查询通过ID
	 */
	public Cate getCateIdDept(Integer cid)throws DaoException;
	
	/**
	 * 查询通过名称
	 */
	public List<Cate> getCateList(String cname)throws DaoException;
	

	/**
	 * 分页查询
	 * @param pageNo    页数
	 * @param pageSize  每页显示数据的条数
	 * */
	public PageModel<Cate>  getCatesByPage(int pageNo,int pageSize);
	
	
	
	

	/**
	 * 递归删除
	 * @param conn
	 * @param cid
	 */
	public void  recursionDelNode(Connection conn, Integer cid)throws  SQLException;

	public Cate rearchId(Integer cid);
	
	
}
