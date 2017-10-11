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
     * 修改测试
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
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
		//准备语句
		String sql="insert into Cate(cname,pid)value(?,?)";
		try {
			return qr.update(conn,sql,cate.getCname(),cate.getPid());		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new  DaoException("添加出错",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
				//return 0;
	}
     
	 /*
	  * 删除  父类pid
	  * */
	@Override
	public int deleteCate(Integer pid,Integer cid) throws DaoException {
		// TODO Auto-generated method stub
		
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
       //准备语句
          String sql="delete from Cate where pid=? or cid=?";
          try {
        	  
  			return qr.update(conn,sql,pid,cid);		
  		}catch(SQLException e) {
  			e.printStackTrace();
  			throw new  DaoException("删除出错",e);
  		}finally {
  			DbUtils.closeQuietly(conn);
  		}
	}

	/*
	 * 修改（根据ID 修改）
	 */
	@Override
	public int updateCate(Cate cate) throws DaoException {
		// TODO Auto-generated method stub
		
		//获取连接
				Connection conn=ConnectionFactory.getInstance().getConnection();
		       //准备语句
				String sql="update cate set cname=? where cid=?";
			     try {
			    	 return qr.update(conn,sql,cate.getCname(),cate.getCid());
			     }catch(SQLException e) {
			  			e.printStackTrace();
			  			throw new  DaoException("修改出错",e);
			  		}finally {
			  			DbUtils.closeQuietly(conn);
			  		}
	}
	
	/*
	 * 查询所有信息
	 */
	@Override
	public List<Cate> getCateList() throws DaoException {
		// TODO Auto-generated method stub
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
       //准备语句
		String sql="select cid ,cname,pid from Cate order by cid desc";
		
		List<Cate> list=new  ArrayList<Cate>();
		
	     try {
			    ResultSetHandler<List<Cate>> rsh = new BeanListHandler<Cate>(Cate.class);
			    list = qr.query(conn, sql,rsh);
	  		}catch(SQLException e) {
	  			e.printStackTrace();
	  			throw new  DaoException("查询出错",e);
	  		}finally {
	  			DbUtils.closeQuietly(conn);
	  		}
	     return list;
	}
	/*
	 *通过id来查询
	 */
	@Override
	public Cate getCateIdDept(Integer cid) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *通过cname来查询
	 */
	@Override
	public List<Cate> getCateList(String cname) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *分页
	 */

	@Override
	public PageModel<Cate> getCatesByPage(int pageNo, int pageSize) throws DaoException {
		// TODO Auto-generated method stub
	
		PageModel<Cate>  model=null;
		
		//获取连接
		Connection conn=ConnectionFactory.getInstance().getConnection();
				
		 //sql
		String totalcount_sql="select count(cid) from cate";
		//查询总的记录  ScalarHandler:第一行第一列的值
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		try {
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			
			if(totalcount>0) {
				model=new PageModel<Cate>();
				model.setTotalcount(totalcount);
				//分页查询
				String sql="select cid ,cname,pid from cate order by cid desc limit ?,?";
			    Object[] params= {(pageNo-1)*pageSize,pageSize};
				List<Cate> msgs=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class), params);
			 
				model.setDatas(msgs);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("分页查询出错。。。",e);
		}finally {
			DbUtils.closeQuietly(conn);
		}
		return model;
	}
	
	
	/**
	 * 删除分类
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
			//如果父节点下没有子节点
			if(currentNode.getPid()==0)
			{
				currentNode.setPid(0);
			}
			//提交事务
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
	 * 递归删除
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
			//删除自身
			delNode(conn,cid);
		
		}finally
		{
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(pstmt);
		}
		
	}
	/**
	 * 删除节点
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
