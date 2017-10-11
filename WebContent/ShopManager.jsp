<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/ShopManager.css" />
	<script type="text/javascript" src="js/ShopManager.js" ></script>
	<script type="text/javascript" src="js/test.js"></script>
	</head>
	<body onload="_onload()">
		<div id="address"><p>你的位置：商品管理</p>
			<div id="bj_head">
			 <button class="tj" onclick="javascript:window.location.href='index2.jsp'" >添加</button>	
			 <button class="sc">删除</button>
			 <button class="hs">回收站</button>
			 <input type="text" placeholder="商品编号/名称"/>
			 <button class="ssuo">搜索</button>
			</div>
			
		</div>	
		<!--列表的展示-->
		<div id="lieb_">
		<form action="" method="get">
			<table id="tf" class="qqq"  width="100%" height="100%">
				<tr>
					<td id="th01"><input id="input" onclick="test()" type="checkbox"/></td>
					<td id="th02">编号</td>
					<td id="th03">名称</td>
					<td id="th04">库存</td>
					<td id="th05">上架</td>
					<td id="th06">排序</td>
					<td id="th07">操作</td>
				</tr>
			</table>
			
			
			
			
			
			
			
		</form>	
		</div>
	</body>
</html>
