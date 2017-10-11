<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/order.css" />
		<script src="laydate/laydate.js"></script>
	</head>

	<body>
		<div id="order_h"><p>当前位置：订单列表</p>
		</div>
		<div id="shijian">开始：<input class="laydate-icon" onclick="laydate()">
    至:<input class="laydate-icon" id="demo" value="2017-6-20"><button>搜索</button>
		<script>
;!function(){
laydate({
   elem: '#demo'
})
}();
</script>
		</div>
		<form action="" method="post">
			<div id="table1">
				<table id="tb01" id="ccc" border="1px" width="100%" height="200px">
					<tr>
						<td id="td_head01" colspan="4" height="40px"><span id="green"></span><a>订单统计信息</a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</table>
			</div>
			
			<div id="table2">
					<table id="tb01" id="ccc" border="1px" width="100%" height="200px">
					<tr>
						<td  id="td_head01" colspan="4" height="40px"><span id="green"></span><a>实体商品统计信息</a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</table>
			</div>
			
			
			<div id="table3">
					<table id="tb01" id="ccc" border="1px" width="100%" height="200px">
					<tr>
						<td id="td_head01" colspan="4" height="40px"><span id="green"></span><a>虚拟商品统计信息</a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
				</table>
			</div>
			
			
			<div id="table4">
				<table id="tb01" id="ccc" border="1px" width="100%" height="120px">
					<tr>
						<td id="td_head01" colspan="4" height="40px"><span id="green"></span><a>访问统计信息</a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
					
				</table>
			
			
			</div>
			
		</form>
	</body>
</html>
