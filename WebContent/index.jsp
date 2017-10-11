<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.neusoft.entity.*,java.text.*" %> 
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet"  href="css/index.css"/>
<script src="js/_ll.js"></script>
<script src="js/_iframe.js"></script>
	</head>
	<body>

		<div id="head">
			<img src="img/V.png" />
			<ul>
				<li><a href="#">商品</a></li>
				<li><a href="#">订单</a></li>
				<li><a href="#">会员</a></li>
				<li><a href="#">营销</a></li>
				<li><a href="#">系统</a></li>
				<li><a href="#">账号管理</a></li>
				<li><a href="#">更新缓存</a></li>
			</ul>
		
			 <div id="welcome"><img id="01" src="img/user.png"/><strong>欢迎${acc.username}</strong><img src="img/G.png"/></div>
			
		
		</div>
		 
		<!--下拉表-->
		<div id="libiao">
			<!--
            	描述：商品管理
            -->
			<div id="lb_01">
		    <img id="_img" onclick="_ll()" src="img/55646.png" width="50px" height="50px"/><p>商品管理</p>
		    </div>
		    
		    <div id="shop_li">
		    	
		    	<ul>
		    		<li onclick="_iframe()"><a>商品列表</a></li>
		<li><a  onclick="_iframe1()" >商品分类</a></li>
		    		<li><a onclick="_iframe2()">商品添加</a></li>
		    		<li><a onclick="_iframe3()">商品类别</a></li>
		    	</ul>
		    
		    </div>
		    <!--订单管理-->
		   	<div id="lb_01">
		    <img id="_img2" onclick="_ll2()" src="img/55646.png" width="50px" height="50px"/><p>订单管理</p>
		    </div>
		    
		     <div id="order_gl">
		    	
		    	<ul>
		    		<li onclick="_iframe_order()"><a>商品列表</a></li>
		    	</ul>
		    
		    </div>
		   
		   
		   
		    
		</div>
				
		<div id="_iframe">
			<iframe id="_iframe_nr" src="javascript:window.location.href='CateServlet?pageNo=1&pageSize=5'"  ></iframe>
		</div>
			
	</body>
</html>
