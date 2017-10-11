<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/insert.css" />
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	</head>
	<body>
	
		<div id="big">
		<div id="head_01"><p>当前：添加商品</p></div>
		<form action="" method="get">
			<div id="kuang1">
				<p>商品概要</p>
				<table   width="1000px" height="370px" border="0px" cellpadding="0px" cellspacing="0px">
					<tr>
						<td class="td01">商品名称:</td>
						<td><input id="input01" type="text" placeholder="鱼"/></td>
					</tr>
					<tr>
						<td class="td01">商品分类:</td>
						<td>
							<select id="select_">
								<option>水果</option>
								<option>蔬菜</option>
								<option>生鲜</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td01">单价:</td>
						<td><input class="input02" type="text"/></td>
					</tr>
					<tr>
						<td class="td01">品牌:</td>
						<td><input class="input02" type="text" placeholder="永辉"/></td>
					</tr>
					<tr>
						<td class="td01">商品编号:</td>
						<td><input class="input02" type="text" placeholder="请输入你的编号"/></td>
					</tr>
					<tr>
						<td class="td01">商品类型:</td>
						<td>
							<input  id="checkbox_" type="radio" name="ss" value="实物"  onclick="te()"/>实物
						    <input type="radio" value="虚拟商品" name="ca"/>虚拟商品
						</td>
					</tr>
					<tr>
						<td class="td01">重量</td>
						<td><input class="input02" type="text"/>千克(Kg)(选填)</td>
					</tr>
				
					
				</table>
			</div>
			
			<div id="kuang2">
				<p id="_p">商品图片</p>
				<div class="fx"><p id="yuan"><a href="#">+</a></p></div>
				<div class="fx"><img src="img/huanggua.jpg"/></div>
				<div class="fx"><img src="img/liulian.jpg"/></div>
				<div class="fx"><img src="img/digua.jpg"/></div>
			</div>
			
			<div id="kuang3">
				<p>商品描述</p>
				<textarea  id="editor1" name="editor1" value="商品的描述"></textarea>
				<div id="last_But"><button>提交</button></div>
			</div>
			
		</form>
			  <script>
		 	CKEDITOR.replace("editor1");
		 </script>
		</div>
	
		
	</body>
</html>
