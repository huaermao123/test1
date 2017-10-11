<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,com.neusoft.entity.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <c:forEach items="${cates}" var="item2" varStatus="status">  
 </c:forEach>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	<link rel="stylesheet" href="css/Class.css" />
	</head>
	<body>
		<form action="GetAllServlet" method="post">
		<div id="address">
			<div id="span"><span>你的位置：商品类别</span></div>
			<div id="add_lm"> <input type="text" placeholder="添加商品的子类" name="cate_id2"/>
			   <select name="ss2">
           <c:forEach items="${ddlist}" var="item" varStatus="status">  
						  <option name="_select" value="${item.cid}">${item.cname}</option> 
			 </c:forEach>     	
			   </select>
			   <button>添加</button>
			</div>	
		</div>	
		
		<div id="table_">
		
			<table width="100%" height="30px " border="1px">
				
				<tr>
					<td>商品的子类编号</td>
					<td>商品的类别名</td>
					<td>商品的父类编号</td>
					<td>操作</td>
				</tr>	
				<c:forEach items="${ddlist}" var="item" varStatus="status"> 
				<tr> 	  
				<td name="cid">${item.cid}</td>
				
				<td>${item.cname}</td>
				<td name="pid">${item.pid}</td>
				<td><a onclick="javascript:window.location.href='updateServlet?u_cid=${item2.cid}'">修改</a><img style="width: 15px;height: 15px;" src="img/xiugai.png"/>
				<a onclick="javascript:window.location.href='delNodeServlet?cid=${item.cid}'">删除</a> <img style="width: 15px;height: 15px;" src="img/shanchu.png"/></td>	
				</tr> 
					 
			   </c:forEach> 
				
			
				
			</table>
		</div>
		
		
		
		
		
		</form>
		
	</body>
</html>
