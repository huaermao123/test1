<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.qqq tr:hover, .qqq tr.altrow{
	background-color:#999;
}
</style>
<script type="text/javaScript">
function change_pic1()
{
	alert('是否收藏！');
	var imgObj=document.getElementById("s7");
	imgObj.src="images/8.png"};
  // document.getElementById("s7").onclick(function(){change_pic()});
  //document.getElementById("s8").onclick(function(){change_pic()});

function change_pic2()
{
	alert('是否收藏！');
	var imgObj=document.getElementById("s8");
	imgObj.src="images/8.png"};

function change_pic3()
{
	alert('是否收藏！');
	var imgObj=document.getElementById("s9");
	imgObj.src="images/8.png"};

function change_pic4()
{
	alert('是否收藏！');
	var imgObj=document.getElementById("s10");
	imgObj.src="images/8.png"};





function check()
  {
	var oInput=document.getElementsByName("product");
	for(var i=0;i<oInput.length;i++){
		if(document.getElementById("all").checked==true){
			oInput[i].checked=true;
   }
  else{
	  oInput[i].checked=false;
	     }
	    }
	  }
</script>


	<link rel="stylesheet" href="css/ShopManager.css" />
</head>

<body>
	
	<div id="address"><p>你的位置：商品管理</p>
			<div id="bj_head">
			 <button class="tj">添加</button>
			 <button class="sc">删除</button>
			 <button class="hs">回收站</button>
			 <input type="text" placeholder="商品编号/名称"/>
			 <button class="ssuo">搜索</button>
			</div>
		</div>	
	
	
<table class="qqq" border="0" width="2500px"  cellpadding="0" cellpadding="0" class="bg">
	<form  method="post">
    	<tr>
        	<td style="height:40px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr atyle="font-weight:bold;">
        	<td ><input id="all" type="checkbox" value="全选" onclick="check();"/>全选</td>
            <td>商品图片</td>
            <td>商品名称/出售者/联系方式</td>
            <td>价格</td>
        </tr>
        <tr>
        	<td colspan="4"> <hr style="border:1px #cccccc dashed"/></td>
        </tr>
        
        <tr>
       	  <td><input name="product" type="checkbox" value="1"></td>
            <td><img src="img/digua.jpg" alt="alt" width="86" height="63" /></td>
          <td>地瓜，水果特色，超现实享受<br/>
            出售者：ling112233<br/>
       
       	      <input type="submit" name="hwlx" id="hwlx" value="和我联系" onclick="javascript:alert('电话号：12345678917')" >
       	         	  
            &nbsp;&nbsp;
       		  <img src="images/7.png"alt="alt" id="s7" width="27" height="25" onClick="change_pic1()"/>收藏
          </td>
          <td>
          	一口价<br/>2833.0
          </td>
        </tr>
         <tr>
        	<td colspan="4"> <hr style="border:1px #cccccc dashed"/></td>
        </tr>
        
        <tr>
       	  <td><input name="product" type="checkbox" value="2"></td>
            <td><img src="img/banala.jpg" alt="alt" width="86" height="63" /></td>
          <td>香蕉，水果鲜美，超现实享受<br/>
            出售者：ling112233<br/>
          <input type="submit" name="hwlx" id="hwlx" value="和我联系" onclick="javascript:alert('电话号：12345678917')" >
       	         	  
            &nbsp;&nbsp;
       		  <img src="images/7.png"alt="alt" id="s8" width="27" height="25" onClick="change_pic2()"/>收藏

          </td>
          <td>
          	一口价<br/>2833.0
          </td>
        </tr>
         <tr>
        	<td colspan="4"> <hr style="border:1px #cccccc dashed"/></td>
        </tr>
        
        <tr>
       	  <td><input name="product" type="checkbox" value="3"></td>
            <td><img src="img/liulian.jpg"alt="alt" width="86" height="63" /></td>
          <td>榴莲，有种浓浓的香味，超现实享受<br/>
            出售者：ling112233<br/>
           	 <input type="submit" name="hwlx" id="hwlx" value="和我联系" onclick="javascript:alert('电话号：12345678917')" >
       	         	  
            &nbsp;&nbsp;
       		        		  <img src="images/7.png"alt="alt" id="s9" width="27" height="25" onClick="change_pic3()"/>收藏

          </td>
          <td>
          	一口价<br/>2833.0
          </td>
        </tr>
         <tr>
        	<td colspan="4"> <hr style="border:1px #cccccc dashed"/></td>
        </tr>
        
        <tr>
       	  <td><input name="product" type="checkbox" value="4"></td>
            <td><img src="img/huanggua.jpg"alt="alt" width="86" height="63" /></td>
          <td>黄瓜，新鲜蔬菜，超现实享受<br/>
            出售者：ling112233<br/>
           	 <input type="submit" name="hwlx" id="hwlx" value="和我联系" onclick="javascript:alert('电话号：12345678917')" >
       	         	  
            &nbsp;&nbsp;
       		        		  <img src="images/7.png"alt="alt" id="s10" width="27" height="25" onClick="change_pic4()"/>收藏

          </td>
          <td>
          	一口价<br/>2833.0
          </td>
        </tr>
        <tr>
        	<td colspan="4"><hr style="border:1px #cccccc dashed"/></td>
        </tr>
	</form>
 </table>
</body>
</html>
