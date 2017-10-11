<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.*,com.neusoft.entity.*"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
      <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/xiugai_01.css" />
	</head>
	<body>
	<form action="updateServlet" method="post">
		<div id="zhong">
			<div id="_span"><span>你的位置：商品类别</span></div>
			<div id="_add_lm"> <input type="text" name="cname2" placeholder="添加商品的子类"/>&nbsp;&nbsp;
			   <select name="u_cid">
			   
			   <c:forEach items="${ddlist2}" var="item2" varStatus="status">  
			   <option value="${item2.cid}">${item2.cname}</option> 
			 </c:forEach>  
			   </select>&nbsp;&nbsp;
			   <button>修改</button>
			</div>	
		</div>	
		</form>
	</body>
</html>
