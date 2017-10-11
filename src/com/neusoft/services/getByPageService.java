package com.neusoft.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public class getByPageService {





	/**
	 * 查询业务逻辑
	 * */
	public void getCatesLogic(HttpServletRequest request,HttpServletResponse response) throws DaoException,ServletException,IOException{
		
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		try {
			int _pageNo=Integer.parseInt(pageNo);
			int _pageSize=Integer.parseInt(pageSize);
			
			PageModel<Cate>  cates=getCatesByPage(_pageNo,_pageSize);
			if(cates!=null) {
				int totalPageSize= (cates.getTotalcount()%_pageSize==0?cates.getTotalcount()/_pageSize:cates.getTotalcount()/_pageSize+1);
				cates.setTotalPageSize(totalPageSize);
				cates.setPageNo(_pageNo);
			}
			
			request.setAttribute("cates", cates);
			request.getRequestDispatcher("Class.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
			
	}
	
	


	/**
	 * 分页查询
	 * */
	
	
	
	public  PageModel<Cate>  getCatesByPage(int pageNo,int pageSize) throws DaoException{
		
		
		
		return new CateDaoImpl().getCatesByPage(pageNo, pageSize);
	
		
	}




	
}
