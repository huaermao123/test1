package com.neusoft.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public interface CateDao {
  /**
   * ���
   */
	public int insert(Cate  cate)throws DaoException;
	
	/**
	 * ɾ�� ���ڵ�
	 */
	public int deleteCate(Integer pid ,Integer cid)throws DaoException;
	
	
	/**
	 * �޸�
	 */
	public int updateCate(Cate cate)throws DaoException;

	/**
	 * ��ѯ���е�
	 */
	public List<Cate> getCateList()throws DaoException;
	
	/**	  
	 * ��ѯͨ��ID
	 */
	public Cate getCateIdDept(Integer cid)throws DaoException;
	
	/**
	 * ��ѯͨ������
	 */
	public List<Cate> getCateList(String cname)throws DaoException;
	

	/**
	 * ��ҳ��ѯ
	 * @param pageNo    ҳ��
	 * @param pageSize  ÿҳ��ʾ���ݵ�����
	 * */
	public PageModel<Cate>  getCatesByPage(int pageNo,int pageSize);
	
	
	
	

	/**
	 * �ݹ�ɾ��
	 * @param conn
	 * @param cid
	 */
	public void  recursionDelNode(Connection conn, Integer cid)throws  SQLException;

	public Cate rearchId(Integer cid);
	
	
}
