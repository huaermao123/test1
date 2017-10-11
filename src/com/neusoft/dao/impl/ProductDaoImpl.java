package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.DaoException;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.utils.ConnectionFactory;

public class ProductDaoImpl {
	/*
	 *��ҳ
	 */
	QueryRunner qr = new QueryRunner();

	public PageModel<Product> getproductByPage(int pageNo, int pageSize) throws DaoException {
		// TODO Auto-generated method stub
	
		PageModel<Product>  model=null;
		
		//��ȡ����
		Connection conn=ConnectionFactory.getInstance().getConnection();
				
		 //sql
		String totalcount_sql="select count(id) from product";
		//��ѯ�ܵļ�¼  ScalarHandler:��һ�е�һ�е�ֵ
		ResultSetHandler<Long> rsh=new ScalarHandler<Long>();
		try {
			Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
			
			if(totalcount>0) {
				model=new PageModel<Product>();
				model.setTotalcount(totalcount);
				//��ҳ��ѯ
				String sql="select cid ,cname,pid from cate order by cid desc limit ?,?";
			    Object[] params= {(pageNo-1)*pageSize,pageSize};
				List<Product> msgs=qr.query(conn, sql, new BeanListHandler<Product>(Product.class), params);
			 
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 PageModel<Product>  product= new ProductDaoImpl().getproductByPage(0, 1);
				  System.out.println(product);
	}
		
	
	
	
}
