package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;

public class CateDaoImpl implements CateDao {

	/*
     * �޸Ĳ���
     * */
/*	public static void main(String[] args) {
		    Cate pid=new Cate(63,"fasdf",63);
		    int c =  new CateDaoImpl().updateCate(pid);
	
			 System.out.println(c);
	}
	*/
	QueryRunner qr = new QueryRunner();
	@Override
	public int insert(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		//��ȡ����
				Connection conn=ConnectionFactory.getInstance().getConnection();
		//׼�����
		String sql="insert into Cate(cname,pid)value(?,?)";
		try {
			return qr.update(conn,sql,cate.getCname(),cate.getPid());		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new  DaoException("��ӳ���",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
				//return 0;
	}
     
	 /*
	  * ɾ��  ����pid
	  * */
	@Override
	public int deleteCate(Integer pid,Integer cid) throws DaoException {
		// TODO Auto-generated method stub
		
		//��ȡ����
		Connection conn=ConnectionFactory.getInstance().getConnection();
       //׼�����
          String sql="delete from Cate where pid=? or cid=?";
          try {
        	  
  			return qr.update(conn,sql,pid,cid);		
  		}catch(SQLException e) {
  			e.printStackTrace();
  			throw new  DaoException("ɾ������",e);
  		}finally {
  			DbUtils.closeQuietly(conn);
  		}
	}

	/*
	 * �޸ģ�����ID �޸ģ�
	 */
	@Override
	public int updateCate(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		
		//��ȡ����
				Connection conn=ConnectionFactory.getInstance().getConnection();
		       //׼�����
				String sql="update cate set cname=? where cid=?";
			     try {
			    	 return qr.update(conn,sql,cate.getCname(),cate.getCid());
			     }catch(SQLException e) {
			  			e.printStackTrace();
			  			throw new  DaoException("�޸ĳ���",e);
			  		}finally {
			  			DbUtils.closeQuietly(conn);
			  		}
	}
	
	/*
	 * ��ѯ������Ϣ
	 */
	@Override
	public List<Cate> getCateList() throws DaoException {
		// TODO Auto-generated method stub
		//��ȡ����
		Connection conn=ConnectionFactory.getInstance().getConnection();
       //׼�����
		String sql="select cid ,cname,pid from Cate order by cid desc";
		
		List<Cate> list=new  ArrayList<Cate>();
		
	     try {
			    ResultSetHandler<List<Cate>> rsh = new BeanListHandler<Cate>(Cate.class);
			    list = qr.query(conn, sql,rsh);
	  		}catch(SQLException e) {
	  			e.printStackTrace();
	  			throw new  DaoException("��ѯ����",e);
	  		}finally {
	  			DbUtils.closeQuietly(conn);
	  		}
	     return list;
	}
	/*
	 *ͨ��id����ѯ
	 */
	@Override
	public Cate getCateIdDept(Integer cid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *ͨ��cname����ѯ
	 */
	@Override
	public List<Cate> getCateList(String cname) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *��ҳ
	 */

	@Override
	public PageModel<Cate> getCatesByPage(int pageNo, int pageSize) throws DaoException {
		// TODO Auto-generated method stub
	
		PageModel<Cate>  model=null;
		
		//��ȡ����
		Connection conn=ConnectionFactory.getInstance().getConnection();
				
		 //sql
		String totalcount_sql="select count(cid) from cate";
		//��ѯ�ܵļ�¼  ScalarHandler:��һ�е�һ�е�ֵ
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		try {
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			
			if(totalcount>0) {
				model=new PageModel<Cate>();
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql="select cid ,cname,pid from cate order by cid desc limit ?,?";
			    Object[] params= {(pageNo-1)*pageSize,pageSize};
				List<Cate> msgs=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class), params);
			 
				model.setDatas(msgs);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("��ҳ��ѯ��������",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return model;
	}
	
	
	/**
	 * ɾ������
	 * =======================================================================================================
	 */
	@Override
	public Cate rearchId(Integer cid) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from cate where cid =?";
		ResultSetHandler<Cate> rs = new BeanHandler<>(Cate.class);
		Cate tb = null;
		try {
			tb = qr.query(conn, sql, rs, cid);
			if(tb!=null)
			{
				return tb;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	
	public Integer delRegion(Integer cid)
	{
		Connection conn = null;
		try
		{
			conn = ConnectionFactory.getInstance().getConnection();
			ConnectionFactory.beginTransaction(conn);
			Cate currentNode = rearchId(cid);
			recursionDelNode(conn,cid);
			//������ڵ���û���ӽڵ�
			if(currentNode.getPid()==0)
			{
				currentNode.setPid(0);
			}
			//�ύ����
			ConnectionFactory.commitTransaction(conn);
		}catch(Exception e)
		{
			e.printStackTrace();
			ConnectionFactory.rollbackTransaction(conn);
		}finally
		{
			ConnectionFactory.resetConnection(conn);
			DbUtils.closeQuietly(conn);
		}
		return 1;
	}
	
	/**
	 * �ݹ�ɾ��
	 * @param conn
	 * @param cid
	 * 
	 * 
	 */
	public void  recursionDelNode(Connection conn, Integer cid)throws  SQLException{
		String sql ="select cid,cname,pid from cate where pid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = ConnectionFactory.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(0==rs.getInt("pid"))
				{
					recursionDelNode(conn, rs.getInt("cid"));
				}
				delNode(conn,rs.getInt("cid"));
			}
			//ɾ������
			delNode(conn,cid);
		
		}finally
		{
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(pstmt);
		}
		
	}
	/**
	 * ɾ���ڵ�
	 * @param conn
	 * @param int1
	 */
	private void delNode(Connection conn, int cid)throws SQLException {
		String sql ="delete from cate where cid=?";
		PreparedStatement pstmt  = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
		}finally
		{
			DbUtils.closeQuietly(pstmt);
		}
		
	}


	



	
	
}
