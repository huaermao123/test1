package com.neusoft.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.entity.Account;
import com.neusoft.services.LoginService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		//����
		Cookie[] cookies=request.getCookies();
		Cookie username_cookie=null;//�û�����cookie
		Cookie psw_cookie=null;//����cookie
		String username=null;//��Cookie�л�ȡ�û���
		String password=null;//��Cookie�л�ȡ����
		if(cookies!=null&&cookies.length>0) {
			System.out.println(cookies.length);
			for(Cookie c:cookies) {
				String name=c.getName();
				String  value=c.getValue();
				
				if(name!=null&&name.equals("username_cookie")) {
					//����
					username=URLDecoder.decode(value,"utf-8");
					System.out.println("ת���username="+username);
					username_cookie=c;
				}
				if(name!=null&&name.equals("password_cookie")) {
					password=value;
					System.out.println(password);
					psw_cookie=c;
				}
			}
		}
		//��cookie�л�ȡ�����û�����
		if(username!=null&&password!=null) {

		              LoginService ls=new LoginService();
		              Account acc=new Account(username,password,request.getRemoteAddr());
					 acc=ls.doLogin(acc);

					 if(acc!=null) { //��¼�ɹ�
						 
						 HttpSession session=request.getSession();
						 session.setAttribute("acc", acc);
						 
						 request.getRequestDispatcher("index.jsp").forward(request, response);
					 }else {
						 
						 //����ʧЧ
						 username_cookie.setMaxAge(0);
						 psw_cookie.setMaxAge(0);
						 response.addCookie(psw_cookie);
						 response.sendRedirect("/login");
					 }
				}
					
				//System.out.println("===doFilter===");
				chain.doFilter(req, resp);
			}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
