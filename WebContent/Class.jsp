<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,com.neusoft.entity.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	<link rel="stylesheet" href="css/Class.css" />
	</head>
	<body>
		<form action="CateServlet?pageNo=1&pageSize=5" method="post">
		<div id="address">
			<div id="span"><span>你的位置：商品类别</span></div>
			<div id="add_lm"> <input type="text" placeholder="添加商品的子类" name="cate_id2" value="鞋"/>
			   <select name="ss2">
			   <% 
			   Object obj2=request.getAttribute("cates");
			   if(obj2!=null){
				   PageModel<Cate> pageModel=(PageModel<Cate>)obj2; 
				   for(int i=0;i<pageModel.getDatas().size();i++){
					%>
					 <option name="_select" value="www"><%=pageModel.getDatas().get(i).getCname() %></option>
					<%   
				   }
			   }
			   
			   %>
						
			   </select>
			   <button   onclick="javascript:window.location.href='GetAllServlet'" >添加</button> 
			   <button onclick="javascript:window.location.href='CateServlet?pageNo=1&pageSize=5'">查询</button>
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
			
			
			 
			 <%
      
           Object obj=request.getAttribute("cates");
          if(obj!=null){// 
        	  PageModel<Cate> pageModel=(PageModel<Cate>)obj;
              
              
          
              for(int i=0;i<pageModel.getDatas().size();i++){ 
              %>
              
              <tr> 	  
				<td name="cid"><%=pageModel.getDatas().get(i).getCid() %></td>
				<td><%=pageModel.getDatas().get(i).getCname() %></td>
				<td><%=pageModel.getDatas().get(i).getPid() %></td>
				<td><a onclick="javascript:window.location.href='updateServlet'">修改</a><img style="width: 15px;height: 15px;" src="img/xiugai.png"/>
				<a onclick="javascript:window.location.href='delNodeServlet'">删除</a> <img style="width: 15px;height: 15px;" src="img/shanchu.png"/></td>	
				</tr> 
              <%}%>
            
			
			  
			
				
			
				
			</table>
			 
		<div id="page">
		
			共<%=pageModel.getTotalcount() %>条记录&nbsp;<%=pageModel.getPageNo() %>/<%=pageModel.getTotalPageSize() %>页&nbsp;&nbsp;
			<a href="CateServlet?pageNo=1&pageSize=5">首页</a>
			<a href="CateServlet?pageNo=<%=pageModel.getPageNo()-1==0?pageModel.getPageNo():pageModel.getPageNo()-1%>&pageSize=5">下页</a>
			<a href="CateServlet?pageNo=<%=pageModel.getPageNo()+1==pageModel.getTotalPageSize()+1?pageModel.getTotalPageSize():pageModel.getPageNo()+1 %>&pageSize=5">上页</a>
		    <a href="CateServlet?pageNo=<%=pageModel.getTotalPageSize() %>&pageSize=5">尾页</a>&nbsp;&nbsp;
			第&nbsp;<select onChange="if(this.value==this.options[this.options.selectedIndex].value){location='CateServlet?&pageNo='+this.value+'&pageSize=5'}">
				
				<% 
				if(pageModel!=null){
		        	   int _totalPageSize=pageModel.getTotalPageSize();
		        	   for(int i=0;i<_totalPageSize;i++){
		        		   
		        		   if(pageModel.getPageNo()==(i+1)){%>
	        		    	
		        		    <option value="<%=i+1 %>" selected="selected"><%=(i+1)%></option>
		        		  <%  }else{%>
		        			  <option value="<%=i+1 %>" ><%=(i+1)%></option>
		        		  <%}
		        	   }
		        	   
				}
				
				
				%>
				
			</select>&nbsp;页
		</div>
		</div>
		
		
		
	  <%}%>
    
		
		</form>
		
	</body>
</html>
