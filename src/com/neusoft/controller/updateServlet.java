package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.services.CateService;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Cate> ddlist2;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		
		PrintWriter out = response.getWriter();
		 //²éÑ¯=================================
		   CateService sCate2= new CateService();
		  List<Cate> ddlist2= sCate2.getCateList();  
		  System.out.println(ddlist2);
		  request.setAttribute("ddlist2", ddlist2);
		 
			  request.getRequestDispatcher("xiugai.jsp").forward(request, response);
            
		
		
		  
		  
		  
		  
		//ÐÞ¸Ä=================================
		  String _cname= request.getParameter("cname2");
		  String _cid= request.getParameter("u_cid");
		
		  System.out.println(_cid);
		  System.out.println(_cname);
		
			 
		  if(_cid!=null&&!_cid.equals("")) {
			  int cid=Integer.parseInt(_cid);
			  Cate cate =new Cate(cid,_cname);
			  sCate2.updateCate(cate);	
				 

			  }	 
		 // request.getRequestDispatcher("GetAllServlet").forward(request, response);

	}
	  	
	  
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
