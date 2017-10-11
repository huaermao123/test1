package com.neusoft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginService;

/**
 * Servlet implementatio    n class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    	String value=config.getInitParameter("driver");
    	System.out.println(value);
    	
    } 
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=\"utf-8\"");
		request.setCharacterEncoding("utf-8");
	  
		//获取servletConfig引用 
		ServletConfig config=this.getServletConfig();
		
		Enumeration<String> names=config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name=names.nextElement();
			String value=config.getInitParameter(name);
			System.out.println(name+":"+value);
		}
		
		//获取ServletContext引用
		ServletContext sContext=this.getServletContext();
		String encoding=sContext.getInitParameter("encoding");
		System.out.println("encoding="+encoding);
	  // System.out.println(user);
	  // System.out.println(psw);
	 
	   PrintWriter pw = response.getWriter();
	   pw.append("<html>");
	   pw.append("<head>");
	   pw.append("<title>");
	   pw.append("欢迎进入管理员登录界面");
	   pw.append("</title>");
	   pw.append("</head>");	
	   pw.append("<body  style=\"background-image: url(images/5.jpg);background-size: 100%  100%;\">");
	   pw.append("<div style=\"width: 350px;height: 550px;margin: 150px auto;position: relative;border-radius: 10px;\">");
	   pw.append("<div style=\"width: 350px;height: 25%;background-color: #87E44E;\">");
	   pw.append("<span style=\"font-family: '微软雅黑';color: white;font-size: 40px;position: absolute;top: 30px;left: 10px;\" >");
	   pw.append("欢迎登录");
	   pw.append("</span>");
	   pw.append("</div>");
	   pw.append("<form method=\"post\" action=\"\" >");
	   pw.append("<div style=\"width: 350px;height: 300px;background-color:#aaa\">");
	   pw.append("<input type=\"text\" name=\"username\"placeholder=\"用户名\" size=\"40\" style=\"height: 30px;position: absolute;left: 20px;top: 200px;border: hidden;border-bottom: 1px solid black;border-radius:10px\"/>");
	   pw.append("<input type=\"password\" name=\"password\" placeholder=\"密码\" size=\"40\" style=\"height: 30px;position: absolute;left: 20px;top: 250px;border: hidden;border-bottom: 1px solid black;border-radius:10px\"/>");
	   pw.append("<input type=\"checkbox\" name=\"checkbox\" style=\"position:absolute;top: 310px;left: 15px;\" value=\"1\" />");
	   pw.append("<input type=\"hidden\" name=\"type\" value=\"1\" />");
		  
	   pw.append("<span style=\"position: absolute; top: 310px;left: 33px;color: white;font-family: '微软雅黑';font-size: 15px;\">下次自动登录</span>");
	   pw.append("<a style=\"position:absolute;top: 310px;left: 268px;\" href=\"#\">忘记密码</a>");
	   pw.append("<button style=\"background-color: #87E44E;position: absolute;top: 380px;border: hidden;height: 50px;width: 330px;left: 10px;color: white;font: '微软雅黑';font-size: 20px;border-radius: 10px;box-shadow: 0px 5px 10px green;\">登录</button>");
	   pw.append("</div>"); 
	   pw.append("</form>");
	   pw.append("</div>");
	   pw.append("</body>");  
	   pw.append("</html>");
	   String user = request.getParameter("username");
	   String psw = request.getParameter("password");
	   String type=request.getParameter("type");
	
	   
	   
	    if(type!=null&&!type.equals("")&&type.equals("1")) {//点击登录按钮，登录操作
	    	 if(user==null||user.equals(""))
	  	   {
	  		   pw.append("<script>alert(\"用户名不能为空\")</script>");
	  		   return;
	  	   }
	  	   if(psw==null||psw.equals(""))
	  		
	  	   {
	  		   pw.append("<script>alert(\"密码不能为空\")</script>");
	  		   return;
	  	   }
	  	   LoginService ls = new LoginService();
	  	   
	  	   Account acc=new Account(user,psw,request.getRemoteAddr());
	  	   acc = ls.doLogin(acc);
	  	  System.out.println(user);
	  	  System.out.println(acc);
	  	   if(acc!=null)
	  	   {
	  		   
	  		 String isChecked=request.getParameter("checkbox");
				System.out.println(isChecked);
				 //密码
				Cookie username_cookie=new Cookie("username_cookie",URLEncoder.encode(user,"utf-8"));
				username_cookie.setMaxAge(7*24*60*60);
				Cookie password_cookie=new Cookie("password_cookie",psw);
				username_cookie.setMaxAge(7*24*60*60);
				
				response.addCookie(username_cookie);
				response.addCookie(password_cookie);
	  		   //pw.append("<script>alert(\"success\")</script>");\
				 
				request.setAttribute("acc", acc);
			  	 request.getRequestDispatcher("index.jsp").forward(request, response);
	  	   				}
	  	 
	    else
	  	        { 
	  		   pw.append("<script>alert(\"对不起,登录失败!\")</script>");
	  		  //request.setAttribute("acc", new Account("admin","admin","127.0.0.1"));
	  		  // this.getServletContext().setAttribute("acc", new Account("admin","admin","127.0.0.1"));
	  		// request.getServletContext().setAttribute("acc", acc);
	  		   //response.sendRedirect("login");
	  		 //request.getRequestDispatcher("/login").forward(request, response);
	  	   }
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
