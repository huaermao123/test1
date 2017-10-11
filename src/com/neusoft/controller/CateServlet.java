package com.neusoft.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.services.CateService;
import com.neusoft.services.getByPageService;

/**
 * Servlet implementation class CateServlet
 */
@WebServlet("/CateServlet")
public class CateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=\"utf-8\"");
		request.setCharacterEncoding("utf-8");
		/*
		 * 分页的查询
		 */
		getByPageService GetPage= new getByPageService();
		GetPage.getCatesLogic(request, response);
	    request.getRequestDispatcher("CateServlet?pageNo=1&pageSize=5").forward(request, response);
	  
		//修改=================================
	    CateService  sCate2= new CateService();
		  String _cname= request.getParameter("cname2");
		  String _cid= request.getParameter("u_cid");
		
		  System.out.println(_cid);
		  System.out.println(_cname);
		
			 
		  if(_cid!=null&&!_cid.equals("")) {
			  int cid=Integer.parseInt(_cid);
			  Cate cate =new Cate(cid,_cname);
			  sCate2.updateCate(cate);	
			  }	 
		 
			    	
			    	
			    	

	

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
