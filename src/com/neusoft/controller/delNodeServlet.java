package com.neusoft.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.neusoft.services.CateService;

/**
 * Servlet implementation class delNodeServlet
 */
@WebServlet("/delNodeServlet")
public class delNodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delNodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//=======±àÂë======
		response.setContentType("text/html;charset=\"utf-8\"");
		request.setCharacterEncoding("utf-8");
	  
		
		//É¾³ýµÄ½Úµã
		

		String delId = request.getParameter("cid");
		System.out.println(delId);
		
		if(delId!=null) {
			Integer dd = Integer.parseInt(delId);
			System.out.println(dd);
			CateService ts = new CateService();
			int c= ts.delRegion(dd);
			request.getRequestDispatcher("GetAllServlet").forward(request, response);
             // return;
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
